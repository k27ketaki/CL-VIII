package com.ClassDiagrams.Design.Repository;

import com.ClassDiagrams.Design.Models.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class DataRepository {
    private static List<Transformer> transformers;
    private static List<Connection> connections;
    private static List<Building> buildings;
    private static List<Technician> technicians;
    private static List<Admin> admins;

    public static void initialize(){
        getTransformers();
        getBuildings();
        getConnections();
    }
    public static List<Transformer> getTransformers() {
        if(transformers == null){
            transformers = new ArrayList<Transformer>();
            transformers.add(new Transformer(1,"transformer1",150,18.102301,16.210154));
            transformers.add(new Transformer(2,"transformer2",250,16.210154,18.102301));
            transformers.add(new Transformer(3,"transformer3",200,17.102301,17.210154));
        }
        return transformers;
    }

    public static List<Connection> getConnections(){
        if(connections == null){
            connections = new ArrayList<Connection>();
        }
        return connections;
    }
    public static List<Building> getBuildings(){
        if(buildings == null){
            buildings = new ArrayList<Building>();
            buildings.add(new Building(1,"building 1",20))
        }
        return buildings;
    }

    public static List<Technician> getTechnicians() {
        if(technicians == null){
            technicians = new ArrayList<Technician>();
            // TODO:initialize buildings dataset here
        }
        return technicians;
    }

    public static List<Admin> getAdmins() {
        if(admins == null){
            admins = new ArrayList<Admin>();
            Admin admin = new Admin(1,"chinmay","c@c.c","c","c",false);
            admins.add(admin);
        }
        return admins;
    }

    public static void initializeConnections() {
        if(connections == null) getConnections();
        // TODO: call distance matrix api
    }

    public static void showTransformerListing() {
        if(connections == null) getConnections();
        for(Connection c: getConnections()){
            out.print(c);
        }
    }

    public static void showTechnicianListing() {
        if(technicians == null) getTechnicians();
        for(Technician t : technicians){
            out.print(t);
        }
    }
    public static void showBuildingListing() {
        if(buildings == null) getBuildings();
        for(Building t : buildings){
            out.print(t);
        }
    }

    public static Connection getActiveConnection(Building building) {
        for(Connection c : connections)
            if(c.getBuilding() == building && c.isStatus())
                return c;
        return null;
    }
}
