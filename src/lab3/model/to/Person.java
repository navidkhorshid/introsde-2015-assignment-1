package lab3.model.to;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Calendar;

/**
 * Created by Navid on 10/19/2015.
 */
public class Person
{
	private Long personId;
	private String firstname;		// this is an attribute of the class String, and it is 'private'
	private String lastname;		// this is an attribute of the class String
	private String birthdate;
	private HealthProfile hProfile;	// this is an attribute of the class HealthProfile

	public Person(Long personId, String fname, String lname, String birthdate, HealthProfile hp) {
		this.setPersonId(personId);
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate);
		this.hProfile=hp;
	}
	
	public Person(Long personId, String fname, String lname, String birthdate)
	{
		this.setPersonId(personId);
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate);
		this.hProfile=new HealthProfile();
	}
	
	public Person()
	{
		this.firstname="";
		this.lastname="";
		this.hProfile=new HealthProfile();
		this.personId = Math.round(Math.floor(Math.random()*9998)+1);
		this.birthdate = this.getRandomDate();
	}

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

	public void printPerson()
	{
		System.out.println("ID: \t\t" + this.personId);
		System.out.println("Firstname: \t\t" + this.firstname);
		System.out.println("Lastname: \t\t" + this.lastname);
		System.out.println("Birthdate: \t\t" + this.birthdate);
		System.out.println("\t-+[HEALTH PROFILE]+-");
		this.hProfile.printHealthProfile();
	}

	private String getRandomDate()
	{
		int currentYear = Calendar.getInstance().get(Calendar.YEAR); 		// 1. get the current year
		int year = (int) Math.round(Math.random()*(currentYear-1950)+1950); // 2. generate a random year 
																			//    between 1950 and currentYear
		int month = (int) Math.round(Math.floor(Math.random()*11)+1);		// 3. select a random month of the year
		int[] months = new int[]{31,28,30,30,31,30,31,31,30,31,30,31};
		if ((currentYear % 4 == 0) && ((currentYear % 100 != 0) || (currentYear % 400 == 0))) {
			months[1] = 29;
		}
		long day = Math.round(Math.floor(Math.random()*(months[month-1]-1)+1));
		return ""+year+"-"+month+"-"+day;
	}
}
