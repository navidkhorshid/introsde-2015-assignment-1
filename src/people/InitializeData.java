package people;

import people.generated.ObjectFactory;
import people.generated.PeopleType;
import people.generated.PersonType;

import static people.Person_HealthProfile_Util.constructPerson;

/**
 * Created by Navid on 10/22/2015.
 *
 * Class InitializeData
 * Including getSomePeople() method to create some data for JAXBMarshaller and JAXBMarshallerJSON
 */
public class InitializeData {

    public PeopleType getSomePeople()
    {
        ObjectFactory factory = new people.generated.ObjectFactory();
        PeopleType people = new PeopleType();


        PersonType person = constructPerson(factory, "1","Paul","Pogba","1973-06-28T15:19:44.000+2:00",
                "2014-05-08T21:16:51.000+2:00", 80, 1.88, 22.63467632);
        people.getPerson().add(person);

        person = constructPerson(factory, "2","Stephan","El Shaarawy","1976-06-25T15:30:14.000+2:00",
                "2015-09-09T01:51:53.000+2:00", 72, 1.78, 22.72440348);
        people.getPerson().add(person);

        person = constructPerson(factory, "3","Mario","Balotelli","1973-01-04T01:33:45.000+2:00",
                "2014-10-18T17:53:31.000+2:00", 88, 1.89, 24.63536855);
        people.getPerson().add(person);

        return people;
    }
}
