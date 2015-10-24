package people;

import java.io.File;
import people.generated.*;
import javax.xml.bind.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import people.generated.ObjectFactory;

/**
 * Class JAXMarshaller
 * Printing and Generating XML document from Java objects
 */
public class JAXBMarshaller {
    static ObjectFactory factory = new people.generated.ObjectFactory();
    static PeopleType people = new InitializeData().getSomePeople(); //get some data from InitializeData

    public static void main(String[] argv)
    {
        //Generating 'people_type.xml' using generateXMLDocument(File)
        new JAXBMarshaller().generateXMLDocument(new File("people_type.xml"));
    }

    /**
     * Marshaller (Java object to XML)
     */
    public void generateXMLDocument(File xmlDocument) {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance("people.generated"); //getting context from '\generated'
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(factory.createPeople(people), stringWriter);
            System.out.println(stringWriter); //Printing 'people_type.xml' in output
            marshaller.marshal(factory.createPeople(people), new FileOutputStream(xmlDocument)); //Writes to 'people_type.xml'
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (JAXBException e) {
            System.out.println(e.toString());
        }
    }
}
