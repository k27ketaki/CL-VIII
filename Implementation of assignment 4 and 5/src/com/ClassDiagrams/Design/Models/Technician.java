package com.ClassDiagrams.Design.Models;

import com.ClassDiagrams.Design.Repository.DataRepository;

import java.util.List;

import static com.ClassDiagrams.Design.InputClient.getScanner;
import static java.lang.System.out;

public class Technician extends User {
    public Technician(int id, String name, String email, String password) {
        super(id,name,email,password,false);
    }

    public static Technician findTechnicianUser(List<Technician> technicians, String username, String password) {
        for(Technician a: technicians){
            if(a.login(username,password))
                return a;
        }
        return null;
    }

    public boolean login(String username, String password) {
        if(super.checkCredentials(username, password)) {
            setLoggedIn(true);
            return true;
        }
        return false;
    }

    public void experience() {
        while(true) {
            out.println("Menu");
            out.println("4. Initialize connections");
            out.println("5. Toggle a Transformer");
            out.println("6. Exit");
            out.print("Enter your choice");
            switch (getScanner().nextInt()) {
                case 4:
                    DataRepository.initializeConnections();
                    break;
                case 5:
                    out.println("Choose a transformer to toggle");
                    DataRepository.showTransformerListing();
                    DataRepository.getTransformers().get(getScanner().nextInt()).toggle();
                    break;
                case 6:
                    return;
                default:
                    out.println("Incorrect input");
            }
        }
    }
}
