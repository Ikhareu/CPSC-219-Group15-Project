package objects;

import java.util.ArrayList;


public class Users_List {
	
	public Users_List(){
		Users ohiomah = new Users("Ohiomah", "5875003780l", "Ohiomah2017","ohimasEmail");
		Users irek = new Users("Irek","4039189051","123123123","irek@email.ca");
		

		ArrayList<String> qcoursesToLearnTest = new ArrayList<String>();
		ArrayList<String> pcoursesToTeachTest = new ArrayList<String>();
		qcoursesToLearnTest.add("MATH111");
		qcoursesToLearnTest.add("MATH367");
		qcoursesToLearnTest.add("CPSC219");
		
		pcoursesToTeachTest.add("MATH111");
		pcoursesToTeachTest.add("MATH222");
		pcoursesToTeachTest.add("CPSC333");
		irek.addCourses(qcoursesToLearnTest, pcoursesToTeachTest);
		ohiomah.addCourses(qcoursesToLearnTest, pcoursesToTeachTest);
		

	    this.addUser(ohiomah);
	    this.addUser(irek);
	}
	
	
	private ArrayList <Users> userArray = new ArrayList<Users>();
	private int numnberOfUsers=1;

	 
	public void addUser(Users newUser) {
		userArray.add(newUser);
		numnberOfUsers++;
		newUser.setUserID(numnberOfUsers);
	}
	
	public void deleteUser(Users U1) {
		userArray.remove(U1); 
	}
	
	
	public ArrayList <Users> getArray() {
		return(userArray);
	}
	
	 
	public Users isValid(String username, String password) {
		Users answer = null ;
    	for (Users user : userArray) {
			
    		if ((user.getName().equalsIgnoreCase(username) && user.getPassword().equals(password))) {
    			
    			answer=user;  
    		}

    	}
    	return (answer);
    }
	
	
	public ArrayList <Users> getUserList(){
		return(userArray);
	}
	
	public void setUserList(ArrayList <Users> users) {
		
		userArray= users;
	}
	
	public Users getUser(int id) {
		return(userArray.get(id));
	}
	
	
	
	
	public ArrayList <Users> getCourseStudents(String coursename) {
		ArrayList <Users> usersHavingCourse= new ArrayList <Users>();

		for (Users user: userArray ) {

			ArrayList <String> userCoursesToCheck= user.getcoursesToLearn();
			
			
			for (String userCourse: userCoursesToCheck)	{
				
				
				if (userCourse.equalsIgnoreCase(coursename)) {
					
					usersHavingCourse.add(user);
				
				}
				
			}
		}
		
		return(usersHavingCourse);   
	} 

	
	
	public ArrayList <Users> getCourseTeachers(String coursename) {
		ArrayList <Users> usersHavingCourse= new ArrayList <Users>();

		System.out.println(coursename);
		for (Users user: userArray ) {
			ArrayList <String> userCoursesToCheck= user.getcoursesToTeach();
			System.out.print("Name: "+user.getName());
			System.out.println("\\\\courses user teacher=>"+userCoursesToCheck);
			
			for (String userCourse: userCoursesToCheck)	{
				System.out.print("((("+
			coursename+"|||"+userCourse+")))");
				if (userCourse.equalsIgnoreCase(coursename)) {
					System.out.println("IT WORKS");
					usersHavingCourse.add(user);
					
				}
			}
		} 
		System.out.println("-------------------------------------------------");
		return(usersHavingCourse);
	}
	
	
}
