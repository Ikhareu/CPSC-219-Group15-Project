package objects;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Users {
	

	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	
	private String phone = null;
	private String email = null;
	private String name = null;

	public Users() {
		//phone = fxid:inputPhone;
		//email = fxid:inputEmail;
		//name  = fxid:inputName;
		
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
	
	
	
}
