package objects;

import java.util.ArrayList;

public class Tutor extends Users {
	
	private int rate;
	private ArrayList <String> courses;

	public Tutor(String userName, String userPhone, String userPassword) {
		super(userName, userPhone, userPassword);
	}
	
	public Tutor(String userName, String userPhone, String userPassword, int tutorRate, ArrayList <String> courseList) {
		super(userName, userPhone, userPassword);
		this.setRate(tutorRate);
		this.setCourses(courseList);
	}
	

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public ArrayList <String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList <String> courses) {
		this.courses = courses;
	}
	
	public void addCourse(String course) {
		courses.add(course);
	}
	
	public void removeCourse(String course) {
		courses.remove(course);
	}

}
