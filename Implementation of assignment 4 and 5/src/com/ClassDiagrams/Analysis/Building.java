package com.ClassDiagrams.Analysis;

import com.ClassDiagrams.Design.Connection;

public abstract class Building
{
	int ID;
	private String name;
	private float load;
	private double latitude, longitude;
	private Connection connection;
	abstract void changeTransformer(Transformer new_transformer);
	abstract void modify();
	abstract float getLoad();
}
