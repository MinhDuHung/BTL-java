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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.User;

public class LoginPage implements ActionListener {

	HashMap<String, String> logininfo = new HashMap<String, String>();

	public static void main(String[] args) {
		IDandPassword idandPassword = new IDandPassword();
		LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());
		
		FetchDataUser();
	}
	public static void FetchDataUser() {
		 User ms = null;
		 
	        try {  
	            FileInputStream f = new FileInputStream("userInfor.txt"); 
	            ObjectInputStream inStream = new ObjectInputStream(f);  
	           
	            ms = (User) inStream.readObject();
	            inStream.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class not found");
	        } catch (IOException e) {
	            System.out.println("Error Read file");
	        }
	        System.out.println("My name is " + ms.userName + ". I am " + ms.password + " years old");
	    }
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User Name: ");
	JLabel userPasswordLabel = new JLabel("Password: ");

	JLabel messageLable = new JLabel();

	JButton SignInButton = new JButton("Sign in");

	LoginPage(HashMap<String, String> loginInfoOriginal) {

		logininfo = loginInfoOriginal;
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
		SignInButton.addActionListener(this);
		SignInButton.setForeground(new Color(255, 255, 255));
		SignInButton.setBackground(new Color(119, 136, 153));
		SignInButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		SignInButton.setFocusable(false);
		SignInButton.setBounds(195, 246, 100, 25);
		
		frame.getContentPane().add(SignInButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if (e.getSource() == SignInButton) {
			frame.dispose();
			SignInPage SP = new SignInPage();
		}
		if (e.getSource() == loginButton) {

			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());

			if (logininfo.containsKey(userID)) {
				if (logininfo.get(userID).equals(password)) {
					messageLable.setForeground(Color.green);
					messageLable.setText("Login Success!");
					frame.dispose();
					GiaoDien gd = new GiaoDien(userID);
				} else {
					messageLable.setForeground(Color.red);
					messageLable.setText("Wrong Password!");
				}
			} else {
				messageLable.setForeground(Color.red);
				messageLable.setText("username not found!");
			}
		}
	}

<<<<<<< Updated upstream
}
=======
	public static void main(String[] args) {
		LoginPage loginPage = new LoginPage();
		
	}

}
>>>>>>> Stashed changes
