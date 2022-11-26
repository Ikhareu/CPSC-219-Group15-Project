package objects;

import java.util.ArrayList;

public class Users_List {
	private ArrayList <Users> userArray;
	
	public void addUser(Users newUser) {
		userArray.add(newUser);
	}
	
	public void deleteUser(Users U1) {
		userArray.remove(U1);
	}
	
	public ArrayList<Users> getArray() {
		return userArray;
	}
	
}
