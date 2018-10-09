package com.ClassDiagrams.Design.Models;

import com.ClassDiagrams.Design.Repository.DataRepository;

import java.util.List;
import static com.ClassDiagrams.Design.InputClient.getScanner;
import static java.lang.System.out;

public class Admin extends User
{
	private String superUserPassword;
    public Admin(int ID, String name, String email, String password, String superUserPassword,boolean loggedIn) {
        super(ID, name, email, password, loggedIn);
        this.superUserPassword =superUserPassword;
    }

    public static Admin findAdminUser(List<Admin> admins, String username, String password, String suPassword) {
		for(Admin a: admins){
			if(a.login(username,password,suPassword))
				return a;
		}
		return null;
	}

	private boolean login(String username, String password, String suPassword)
	{
		if(super.checkCredentials(username, password))
		{
			if(superUserPassword.equals(suPassword))
			{
				setLoggedIn(true);
				return true;
			}
		}
		return false;
	}
	public void experience(){
	    while(true) {
            out.println("Menu");
            out.println("1. Edit Transformers");
            out.println("2. Edit Buildings");
            out.println("3. Add Technician users");
            out.println("4. Initialize connections");
            out.println("5. Toggle a Transformer");
            out.println("6. Exit");
            out.print("Enter your choice");
            switch (getScanner().nextInt()) {
                case 1:
                    out.println("Choose a transformer to edit");
                    DataRepository.showTransformerListing();
                    DataRepository.getTransformers().get(getScanner().nextInt()).modify();
                    break;
                case 2:
                    out.println("Choose a building to edit");
                    DataRepository.showBuildingListing();
                    DataRepository.getBuildings().get(getScanner().nextInt()).modify();
                    break;
                case 3:
                    out.println("Add a technician");
                    String name = getScanner().next();
                    String email = getScanner().next();
                    String pass = getScanner().next();
                    DataRepository.getTechnicians().add(new Technician(DataRepository.getTechnicians().size(),name, email, pass));
                    break;
                case 4:
                    DataRepository.initializeConnections();
                    break;
                case 5:
                    out.println("Choose a transformer to edit");
                    DataRepository.showTransformerListing();
                    DataRepository.getTransformers().get(getScanner().nextInt()).toggle();
                    break;
                case 6:
                    return;
                default: out.println("Incorrect input");
            }
        }
    }
}