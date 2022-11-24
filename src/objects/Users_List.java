package objects;

import java.util.ArrayList;

public class Users_List {
	private ArrayList <Users> userArray;
	
	public Users_List(Users U1) {
		userArray.add(U1);
	}
	
	public void deleteUser(Users U1) {
		userArray.remove(U1);
	}
	
	public ArrayList<Users> getArray() {
		return userArray;
	}

	
	
	

}
