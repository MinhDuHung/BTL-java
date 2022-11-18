import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Entity.User;
import Entity.UserList;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class SignUpPage extends JFrame implements ActionListener {

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
	        	System.out.println(userList.getSize());
	            System.out.println("Error Read file");
	        } 
		 return userList;
	}
	
	public static void WriteObject(User user) {
		UserList userList=ReadObject();
		userList.addUser(user);
        try {   
            FileOutputStream f = new FileOutputStream("userfolder/userList.dat"); 
            ObjectOutputStream oStream = new ObjectOutputStream(f); 
            oStream.writeObject(userList); 
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            
        }
 
	}
	
	private JTextField IDtextField;
	private JTextField PWtextField;
	private JTextField CFtextField;

	SignUpPage() {
		getContentPane().setBackground(new Color(245, 245, 220));
		getContentPane().setLayout(null);
		setVisible(true);
		setBounds(100, 100, 456, 404);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel IDLabel = new JLabel("User name:");
		IDLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		IDLabel.setBounds(86, 90, 103, 20);
		getContentPane().add(IDLabel);

		IDtextField = new JTextField();
		IDtextField.setFont(new Font("Be Vietnam Light", Font.BOLD | Font.ITALIC, 12));
		IDtextField.setBounds(207, 88, 191, 34);
		getContentPane().add(IDtextField);
		IDtextField.setColumns(10);

		JButton OkButton = new JButton("OK");
		OkButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		OkButton.setBackground(new Color(65, 105, 225));
		OkButton.setForeground(new Color(255, 255, 0));
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IDtextField.getText();
				String pw = PWtextField.getText();
				String cf = CFtextField.getText();
				UserList userList=ReadObject();
				if (pw.equals(cf) == false) {
					JOptionPane.showMessageDialog(null, "Hai mat khau khong trung khop!");
				} else if(id.equals(cf)) {
					JOptionPane.showMessageDialog(null, "Ten tai khoan va mat khau khong trung nhau");
				}else if(!userList.CheckUserName(id)) {
					JOptionPane.showMessageDialog(null, "Ten tai khoan da co nguoi dang ky");
				}
				else {
//					
					WriteObject(new User(id,pw));
					JOptionPane.showMessageDialog(null, "Dang ky tai khoan thanh cong!");
//					
				}
			}
		});
		OkButton.setBounds(125, 241, 89, 35);
		getContentPane().add(OkButton);

		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		PasswordLabel.setBounds(96, 136, 102, 23);
		getContentPane().add(PasswordLabel);

		PWtextField = new JTextField();
		PWtextField.setFont(new Font("Be Vietnam Light", Font.BOLD | Font.ITALIC, 12));
		PWtextField.setColumns(10);
		PWtextField.setBounds(207, 133, 191, 34);
		getContentPane().add(PWtextField);

		CFtextField = new JTextField();
		CFtextField.setFont(new Font("Be Vietnam Light", Font.BOLD | Font.ITALIC, 12));
		CFtextField.setColumns(10);
		CFtextField.setBounds(207, 180, 191, 28);
		getContentPane().add(CFtextField);

		JLabel ConfirmPasswordLabel = new JLabel("Confirm PassWord:");
		ConfirmPasswordLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		ConfirmPasswordLabel.setBounds(34, 173, 191, 31);
		getContentPane().add(ConfirmPasswordLabel);

		JButton BackButton = new JButton("Back");
		BackButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		BackButton.setBackground(new Color(255, 69, 0));
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
			}
		});
		BackButton.setBounds(250, 241, 89, 35);
		getContentPane().add(BackButton);

		JLabel mess = new JLabel("Create a new account");
		mess.setBackground(new Color(224, 255, 255));
		mess.setForeground(new Color(148, 0, 211));
		mess.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 20));
		mess.setBounds(137, 36, 202, 23);
		getContentPane().add(mess);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
