package people;

import people.generated.*;
import javax.xml.bind.*;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.List;

/**
 * Class JAXUnMarshaller
 * Creating Java objects from an XML file and printing them.
 */
public class JAXBUnMarshaller
{
	public static void main(String[] argv)
	{
		//Reading from 'people_type.xml' and creating Java objects using generateJSONDocument(File)
		new JAXBUnMarshaller().unMarshalXMLDocument(new File("people_type.xml"));
	}

	/**
	 * UnMarshaller (XML to Java objects)
	 */
	public void unMarshalXMLDocument(File xmlDocument)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance("people.generated"); //getting context from '\generated'
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			//setting schema of '.xsd' file
			unMarshaller.setSchema(schemaFactory.newSchema(new File("people_data.xsd")));
			CustomValidationEventHandler validationEventHandler = new CustomValidationEventHandler();
			//Setting event handler to CustomValidationEventHandler
			unMarshaller.setEventHandler(validationEventHandler);
			@SuppressWarnings("unchecked")
			JAXBElement<PeopleType> peopleElement = (JAXBElement<PeopleType>) unMarshaller.unmarshal(xmlDocument);
			PeopleType people = (PeopleType) peopleElement.getValue();
			List<PersonType> personList = people.getPerson();
			//Printing all the Person list using a method from Person_HealthProfile_Util class
			new Person_HealthProfile_Util().printPersonDetails(personList);
		}
        catch (JAXBException e) {
			System.out.println(e.toString());
		}
        catch (SAXException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Validation handler for UnMarshaller
	 */
	class CustomValidationEventHandler implements ValidationEventHandler {
		public boolean handleEvent(ValidationEvent event) {
			if (event.getSeverity() == ValidationEvent.WARNING) {
				return true;
			}
			if ((event.getSeverity() == ValidationEvent.ERROR)
					|| (event.getSeverity() == ValidationEvent.FATAL_ERROR)) {
				System.out.println("Validation Error:" + event.getMessage());
				ValidationEventLocator locator = event.getLocator();
				System.out.println("at line number:" + locator.getLineNumber());
				System.out.println("Unmarshalling Terminated");
				return false;
			}
			return true;
		}
	}
}
