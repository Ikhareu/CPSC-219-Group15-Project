package objects;

import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Users {
	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	
	private String phone;
	private String email;
	private String name;

	public Users(String userName, String userEmail, String userPhone) {
		//phone = fxid:inputPhone;
		//email = fxid:inputEmail;
		//name  = fxid:inputName;
		setName(userName);
		setEmail(userEmail);
		setPhone(userPhone);
	}

	public ArrayList <String> getcoursesToLearn(){
		return(coursesToLearn);
	}

	public ArrayList <String> getcoursesToTeach(){
		return(coursesToTeach);
	}

	public void addCourses(ArrayList <String> classesToLearn, ArrayList <String> classesToTeach) {
		/*
		coursesToLearn=CoursesToLearn;
		coursesToTeach=CoursesToTeach;
		*/
		int count =0;
		while (count < classesToLearn.size()) {
			coursesToLearn.add(classesToLearn.get(count));
		}
		count = 0;
		while (count < classesToTeach.size()) {
			coursesToTeach.add(classesToTeach.get(count));
		}
	}

	public String getPhone() {
		try {
			return this.phone;
		}catch (NullPointerException npe) {
			return ("Error; No phone number");
		}
	}

	public void setPhone(String numPhone) {
		try {
			this.phone = numPhone;
		}catch (NullPointerException npe) {	
		}
	}

	public String getEmail() {
		try {
			return this.email;
		}catch (NullPointerException npe) {
			return ("Error; no email");
		}
	}

	public void setEmail(String emailAdress) {
		try {
			this.email = emailAdress;
		}catch (NullPointerException npe) {
		}
	}	
		
	public String getName() {
		try {
			return this.name;
		}catch (NullPointerException npe) {
			return ("Error; no name");
		}
	}

	public void setName(String userName) {
		try {
			this.name = userName;
		}catch (NullPointerException npe) {
		}
	}
}
