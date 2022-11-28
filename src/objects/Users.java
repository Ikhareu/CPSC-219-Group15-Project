package objects;

import java.util.ArrayList;

public class Users {
	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	
	private String phone;
	private String name;
	private String password;
	private int userID;

	public Users(String userName, String userPhone, String userPassword, String email) {
		
		setName(userName);
		setPhone(userPhone);
		setPassword(userPassword);
		setEmail(email);
	}
	
	public ArrayList <String> getcoursesToLearn(){
		return(coursesToLearn);
	}

	public ArrayList <String> getcoursesToTeach(){
		return(coursesToTeach);
	}
	
	public void setUserID(int id) {
		this.userID=id;
		
	}
	
	public int getUserID() {
		
		return(userID);
	}
	
	public void addCourses(ArrayList <String> CoursesToLearn, ArrayList <String> CoursesToTeach) {
		coursesToLearn=CoursesToLearn;
		coursesToTeach=CoursesToTeach;
		
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getEmail() {
		return phone;
	}

	public void setEmail(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
