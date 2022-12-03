package objects;

import java.util.ArrayList;

public class Users_List {
	private static ArrayList <Users> userArray = new ArrayList<Users>();
	
	public Users_List(){
		Users ohiomah = new Users("Charlie", "0123456789", "Charlie2017");
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
    	for (Users user : userArray) {
    		if ((user.getName().equals(username)) && (user.getPassword().equals(password))) {
    			answer = true;
    			return true;
    		}
    	}
    	return answer;
    	}

}
