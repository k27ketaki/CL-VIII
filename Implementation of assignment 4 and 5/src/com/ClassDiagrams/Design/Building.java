package com.ClassDiagrams.Design;

import java.util.Scanner;

public class Building
{
	int ID;
	String name;
	private float load;
	private double latitude, longitude;
	private Connection connection;
	public Building(int ID, String name, float load, double latitude, double longitude,Connection connection)
	{
		this.ID = ID;
		this.name = name;
		this.load = load;
		this.latitude = latitude;
		this.longitude = longitude;
		this.connection = connection;
	}
	void changeTransformer(Transformer newTransformer)
	{
		Transformer transformer = connection.getTransformer();
		if(connection.getStatus() == true && newTransformer.getLoad() + transformer.getLoad() > 0.8 * newTransformer.getkVA())
		{
			System.out.println("Error! Transformer overloaded!");
		}
		else
		{
			connection.setNewTransformer(newTransformer,load);
		}
	}
	void modify()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Which field would you like to modify?");
		System.out.print("1. Name\n2. Load\n3. Location\nEnter your choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: System.out.print("Enter the modified name: ");
					name = sc.nextLine();
					break;
			case 2: System.out.print("Enter modified Load:");
					float tempLoad = sc.nextFloat();
					Transformer transformer = connection.getTransformer();
					if(connection.getStatus() == true && transformer.getLoad() - load + tempLoad > 0.8 * transformer.getkVA())
					{
						System.out.println("Error! Transformer overloaded!");
					}
					else
					{
						if(connection.getStatus() == true)
							transformer.setLoad(transformer.getLoad() - load + tempLoad);
						load = tempLoad;
					}
					break;
			case 3: System.out.print("Enter the modified latitude: ");
					latitude = sc.nextDouble();
					System.out.print("Enter the modified longitude: ");
					longitude = sc.nextDouble();
					break;
			default:System.out.println("Error! Incorrect choice.");
		}
	}
	float getLoad()
	{
		return load;
	}
}
