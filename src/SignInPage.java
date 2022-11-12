import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SignInPage extends JFrame implements ActionListener {
	IDandPassword IaP = new IDandPassword();
	private JTextField IDtextField;
	private JTextField PWtextField;
	private JTextField CFtextField;
	SignInPage(){
		getContentPane().setLayout(null);
		setVisible(true);
		setBounds(100,100,456, 404);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel IDLabel = new JLabel("User name:");
		IDLabel.setBounds(87, 76, 70, 14);
		getContentPane().add(IDLabel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(167, 73, 191, 20);
		getContentPane().add(IDtextField);
		IDtextField.setColumns(10);
		
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IDtextField.getText();
				String pw = PWtextField.getText();
				IaP.logininfo.put(id,pw);
				
			}
		});
		OkButton.setBounds(125, 180, 89, 23);
		getContentPane().add(OkButton);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(97, 107, 69, 14);
		getContentPane().add(PasswordLabel);
		
		PWtextField = new JTextField();
		PWtextField.setColumns(10);
		PWtextField.setBounds(167, 104, 191, 20);
		getContentPane().add(PWtextField);
		
		CFtextField = new JTextField();
		CFtextField.setColumns(10);
		CFtextField.setBounds(167, 135, 191, 20);
		getContentPane().add(CFtextField);
		
		JLabel ConfirmPasswordLabel = new JLabel("Confirm PassWord:");
		ConfirmPasswordLabel.setBounds(37, 138, 125, 14);
		getContentPane().add(ConfirmPasswordLabel);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDandPassword idandPassword = new IDandPassword();
				LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());
			}
		});
		BackButton.setBounds(269, 180, 89, 23);
		getContentPane().add(BackButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
