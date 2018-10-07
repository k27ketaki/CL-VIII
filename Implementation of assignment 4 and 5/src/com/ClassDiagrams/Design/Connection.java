package com.ClassDiagrams.Design;

public class Connection
{
	Transformer transformer;
	Building building;
	boolean status;
	public Connection(Transformer transformer,Building building)
	{
		this.transformer = transformer;
		this.building = building;
		status = false;
	}
	Transformer getTransformer()
	{
		return transformer;
	}
	void setNewTransformer(Transformer newTransformer, float buildingLoad)
	{
		transformer.removeConnection(this, buildingLoad);
		transformer = newTransformer;
		transformer.addConnection(this, buildingLoad);
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
	Building getBuilding()
	{
		return building;
	}
	boolean getStatus()
	{
		return status;
	}
}