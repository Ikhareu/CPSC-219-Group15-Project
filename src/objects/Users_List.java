package objects;

import java.util.ArrayList;

public class Users_List {
	private static ArrayList <Users> userArray = new ArrayList<Users>();
	
	public Users_List(){
		Users ohiomah = new Users("Ohiomah", "5875003780", "Ohiomah2017");
	    Users_List.addUser(ohiomah);
	}
	
	public static void addUser(Users newUser) {
		userArray.add(newUser);
	}
	
	public void deleteUser(Users U1) {
		userArray.remove(U1);
	}
	
	public ArrayList<Users> getArray() {
		return userArray;
	}
	
	public static boolean isValid(String username, String password) {
		boolean answer = false;
    	for (Users user : Users_List.userArray) {
    		if ((user.getName() == username) && (user.getPassword() == password)) {
    			answer = true;
    			return true;
    		}
    	}
    	return answer;
    	}

}
