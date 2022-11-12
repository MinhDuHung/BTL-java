import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class SignInPage extends JFrame implements ActionListener {
	IDandPassword IaP = new IDandPassword();
	private JTextField IDtextField;
	private JTextField PWtextField;
	private JTextField CFtextField;
	SignInPage(){
		getContentPane().setBackground(new Color(245, 245, 220));
		getContentPane().setLayout(null);
		setVisible(true);
		setBounds(100,100,456, 404);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel IDLabel = new JLabel("User name:");
		IDLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		IDLabel.setBounds(84, 90, 103, 20);
		getContentPane().add(IDLabel);
		
		IDtextField = new JTextField();
		IDtextField.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		IDtextField.setBounds(207, 90, 191, 20);
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
				IaP.logininfo.put(id,pw);
				
			}
		});
		OkButton.setBounds(125, 241, 89, 35);
		getContentPane().add(OkButton);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		PasswordLabel.setBounds(96, 136, 102, 23);
		getContentPane().add(PasswordLabel);
		
		PWtextField = new JTextField();
		PWtextField.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		PWtextField.setColumns(10);
		PWtextField.setBounds(207, 135, 191, 20);
		getContentPane().add(PWtextField);
		
		CFtextField = new JTextField();
		CFtextField.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		CFtextField.setColumns(10);
		CFtextField.setBounds(207, 173, 191, 20);
		getContentPane().add(CFtextField);
		
		JLabel ConfirmPasswordLabel = new JLabel("Confirm PassWord:");
		ConfirmPasswordLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		ConfirmPasswordLabel.setBounds(35, 170, 191, 31);
		getContentPane().add(ConfirmPasswordLabel);
		
		JButton BackButton = new JButton("Back");
		BackButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		BackButton.setBackground(new Color(255, 69, 0));
		BackButton.setForeground(new Color(255, 255, 255));
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDandPassword idandPassword = new IDandPassword();
				LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());
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
