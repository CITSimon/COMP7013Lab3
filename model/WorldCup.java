package model;
public class WorldCup {

	public static void main(String[] args) 
	{
		Country country1 = new Country("Ireland");
		Striker striker1 = new Striker("john", 25, 33, 6.2, 0);
		Striker striker2 = new Striker("patrick", 35, 100, 6.5, 0);
		country1.addPlayer(striker1);
		country1.addPlayer(striker2);
		
		Goalkeeper gkeeper1 = 
				new Goalkeeper("tim", 21, 3, 0, 2);
		
		country1.addPlayer(gkeeper1);

	}

}
