package lab3.model.da;


import lab3.model.to.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Navid on 10/19/2015.
 *
 * Class PersonDA
 * Including methods needed for running codes in BusinessLogic layer.
 * These methods are using Person object in order to fetch data from 'people.xml' file
 * XPATH is used in order fetch those data. Basically, XPATH is working like 'SELECT' queries in databases.
 * That is why most of these methods are 'get*'.
 */
public class PersonDA {
    Document doc;
    XPath xpath;

    /**
     * Constructor for Loading XML file when we call PersonDA() class.
     */
    public PersonDA()
    {
        try
        {
            loadXML();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Initializing XPath object
     */
    public XPath getXPathObj()
    {
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }

    /**
     * Loading 'people.xml' file
     */
    public void loadXML() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse("people.xml");
        getXPathObj();
    }

    /**
     * Gets Person by his ID
     */
    public Person getPerson(Long personId) throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return new Person(personId, node.getChildNodes()); //making a new Person object with his ID and details
    }

    /**
     * Gets Person by his Firstname and Lastname; Although never used in this program
     */
    public Person getPerson(String firstname, String lastname) throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person[firstname='" + firstname + "' and lastname='" + lastname + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return new Person(extractPersonId(node), node.getChildNodes()); //making a new Person object with his ID and details
    }

    /**
     * Gets an ArrayList<Person> of all the people
     */
    public ArrayList<Person> getAllPersons() throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person");
        NodeList personsList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return createPersons(personsList); //Executing createPersons(NodeList) to get an ArrayList<> of people
    }

    /**
     * Gets an ArrayList<Person> of people with a certain Weight condition
     */
    public ArrayList<Person> getPersonsByWeight(String weight, String condition) throws XPathExpressionException
    {
        //This XPath query will return the parent of healthprofile, that is person.
        XPathExpression expr = xpath.compile("/people/person/healthprofile[weight " + condition + "'" + weight + "']/parent::*");
        NodeList personsList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return createPersons(personsList); //Executing createPersons(NodeList) to get an ArrayList<> of people
    }

    /**
     * Accepts NodeList of some persons and converts each of the Nodes to Person object using Person class
     * after converting Nodes to Persons, it will return an ArrayList of <Person>
     */
    public ArrayList<Person> createPersons(NodeList personsList)
    {
        ArrayList<Person> persons = new ArrayList<Person>();
        for(int i=0 ; i < personsList.getLength() ; i++)
        {
            //Constructing a new person with the ID attribute and childnodes of person node
            //Finally adding that person object to an ArrayList of <Person>
            persons.add(new Person(extractPersonId(personsList.item(i)), personsList.item(i).getChildNodes()));
        }
        return persons;
    }

    /**
     * Accepts a person node and returns its ID attribute's value
     */
    public Long extractPersonId(Node node)
    {
        Long pId = Long.parseLong("0");
        try
        {
            pId = Long.parseLong(node.getAttributes().getNamedItem("id").getNodeValue());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return pId;
    }
}

