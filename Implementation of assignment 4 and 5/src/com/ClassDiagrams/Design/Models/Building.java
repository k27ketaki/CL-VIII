package com.ClassDiagrams.Design.Models;

import com.ClassDiagrams.Design.Repository.DataRepository;

import java.util.Scanner;

public class Building
{
	private int ID;
	private String name;
	private float load;
	private double latitude, longitude;
	private Transformer defaultTransformer;
	public Building(int ID, String name, float load, double latitude, double longitude,Transformer transformer) {
		this.ID = ID;
		this.name = name;
		this.load = load;
		this.latitude = latitude;
		this.longitude = longitude;
		this.defaultTransformer = transformer;
	}
	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which field would you like to modify?");
		System.out.print("1. Name\n2. Load\n3. Location\nEnter your choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: System.out.print("Enter the new name: ");
					name = sc.nextLine();
					break;
			case 2: System.out.print("Enter new Load:");
					float tempLoad = sc.nextFloat();
					Transformer connectedTransformer = DataRepository.getActiveConnection(this).getTransformer();
					if(connectedTransformer.getLoad() - load + tempLoad > 0.8 * connectedTransformer.getkVA())
						System.out.println("Error! Transformer overloaded!");
					else
					{
						connectedTransformer.setLoad(connectedTransformer.getLoad() - load + tempLoad);
						load = tempLoad;
					}
					break;
			case 3: System.out.print("Enter the new latitude: ");
					latitude = sc.nextDouble();
					System.out.print("Enter the new longitude: ");
					longitude = sc.nextDouble();
					break;
			default:System.out.println("Error! new choice.");
		}
	}
	float getLoad()
	{
		return load;
	}
}
