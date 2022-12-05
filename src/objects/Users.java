package objects;

import java.util.ArrayList;

public class Users {
	private ArrayList <String> coursesToLearn = new ArrayList<String>();
	private ArrayList <String> coursesToTeach = new ArrayList<String>();
	
	private String phone;
	private String name;
	private String password;
	private String email;
	private int userID;

	public Users(String userName, String userPhone, String userPassword, String email) {
		
		setName(userName);
		setPhone(userPhone);
		setPassword(userPassword);
		setEmail(email);
	}
	
	
	public Users(String userInfo) {
		int valueIndex=0;
		
		String course="";
		String userName = "";
		String userPhone= "";
		String userPassword= "";
		String userEmail= "";
		
		ArrayList <String> txtCoursesToLearn = new ArrayList<String>();
		ArrayList <String> txtCoursesToTeach = new ArrayList<String>();
		
		for (int i = 0; i<userInfo.length(); i++) {

			if (userInfo.charAt(i)!='|' && valueIndex==0) {
				userName=userName+userInfo.charAt(i);
			}
			
			if ((userInfo.charAt(i)=='|' && valueIndex==0)) valueIndex=1;
			
			
			if (userInfo.charAt(i)!='|' && valueIndex==1) {
				userEmail=userEmail+userInfo.charAt(i);
			}
			if ((userInfo.charAt(i)=='|' && valueIndex==1)) valueIndex=2;

			
			if (userInfo.charAt(i)!='|' && valueIndex==2) {
				userPassword=userPassword+userInfo.charAt(i);
			}
			if ((userInfo.charAt(i)=='|' && valueIndex==2)) valueIndex=3;
			
			

			if (userInfo.charAt(i)!='|' && valueIndex==3) {
				userPhone=userPhone+userInfo.charAt(i);
			}
			if ((userInfo.charAt(i)=='|' && valueIndex==3)) valueIndex=4;
		
			

			if ((userInfo.charAt(i)=='|' && valueIndex==4)) valueIndex=5;
			course="";
			if (valueIndex==4 &&  userInfo.charAt(i)!='|') {
				if (userInfo.charAt(i)!='+') {
					course=course+userInfo.charAt(i);
				}
				if (userInfo.charAt(i)=='+') {
					txtCoursesToLearn.add(course);
					course="";
				}
			}
			
			course="";
			if (valueIndex == 5 && userInfo.charAt(i) != '|') {
				if (userInfo.charAt(i) != '+') {
					course = course + userInfo.charAt(i);
				}
				if (userInfo.charAt(i) == '+') {
					txtCoursesToTeach.add(course);
					course = "";

				}

			}
			
			
			
		}
		
		
		
		
		
		
		
		
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
