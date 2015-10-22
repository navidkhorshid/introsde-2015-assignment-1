package lab3.model.bl;

import lab3.model.da.PersonDA;
import lab3.model.to.Person;

import java.util.ArrayList;

/**
 * Created by Navid on 10/20/2015.
 */
public class User
{
    //3.1.1
    public double getWeight(Long personId) throws Exception
    {
        return new PersonDA().getPerson(personId).gethProfile().getWeight();
    }

    //3.1.2
    public double getHeight(Long personId) throws Exception
    {
        return new PersonDA().getPerson(personId).gethProfile().getHeight();
    }

    //3.2
    public void printAllPeople() throws Exception
    {
        System.out.println("All the people in database:\n");
        ArrayList<Person> allPersons = new PersonDA().getAllPersons();
        for(Person person : allPersons)
        {
            person.printPerson();
            System.out.println("_________________");
        }
        System.out.println("=================\nTotal number of people = " + allPersons.size());
    }

    //3.3
    public void printPersonHealthProfile(Long personId) throws Exception
    {
        System.out.println("HealthProfile of person with ID#"+personId+":");
        new PersonDA().getPerson(personId).gethProfile().printHealthProfile();
    }

    //3.4
    public void printPeopleByWeight(String weight, String condition) throws Exception
    {
        System.out.println("People who have weight "+condition+" "+weight+":\n");
        ArrayList<Person> Persons = new PersonDA().getPersonsByWeight(weight, condition);
        for(Person person : Persons)
        {
            person.printPerson();
            System.out.println("_________________");
        }
        System.out.println("=================\nTotal number of people = " + Persons.size());
    }


}
