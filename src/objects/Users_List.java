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


	public boolean isValid(String username, String password) {
		boolean answer = false;
    	for (Users user : userArray) {
    		if ((user.getName() == username) && (user.getPassword() == password)) {
    			answer = true;
    		}
    	}
    	return answer;
    }
	

}
