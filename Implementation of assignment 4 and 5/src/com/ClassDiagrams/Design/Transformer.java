package com.ClassDiagrams.Design;

import java.util.LinkedList;
import java.util.Scanner;

public class Transformer
{
	int ID;
	String name;
	private float kVA, load;
	private boolean status;
	private double latitude, longitude;
	private LinkedList<Connection> connections;
	public Transformer(int ID, String name, float kVA, double latitude,double longitude)
	{
		this.ID = ID;
		this.name = name;
		this.kVA = kVA;
		load = 0;
		status = true;
		this.latitude = latitude;
		this.longitude = longitude;
		connections = new LinkedList<Connection>();
	}
	void removeConnection(Connection connection, float buildingLoad)
	{
		if(connection.getStatus() == true)
			setLoad(getLoad() - buildingLoad);
		connections.remove(connection);
	}
	void addConnection(Connection connection, float buildingLoad)
	{
		if(!connections.contains(connection))
		{
			if(connection.getStatus() == true)
				setLoad(getLoad() + buildingLoad);
			connections.add(connection);
		}
	}
	void restore()
	{
		for (int cnt = 0; cnt < connections.size(); cnt++)
		{
			Connection conn = connections.get(cnt);
			Building building = conn.getBuilding();
			building.changeTransformer(this);
		}
	}
	void toggle()
	{
		if(status == true)
			status = false;
		// What will happen to it's connections?
		else
		{
			status = true;
			restore();
		}
	}
	void modify()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Which field would you like to modify?");
		System.out.print("1. Name\n2. KVA\n3. Location\nEnter your choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: System.out.print("Enter the modified name: ");
					name = sc.nextLine();
					break;
			case 2: System.out.print("Enter the modified kVA: ");
					kVA = sc.nextFloat();
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
	float getkVA()
	{
		return kVA;
	}
	void setLoad(float newLoad)
	{
		load = newLoad;
	}
}
