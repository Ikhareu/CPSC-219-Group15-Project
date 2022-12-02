package objects;

import java.util.ArrayList;

public class Users {
	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	
	private String phone;
	private String name;
	private String password;

	public Users(String userName, String userPhone, String userPassword) {
		
		setName(userName);
		setPhone(userPhone);
		setPassword(userPassword);
	}
	
	public ArrayList <String> getcoursesToLearn(){
		return(coursesToLearn);
	}

	public ArrayList <String> getcoursesToTeach(){
		return(coursesToTeach);
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
	
	public String toSring(Users user) {
		String string = String.format("%s %s %s\n", user.getName(), user.getPhone(), user.getPassword());
		return string;
	}
	
	
	
}
