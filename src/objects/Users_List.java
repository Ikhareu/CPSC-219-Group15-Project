package objects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Users_List {
	private static ArrayList <Users> userArray = new ArrayList<Users>();
	
	public Users_List(){
		Users ohiomah = new Users("Ohiomah", "5875003780", "Ohiomah2017");
	    Users_List.addUser(ohiomah);
	}
	
	public static void addUser(Users newUser) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("usersList.txt", true));
			writer.write(newUser.toSring());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
