package com.ClassDiagrams.Analysis;

import java.util.LinkedList;

import com.ClassDiagrams.Design.Connection;

public abstract class Transformer
{
	int ID;
	String name;
	private float kVA, load;
	private boolean status;
	private double latitude, longitude;
	private LinkedList<Connection> connections;
	abstract void removeConnection(Connection connection, float buildingLoad);
	abstract void addConnection(Connection connection, float buildingLoad);
	abstract void restore();
	abstract void toggle();
	abstract void modify();
	abstract float getLoad();
	abstract float getkVA();
	abstract void setLoad(float newLoad);
}
