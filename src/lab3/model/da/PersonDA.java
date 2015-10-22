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
 */
public class PersonDA {
    Document doc;
    XPath xpath;

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

    public XPath getXPathObj()
    {
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }

    public void loadXML() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse("people.xml");
        //creating xpath object
        getXPathObj();
    }

    public Person getPerson(Long personId) throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person[@id='" + personId + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return new Person(personId, node.getChildNodes());
    }

    public Person getPerson(String firstname, String lastname) throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person[firstname='" + firstname + "' and lastname='" + lastname + "']");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return new Person(extractPersonId(node), node.getChildNodes());
    }

    public ArrayList<Person> getAllPersons() throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person");
        NodeList personsList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return createPersons(personsList);
    }

    public ArrayList<Person> createPersons(NodeList personsList)
    {
        ArrayList<Person> persons = new ArrayList<Person>();
        for(int i=0 ; i < personsList.getLength() ; i++) {
            NodeList personDetails = personsList.item(i).getChildNodes();
            persons.add(new Person(extractPersonId(personsList.item(i)), personDetails));
        }
        return persons;
    }

    public ArrayList<Person> getPersonsByWeight(String weight, String condition) throws XPathExpressionException
    {
        XPathExpression expr = xpath.compile("/people/person/healthprofile[weight " + condition + "'" + weight + "']/parent::*");
        NodeList personsList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return createPersons(personsList);
    }

    public Long extractPersonId(Node node)
    {
        Long pId = Long.parseLong("0");
        try
        {
            pId = Long.parseLong(node.getAttributes()
                    .getNamedItem("id").getNodeValue());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return pId;
    }
}

