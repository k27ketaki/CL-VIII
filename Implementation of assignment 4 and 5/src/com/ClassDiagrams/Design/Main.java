package com.ClassDiagrams.Design;

import com.ClassDiagrams.Design.Models.*;
import com.ClassDiagrams.Design.Repository.DataRepository;

import static com.ClassDiagrams.Design.InputClient.getScanner;
import static java.lang.System.out;

public class Main{

    public static void main(String[] args) {
        DataRepository.initialize();
        while(true){
            switch (login()){
                case 1: adminCredCheck();
                    break;
                case 2: technicianCredCheck();
                    break;
                case 3: out.println("Thank you for using LDA. See you again");
                    return;
                default: out.println("ERROR: Incorrect input");
            }
        }
    }
    private static int login(){
        out.println("Welcome to load Distribution Application");
        out.println("Please choose type of user checkCredentials");
        out.println("1. Administrator");
        out.println("2. Technician");
        out.println("3. Exit");
        return getScanner().nextInt();
    }

    private static void adminCredCheck(){
        while(true) {
            out.println("Enter user name");
            String username = getScanner().next();
            out.println("Enter password");
            String password = getScanner().next();
            out.println("Enter admin password");
            String adminPassword = getScanner().next();
            Admin admin = Admin.findAdminUser(DataRepository.getAdmins(), username,password,adminPassword);
            if(admin == null){
                out.println("Can't find User, want to try again?(1/0)");
                if(getScanner().nextInt()!=1)
                    return;
            }else{
                admin.experience();
            }
        }
    }
    private static void technicianCredCheck(){
        while(true) {
            out.println("Enter user name");
            String username = getScanner().next();
            out.println("Enter password");
            String password = getScanner().next();
            Technician technician = Technician.findTechnicianUser(DataRepository.getTechnicians(), username,password);
            if(technician == null){
                out.println("Can't find User, want to try again?(1/0)");
                if(getScanner().nextInt()!=1)
                    return;
            }else{
                technician.experience();
            }
        }
    }
}