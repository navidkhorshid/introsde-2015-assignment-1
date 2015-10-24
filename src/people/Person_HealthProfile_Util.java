package people;

import people.generated.HealthProfileType;
import people.generated.ObjectFactory;
import people.generated.PersonType;

import java.util.List;

/**
 * Created by Navid on 10/21/2015.
 *
 * Class Person_HealthProfile_Util
 * Including two methods which are used in 'people' project multiple times:
 * constructPerson(ObjectFactory, id, ..., bmi) and printPersonDetails(List<PersonType>)
 */
public class Person_HealthProfile_Util {

    /**
     * Accepting ObjectFactory and PersonType/HealthProfileType details as parameters,
     * in order to set all the attributes of PersonType object
     */
    public static PersonType constructPerson(ObjectFactory factory, String personId ,String firstname, String lastname,
                                             String birthdate, String lastupdate, double weight, double height, double bmi)
    {
        //Setting details for healthProfileType object
        HealthProfileType healthProfileType = factory.createHealthProfileType();
        healthProfileType.setLastupdate(lastupdate);
        healthProfileType.setHeight(height);
        healthProfileType.setWeight(weight);
        healthProfileType.setBmi(bmi);
        //Setting details for personType object
        PersonType personType = factory.createPersonType();
        personType.setId(Integer.valueOf(personId));
        personType.setFirstname(firstname);
        personType.setLastname(lastname);
        personType.setBirthdate(birthdate);
        personType.setHealthprofile(healthProfileType);
        return personType;
    }

    /**
     * Accepting a List of <PersonType> and printing all details for each person
     */
    public void printPersonDetails(List<PersonType> personList)
    {
        for (PersonType person : personList) //Iterating through personList
        {
            System.out.println("ID: \t\t" + person.getId());
            System.out.println("Firstname: \t\t" + person.getFirstname());
            System.out.println("Lastname: \t\t" + person.getLastname());
            System.out.println("Birthdate: \t\t" + person.getBirthdate());
            System.out.println("\t-+[HEALTH PROFILE]+-");
            System.out.println("Last Update: \t" + person.getHealthprofile().getLastupdate());
            System.out.println("Weight: \t\t" + person.getHealthprofile().getWeight());
            System.out.println("Height: \t\t" + person.getHealthprofile().getHeight());
            System.out.println("BMI: \t\t" + person.getHealthprofile().getBmi());
            System.out.println("_________________");
        }
        System.out.println("=================\nTotal number of people = " + personList.size());
    }
}
