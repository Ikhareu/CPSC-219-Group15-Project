package objects;

import java.util.ArrayList;

public class Users_List {
	private static ArrayList <Users> userArray = new ArrayList<Users>();
	
	public Users_List(){
		if (userArray.isEmpty()) {
			Users ohiomah = new Users("Charlie", "0123456789", "Charlie2017");
			Users_List.addUser(ohiomah);
		}
	}
	
	public static void addUser(Users newUser) {
		userArray.add(newUser);
	}
	
	public static void deleteUser(Users U1) {
		userArray.remove(U1);
	}
	
	public static ArrayList<Users> getArray() {
		return userArray;
	}

}
