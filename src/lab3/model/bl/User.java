package lab3.model.bl;

import lab3.model.da.PersonDA;
import lab3.model.to.Person;

import java.util.ArrayList;

/**
 * Created by Navid on 10/20/2015.
 *
 * Class User
 * Including all the methods that are needed to run instructions of Lab 3:
 *      getWeight(Long),getHeight(Long),printAllPeople(),
 *      printPersonHealthProfile(Long),printPeopleByWeight(String, String)
 */
public class User
{
    /**
     * For instruction 3.1.1
     * Gets Weight of an specific Person
     */
    public double getWeight(Long personId) throws Exception
    {
        return new PersonDA().getPerson(personId).gethProfile().getWeight();
    }

    /**
     * For instruction 3.1.2
     * Gets Height of an specific Person
     */
    public double getHeight(Long personId) throws Exception
    {
        return new PersonDA().getPerson(personId).gethProfile().getHeight();
    }

    /**
     * For instruction 3.2
     * Prints all People with their details
     */
    public void printAllPeople() throws Exception
    {
        System.out.println("All the people in database:\n");
        ArrayList<Person> allPersons = new PersonDA().getAllPersons();
        for(Person person : allPersons) //iterating in the arraylist to print details of all the people
        {
            person.printPerson();
            System.out.println("_________________");
        }
        System.out.println("=================\nTotal number of people = " + allPersons.size());
    }

    /**
     * For instruction 3.3
     * Prints only the HealthProfile of an specific person
     */
    public void printPersonHealthProfile(Long personId) throws Exception
    {
        System.out.println("HealthProfile of person with ID#"+personId+":");
        new PersonDA().getPerson(personId).gethProfile().printHealthProfile();
    }

    /**
     * For instruction 3.4
     * Prints people by their Weight condition; like people with weight more than 60kg
     */
    public void printPeopleByWeight(String weight, String condition) throws Exception
    {
        System.out.println("People who have weight "+condition+" "+weight+":\n");
        ArrayList<Person> Persons = new PersonDA().getPersonsByWeight(weight, condition);
        for(Person person : Persons) //iterating in the arraylist to print details of all the people
        {
            person.printPerson();
            System.out.println("_________________");
        }
        System.out.println("=================\nTotal number of people = " + Persons.size());
    }


}
