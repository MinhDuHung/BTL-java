package Entity;

import java.io.Serializable;

public class User implements Serializable{
	public String userName;
	public String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	User(String userName,String password){
		this.userName=userName;
		this.password=password;
	}
	public User(){
		
	}
}
