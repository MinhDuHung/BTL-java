package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {
	ArrayList<User> userList = new ArrayList<User>();

	public void addUser(User user) {
		this.userList.add(user);
	}

	public boolean find(String userName, String password) {
		for (User userF : userList) {

			if (userF.userName.equals(userName) && userF.password.equals(password)) {
				return true;
			}
		}
		return false;

	}

	public boolean CheckUserName(String userName) {
		for (User userF : userList) {
			if (userF.userName.equals(userName))
				return false;
		}
		return true;

	}

	public void in() {
		for (User userF : userList) {
			System.out.println(userF.userName + " " + userF.password);
		}
	}

	public int getSize() {
		return this.userList.size();
	}

	public UserList() {

	}
}
