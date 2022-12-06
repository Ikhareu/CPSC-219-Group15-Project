package objects;

import java.util.ArrayList;

public class tutor extends Users {

	private int rate;
	private ArrayList<String> coursesToTeach = new ArrayList<String>();
	
	public tutor(String userName, String userPhone, String userPassword, int price, ArrayList<String> courseList) {
		super(userName, userPhone, userPassword);
		this.setRate(price);
		this.setCoursesToTeach(courseList);
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public ArrayList<String> getCoursesToTeach() {
		return coursesToTeach;
	}

	public void setCoursesToTeach(ArrayList<String> coursesToTeach) {
		this.coursesToTeach = coursesToTeach;
	}
	

}
