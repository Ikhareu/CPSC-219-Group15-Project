package objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Users_List {

	private ArrayList<Users> userArray = new ArrayList<Users>();
	private ArrayList<String> userArrayStrings = new ArrayList<String>();
	private int numberOfUsers = 0;

	public void getUserListFromTxt(String filename) throws IOException, IOException {
		numberOfUsers = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			this.userArray=new ArrayList<Users>();
			while ((line = br.readLine()) != null) {
				if (userArrayStrings.contains(line))
				this.userArrayStrings.add(line);
				Users usr=new Users(line);
				
				usr.setUserID(numberOfUsers);
				numberOfUsers++;
				this.userArray.add(usr);
			}

		}
	}
 
	
	
	
	public Users_List() {

	}


	public void addUser(Users newUser) {
		this.userArray.add(newUser);
		this.numberOfUsers++;
		newUser.setUserID(numberOfUsers);
	}

	public void deleteUser(Users U1) {
		userArray.remove(U1);
	}

	public ArrayList<Users> getArray() {
		return (userArray);
	}



	public ArrayList<Users> getUserList() {
		return (userArray);
	}

	public void setUserList(ArrayList<Users> users) {

		userArray = users;
	}

	public Users getUser(int id) {
		return (userArray.get(id));
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	public ArrayList<Users> getCourseStudents(String coursename) {
		ArrayList<Users> usersHavingCourse = new ArrayList<Users>();

		System.out.println("to find  "+coursename);
		for (Users usr : userArray) {
			
			ArrayList<String> userCoursesToCheck = usr.getcoursesToLearn();
//			System.out.print("Name: " + usr.getName());
//			System.out.println("\\\\courses user teacher=>" + userCoursesToCheck);

			System.out.println("-----------------------------");

			System.out.println("-----------------------------");
			for (String userCourse : userCoursesToCheck) {

				if (userCourse.equalsIgnoreCase(coursename)) {

					usersHavingCourse.add(usr);

					System.out.println("user found|| name:"+ usr.getName());



				}
 
			} 

			System.out.println("-----------------------------");
			System.out.println("-----------------------------");
		}
		System.out.println("search done students course:  "+coursename);
		return (usersHavingCourse);
	}

	public ArrayList<Users> getCourseTeachers(String coursename) {
		ArrayList<Users> usersHavingCourse = new ArrayList<Users>();
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		System.out.println("to find  "+coursename);
		for (Users usr : userArray) {
			ArrayList<String> userCoursesToCheck = usr.getcoursesToTeach();
//			System.out.print("Name: " + usr.getName());
//			System.out.println("\\\\courses user teacher=>" + userCoursesToCheck);

			
			for (String userCourse : userCoursesToCheck) {
				if (userCourse.equalsIgnoreCase(coursename)) {
					
					usersHavingCourse.add(usr);
					System.out.println("user found|| name:"+ usr.getName());

				}
			}
			
		}
		
		System.out.println("search done tutors for:  "+coursename);
		System.out.println("-------------------------------------------------");
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		return (usersHavingCourse);
	}


	
	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public Users isValid(String email, String password) {
		Users answer = null;
		for (Users usr : userArray) {
//			System.out.println(email+"|||"+usr.getEmail());
//
//			System.out.println(password+"|||"+usr.getPassword());
//			System.out.println("----------------------------");
			if ((usr.getEmail().equalsIgnoreCase(email) && usr.getPassword().equals(password))) {
				answer = usr;
				return(answer);
			}
		}
		return (answer);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public boolean newUserGood(String email) {
		boolean userGood=true;
		for (Users user : userArray) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				userGood = false;
				return(userGood);
			}
		}
		return (userGood);
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public void printUserList() {
		for (Users usr: userArray) {
			usr.printUserInfo();
			
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public void cleanUp(String filename) throws IOException, IOException {
		FileWriter cleaner = new FileWriter(filename);
		cleaner.close();
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public void saveUserListAsTxt(String filename) throws IOException, IOException {
//
		Boolean firstline=true;
		Path path = Paths.get(filename);
		Files.delete(path);
		File usersTxt= new File(filename);
		FileWriter writer = new FileWriter(filename);
		 
		//System.out.println("number of users: " +numberOfUsers);
		for (Users usr: userArray) {
 
    		if (firstline==false) writer.write(System.getProperty( "line.separator" ));
			String userline= (usr.getName()+"|"+usr.getEmail()+"|"+usr.getPhone()+"|"+usr.getPassword()+"|");
			firstline=false;
    		for (String str:usr.getcoursesToLearn()) {
    			userline=userline+str+"+";
    		}
    		userline=userline+"|";
     		for (String str:usr.getcoursesToTeach()) {
    			userline=userline+str+"+"; 
    		}
    		userline=userline+"|";
    		
    		writer.write(userline);
		}
		writer.close();
	}
	

	
}
