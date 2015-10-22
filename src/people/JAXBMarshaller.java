package people;

import java.io.File;
import people.generated.*;
import javax.xml.bind.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import people.generated.ObjectFactory;

public class JAXBMarshaller {
    static ObjectFactory factory = new people.generated.ObjectFactory();
    static PeopleType people = new InitializeData().getSomePeople();

    public void generateXMLDocument(File xmlDocument) {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance("people.generated");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(factory.createPeople(people), stringWriter);
            System.out.println(stringWriter);//printing .xml
            marshaller.marshal(factory.createPeople(people), new FileOutputStream(xmlDocument));//write to .xml
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (JAXBException e) {
            System.out.println(e.toString());
        }
    }

	public static void main(String[] argv)
    {
		String xmlDocument = "people_type.xml";
		JAXBMarshaller jaxbMarshaller = new JAXBMarshaller();
		jaxbMarshaller.generateXMLDocument(new File(xmlDocument));
	}
}
