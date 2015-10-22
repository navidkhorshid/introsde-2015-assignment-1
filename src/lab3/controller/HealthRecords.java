package lab3.controller;

import lab3.model.bl.User;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * Created by Navid on 10/19/2015.
 */
public class HealthRecords
{

	//Uses xpath to implement getWeight
	public void lab3_1_1(long personId)
	{
		User user = new User();
		try
		{
			System.out.println("Weight of person with ID#"+personId+" is: "+user.getWeight((Long) personId));
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//Uses xpath to implement getHeight
	public void lab3_1_2(long personId)
	{
		User user = new User();
		try
		{
			System.out.println("Height of person with ID#" + personId + " is: " + user.getHeight((Long) personId));
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//Prints all people in the list with detail
	public void lab3_2()
	{
		User user = new User();
		try
		{
			user.printAllPeople();
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//prints the HealthProfile of the person by his personId
	public void lab3_3(long personId)
	{
		User user = new User();
		try
		{
			user.printPersonHealthProfile((Long) personId);
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//prints people with specific weight condition
	public void lab3_4(String weight, String condition)
	{
		User user = new User();
		try
		{
			user.printPeopleByWeight(weight, condition);
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}



}