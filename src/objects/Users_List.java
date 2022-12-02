package objects;

import java.util.ArrayList;


public class Users_List {
	
	public Users_List(){
		Users ohiomah = new Users("Ohiomah", "5875003780l", "Ohiomah2017","ohimasEmail");
	    this.addUser(ohiomah);
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
    		if ((user.getName() == username) && (user.getPassword() == password)) {
    			answer=user;
    		}
    		 
    	}
    	return answer;
    }
	
	
	public ArrayList <Users> getUserList(){
		return(userArray);
	}
	
	public void setUserList(ArrayList <Users> users) {
		
		userArray= users;
	}
	
	
	
	
	public ArrayList <Users> getCourseStudents(String coursename) {
		ArrayList <Users> usersHavingCourse= new ArrayList <Users>();

		for (int i=0; i<numnberOfUsers; i++ ) {

			Users user= userArray.get(i);
			ArrayList <String> userCoursesToCheck= user.getcoursesToLearn();
			
			
			for (int j=0; j<userCoursesToCheck.size(); j++)	{
				
				String userCourse= userCoursesToCheck.get(j);
				
				if (userCourse==coursename) {
					
					usersHavingCourse.add(user);
				
				}
				
			}
		}
		
		return(usersHavingCourse);   
	} 

	
	
	public ArrayList <Users> getCourseTeachers(String coursename) {
		ArrayList <Users> usersHavingCourse= new ArrayList <Users>();
		for (int i=0; i<numnberOfUsers; i++ ) {

			Users user= userArray.get(i);
			ArrayList <String> userCoursesToCheck= user.getcoursesToTeach();
			
			
			for (int j=0; j<userCoursesToCheck.size(); j++)	{
				
				String userCourse= userCoursesToCheck.get(j);
				
				if (userCourse==coursename) {
					
					usersHavingCourse.add(user);
					
				}
			}
		}
		
		return(usersHavingCourse);
	}
	
	
}
