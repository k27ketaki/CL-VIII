package com.ClassDiagrams.Design.Models;

public class Connection
{
	private Transformer transformer;
	private Building building;
	private boolean status;
	private float distance;
	public Connection(Transformer transformer,Building building)
	{
		this.transformer = transformer;
		this.building = building;
		status = false;
	}

	void switchStatus()
	{
		if(status == true)
		{
			status = false;
			transformer.setLoad(transformer.getLoad() - building.getLoad());
		}
		else
		{
			if(transformer.getLoad() + building.getLoad() > 0.8 * transformer.getkVA())
			{
				System.out.println("Error! Transformer overloaded!");
			}
			else
			{
				transformer.setLoad(transformer.getLoad() + building.getLoad());
				status = true;
			}
		}
	}

	Transformer getTransformer()
	{
		return transformer;
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setTransformer(Transformer transformer) {
		this.transformer = transformer;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	boolean getStatus()
	{
		return status;
	}
}