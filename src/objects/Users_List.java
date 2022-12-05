package objects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Users_List {

	private ArrayList<Users> userArray = new ArrayList<Users>();
	private ArrayList<String> userArrayStrings = new ArrayList<String>();
	private int numnberOfUsers = 0;

	public void getUserListFromTxt(String filename) throws IOException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (userArrayStrings.contains(line))
				userArrayStrings.add(line);
				userArray.add(new Users(line));
				numnberOfUsers++; 
			}
		}
	}
 
	
	
	
	public Users_List() {

	}


	public void addUser(Users newUser) {
		userArray.add(newUser);
		this.numnberOfUsers++;
		newUser.setUserID(numnberOfUsers);
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

		for (Users user : userArray) {

			ArrayList<String> userCoursesToCheck = user.getcoursesToLearn();

			for (String userCourse : userCoursesToCheck) {

				if (userCourse.equalsIgnoreCase(coursename)) {

					usersHavingCourse.add(user);

				}

			} 
		}

		return (usersHavingCourse);
	}

	public ArrayList<Users> getCourseTeachers(String coursename) {
		ArrayList<Users> usersHavingCourse = new ArrayList<Users>();

		System.out.println(coursename);
		for (Users user : userArray) {
			ArrayList<String> userCoursesToCheck = user.getcoursesToTeach();
			System.out.print("Name: " + user.getName());
			System.out.println("\\\\courses user teacher=>" + userCoursesToCheck);

			for (String userCourse : userCoursesToCheck) {
				System.out.print("(((" + coursename + "|||" + userCourse + ")))");
				if (userCourse.equalsIgnoreCase(coursename)) {
					System.out.println("IT WORKS");
					usersHavingCourse.add(user);

				}
			}
		}
		System.out.println("-------------------------------------------------");
		return (usersHavingCourse);
	}


	
	//------------------------------------------------------------------------------------------------------------------------------------------------- 	
	public Users isValid(String username, String password) {
		Users answer = null;
		for (Users user : userArray) {
			System.out.println(username+"||"+user.getName());
			System.out.println(password+"||"+user.getPassword());
			System.out.println("---------------------------");
			if ((user.getName().equalsIgnoreCase(username) && user.getPassword().equals(password))) {
				answer = user;
				return(answer);
			}
		}
		return (answer);
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
		
		this.cleanUp(filename);
		  
		FileWriter writer = new FileWriter(filename);
		 
		System.out.println(numnberOfUsers);
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
	
	public void removeDuplicates()
    {
//  
//        ArrayList<Users> newList = new ArrayList<Users>();
//
//    	Boolean duplicate=false;
//        for (Users usr1 : userArray) {
//        	
//            for (Users usr2: newList) {
//            	
//            	
//            }
//        }
//        this.userArray=newList;
    }
	
}
