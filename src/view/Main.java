package view;

import objects.Users_List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users_List acc = new Users_List();
		String username = "Charlie";
		String password = "Charlie2017";
		if (Users_List.isValid(username, password, Users_List.getArray())){
			System.out.println("abcdef");
		}
	}

}
