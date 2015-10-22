package lab3.model.to;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Navid on 10/19/2015.
 */
public class HealthProfile
{
	private String lastupdate;
	private double weight; // in kg
	private double height; // in m
	private double bmi;

	public HealthProfile(String lastupdate, double weight, double height)
	{
		this.lastupdate = lastupdate;
		this.weight = weight;
		this.height = height;
		this.bmi = weight/(height*height);
	}

	public HealthProfile()
	{
		this.lastupdate = "";
		this.weight = 0;
		this.height = 1;
		this.bmi = weight/(height*height);
	}

	public HealthProfile(NodeList healthProfileDetails)
	{
		for (int k = 0; k < healthProfileDetails.getLength(); k++) {
			Node child = healthProfileDetails.item(k);
			if (child.getNodeType() != Node.TEXT_NODE)
			{
				switch (child.getNodeName())
				{
					case "lastupdate":
						this.lastupdate = (child.getFirstChild().getNodeValue());
						break;
					case "weight":
						this.setWeight(child.getFirstChild().getNodeValue());
						break;
					case "height":
						this.setHeight(child.getFirstChild().getNodeValue());
						break;
					case "bmi":
						this.setBmi(child.getFirstChild().getNodeValue());
						break;
					default:
						break;
				}
			}
		}
	}

	public String getLastupdate()
	{
		return lastupdate;
	}

	public void setLastupdate(String lastupdate)
	{
		this.lastupdate = lastupdate;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
		this.bmi = weight/(height*height);
	}

	public void setWeight(String weight)
	{
		try
		{
			this.weight = Double.parseDouble(weight);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
		this.bmi = weight/(height*height);
	}

	public void setHeight(String height)
	{
		try
		{
			this.height = Double.parseDouble(height);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public double getBmi()
	{
		return bmi;
	}

	public void setBmi(double bmi)
	{
		this.bmi = bmi;
	}

	public void setBmi(String bmi)
	{
		try
		{
			this.bmi = Double.parseDouble(bmi);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void printHealthProfile()
	{
		System.out.println("Last Update: \t" + this.lastupdate);
		System.out.println("Weight: \t\t" + this.weight);
		System.out.println("Height: \t\t" + this.height);
		System.out.println("BMI: \t\t" + this.bmi);
	}
}

