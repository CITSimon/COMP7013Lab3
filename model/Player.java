package model;

public class Player 
{
	private String name;
	private int age;
	private int internationalCaps;
	private int noOfGoals;
	
	public Player(String name, int age, int internationalCaps, int noOfGoals)
	{
		this.name = name;
		this.age = age;
		this.internationalCaps = internationalCaps;
		this.noOfGoals = noOfGoals;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setInternationalCaps(int internationalCaps)
	{
		this.internationalCaps = internationalCaps;
	}
	
	public int getInternationalCaps()
	{
		return this.internationalCaps;
	}
	
	public void setNoOfGoals(int noOfGoals)
	{
		this.noOfGoals = noOfGoals;
	}
	
	public int getNoOfGoals()
	{
		return this.noOfGoals;
	}
}
