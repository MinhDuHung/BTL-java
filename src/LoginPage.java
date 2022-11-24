import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.User;
import Entity.UserList;

public class LoginPage implements ActionListener {

	public static UserList ReadObject() {
		UserList userList=new UserList();
		 try {  
	            FileInputStream f = new FileInputStream("userfolder/userList.dat"); 
	            ObjectInputStream inStream = new ObjectInputStream(f); 
	           
	            userList = (UserList) inStream.readObject();
	            inStream.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class not found");
	        } catch (IOException e) {
	            System.out.println("Error Read file");
	            
	        }
		 return userList;
	}
	
//	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User Name: ");
	JLabel userPasswordLabel = new JLabel("Password: ");

	JLabel messageLable = new JLabel();

	JButton SignUpButton = new JButton("Sign Up");

	LoginPage() {

//		logininfo = loginInfoOriginal;
		userIDLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));

		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		userPasswordLabel.setBounds(50, 150, 75, 25);

		messageLable.setBounds(125, 282, 250, 35);
		messageLable.setFont(new Font(null, Font.ITALIC, 25));
		userIDField.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));

		userIDField.setBounds(125, 100, 242, 25);
		userPasswordField.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		userPasswordField.setBounds(125, 150, 242, 25);
		loginButton.setForeground(new Color(255, 0, 0));
		loginButton.setBackground(new Color(102, 205, 170));
		loginButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));

		loginButton.setBounds(124, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setBackground(new Color(153, 50, 204));
		resetButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));

		resetButton.setBounds(267, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLable);
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.getContentPane().setBackground(new Color(255, 248, 220));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,456, 404);
		frame.getContentPane().setLayout(null);
		SignUpButton.addActionListener(this);
		SignUpButton.setForeground(new Color(255, 255, 255));
		SignUpButton.setBackground(new Color(119, 136, 153));
		SignUpButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		SignUpButton.setFocusable(false);
		SignUpButton.setBounds(195, 246, 100, 25);
		
		frame.getContentPane().add(SignUpButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserList userList=ReadObject();	
		if (e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if (e.getSource() == SignUpButton) {
			frame.dispose();
			SignUpPage SP = new SignUpPage();
		}
		if (e.getSource() == loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());			
			
			if(userList.find(userID, password)==true) {
				frame.dispose();
				GiaoDien gd = new GiaoDien(userID);
			}else {
				JOptionPane.showMessageDialog(null, "Sai tai khoan/mat khau!");
			}
		}
	}

	public static void main(String[] args) {
		LoginPage loginPage = new LoginPage();
		
	}

}