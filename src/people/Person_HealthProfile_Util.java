package people;

import people.generated.HealthProfileType;
import people.generated.ObjectFactory;
import people.generated.PersonType;

import java.util.List;

/**
 * Created by Navid on 10/21/2015.
 */
public class Person_HealthProfile_Util {

    public static PersonType constructPerson(ObjectFactory factory, String personId ,String firstname, String lastname,
                                             String birthdate, String lastupdate, double weight, double height, double bmi)
    {
        HealthProfileType healthProfileType = factory.createHealthProfileType();
        healthProfileType.setLastupdate(lastupdate);
        healthProfileType.setHeight(height);
        healthProfileType.setWeight(weight);
        healthProfileType.setBmi(bmi);
        PersonType personType = factory.createPersonType();
        personType.setId(Integer.valueOf(personId));
        personType.setFirstname(firstname);
        personType.setLastname(lastname);
        personType.setBirthdate(birthdate);
        personType.setHealthprofile(healthProfileType);
        return personType;
    }

    public void printPersonDetails(List<PersonType> personList)
    {
        for (PersonType person : personList)
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
