package com.example.conor;

public class DieRoller {
	
	public String rollDice(int n)
	{
		//System.out.println("Enter the number of sides on the dice");
		return "You rolled a : "+(int) (1 + Math.random()*n)+" !";
	}

}
