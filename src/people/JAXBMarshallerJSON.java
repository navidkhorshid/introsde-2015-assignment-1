package people;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import people.generated.ObjectFactory;
import people.generated.PeopleType;

/**
 * Class JAXMarshallerJSON
 * Printing and Generating JSON document from Java objects
 */
public class JAXBMarshallerJSON {
    static ObjectFactory factory = new people.generated.ObjectFactory();
    static PeopleType people = new InitializeData().getSomePeople(); //get some data from InitializeData

    public static void main(String[] args) throws Exception
    {
        //Generating 'people_type.json' using generateJSONDocument(File)
        new JAXBMarshallerJSON().generateJSONDocument(new File("people_type.json"));
    }

    /**
     * Marshaller (Java object to JSON)
     */
    public void generateJSONDocument(File jsonDocument)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            // Adding the Jackson Module to process JAXB annotations
            JaxbAnnotationModule module = new JaxbAnnotationModule();
            // configurations of JSON file
            mapper.registerModule(module);
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
            System.out.println(mapper.writeValueAsString(people)); //Printing 'people_type.json' in output
            mapper.writeValue(jsonDocument, people); //Writes to 'people_type.json'
        }catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }
}