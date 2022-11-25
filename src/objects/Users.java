package objects;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Users {
	

	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	

	public Users() {
		
		
		
		
		// TODO Auto-generated constructor stub
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
