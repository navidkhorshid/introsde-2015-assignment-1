package people;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import people.generated.ObjectFactory;
import people.generated.PeopleType;

public class JAXBMarshallerJSON {
    static ObjectFactory factory = new people.generated.ObjectFactory();
    static PeopleType people = new InitializeData().getSomePeople();

    public void generateJSONDocument(File jsonDocument)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            // Adding the Jackson Module to process JAXB annotations
            JaxbAnnotationModule module = new JaxbAnnotationModule();
            // configure as necessary
            mapper.registerModule(module);
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
            System.out.println(mapper.writeValueAsString(people));//PRINT JSON
            mapper.writeValue(jsonDocument, people);//write in .json
        }catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) throws Exception
    {
        String jsonDocument = "people_type.json";
        JAXBMarshallerJSON jaxbMarshallerJSON = new JAXBMarshallerJSON();
        jaxbMarshallerJSON.generateJSONDocument(new File(jsonDocument));
    }
}