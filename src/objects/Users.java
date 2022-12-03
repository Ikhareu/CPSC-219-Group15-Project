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
		return phone;
	}

	public void setPhone(String numPhone) {
		if (numPhone == null) {
			//exception
		}
		this.phone = numPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailAdress) {
		if (emailAdress == null) {
			//exception
		}
		this.email = emailAdress;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		if (userName == null) {
			//exception
		}
		this.name = userName;
	}
}
