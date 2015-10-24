package lab3.model.to;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Calendar;

/**
 * Created by Navid on 10/19/2015.
 *
 * Person Class
 * Including 3 constructors, getters and setters, and a print method
 */
public class Person
{
	private Long personId;
	private String firstname;
	private String lastname;
	private String birthdate;
	private HealthProfile hProfile;	// this is an attribute of the class HealthProfile

	/**
	 * Constructor using (personId, firstname, lastname, birthdate, hProfile)
	 */
	public Person(Long personId, String fname, String lname, String birthdate, HealthProfile hp) {
		this.setPersonId(personId);
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate);
		this.hProfile=hp;
	}

	/**
	 * Constructor using (personId, firstname, lastname, birthdate)
	 */
	public Person(Long personId, String fname, String lname, String birthdate)
	{
		this.setPersonId(personId);
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate);
		this.hProfile=new HealthProfile();
	}

	/**
	 * Constructor using (personId, NodeList)
	 */
	public Person(Long personId, NodeList personDetails)
	{
		this.personId = personId;
		for (int k = 0; k < personDetails.getLength(); k++)
		{
			Node child = personDetails.item(k);
			if (child.getNodeType() != Node.TEXT_NODE)
			{
				switch (child.getNodeName())
				{
					case "firstname":
						this.firstname = (child.getFirstChild().getNodeValue());
						break;
					case "lastname":
						this.lastname = (child.getFirstChild().getNodeValue());
						break;
					case "birthdate":
						this.birthdate = (child.getFirstChild().getNodeValue());
						break;
					case "healthprofile":
						//constructs a new HealthProfile object with <healthprofile> child nodes
						this.hProfile = new HealthProfile(child.getChildNodes());
						break;
					default:
						break;
				}
			}
		}
	}

	public Long getPersonId()
	{
		return personId;
	}

	public void setPersonId(Long personId)
	{
		this.personId = personId;
	}

	public void setPersonId(String personId)
	{
		try
		{
			this.personId = Long.parseLong(personId);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}

	public HealthProfile gethProfile()
	{
		return hProfile;
	}

	public void sethProfile(HealthProfile hProfile)
	{
		this.hProfile = hProfile;
	}

	/**
	 * Prints all the details of Person including his HealthProfile details
	 */
	public void printPerson()
	{
		System.out.println("ID: \t\t" + this.personId);
		System.out.println("Firstname: \t\t" + this.firstname);
		System.out.println("Lastname: \t\t" + this.lastname);
		System.out.println("Birthdate: \t\t" + this.birthdate);
		System.out.println("\t-+[HEALTH PROFILE]+-");
		this.hProfile.printHealthProfile();
	}
}
