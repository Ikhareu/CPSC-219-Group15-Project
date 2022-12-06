package objects;

import java.util.ArrayList;

public class Courses {
	private ArrayList<String> classes = new ArrayList<String>();
	private int numCourses = 0;
	
	public void Initialize() {
		classes.add("CPSC 217");
		classes.add("CPSC 219");
		classes.add("CPSC 221");
		numCourses = classes.size();
	}
		
	public String getCourse(int index) {
		if (index >= numCourses) {
			//error handling
			return null;
		}
		else {
			return classes.get(index);
		}
	}
	
}
