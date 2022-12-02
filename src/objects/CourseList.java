package objects;

import java.util.ArrayList;

public class CourseList {
	private ArrayList <String> courses = new ArrayList<String>();
	
	
	public ArrayList<String> getCourses() {
		return this.courses;
	}

	public void addCourse(String course) {
		this.courses.add(course);
	}

}
