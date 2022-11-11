

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.text.MessageFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;

public class GiaoDien extends JFrame {

	private JPanel ContentPanel;
	private JTextField SubTotalJTextfield;
	private JTextField TaxJTextfield;
	private JTextField TotalJTextfield;
	private JTextField CashJTextfield;
	private JTextField ChangeJTextfield;
	private JTable table;
	private JTextField BarCodeJTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("hihi");
		System.out.println("hics");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void ItemCost() {
		double sum = 0;
		for(int i = 1; i < table.getRowCount(); i ++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
			System.out.println(table.getValueAt(i, 2));
		}
		SubTotalJTextfield.setText(Double.toString(sum));
		double cTotal1=Double.parseDouble(SubTotalJTextfield.getText());
		
		double cTax=(cTotal1 *3.9)/100;
		String iTaxTotal=String.format("VND %.2f",cTax);
		TaxJTextfield.setText(iTaxTotal);
		
		String iSubTotal=String.format("VND %.2f",cTotal1);
		SubTotalJTextfield.setText(iSubTotal);
		

		String iTotal=String.format("VND %.2f",cTotal1+cTax);
		TotalJTextfield.setText(iTotal);
		
		String BarCode=String.format("%.2f",cTotal1+cTax);
		BarCodeJTextField.setText(BarCode);
		
	}
	
	public void Change() {
		double sum=0;
		double tax=3.9;
		double cash= Double.parseDouble(CashJTextfield.getText());
		
		for(int i = 1; i < table.getRowCount(); i ++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		double cTax=(sum *3.9)/100;
		double cChange=(cash-(sum+cTax));
		
		String ChangeGiven=String.format("VND %.2f",cChange);
		ChangeJTextfield.setText(ChangeGiven);
	}
	
	public GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 707);
		ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		
		JPanel ScreenPanel = new JPanel();
		ScreenPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ScreenPanel.setBounds(377, 11, 585, 470);
		ContentPanel.add(ScreenPanel);
		ScreenPanel.setLayout(null);
		
		
		JButton ImgButton_1 = new JButton("New button");
		ImgButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem=3.40;
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Hien Ho","1",PriceOfItem});
				ItemCost();
			}
		});
		ImgButton_1.setIcon(new ImageIcon("C:\\Users\\Lautom\\Documents\\BTL java\\BTL-java\\src\\Image\\u3.png"));
		ImgButton_1.setBounds(10, 32, 121, 124);
		ScreenPanel.add(ImgButton_1);
		
		JButton ImgButton_2 = new JButton("New button");
		ImgButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImgButton_2.setIcon(new ImageIcon("C:\\Users\\Lautom\\Documents\\BTL java\\BTL-java\\src\\Image\\u5.png"));
		ImgButton_2.setBounds(157, 32, 121, 124);
		ScreenPanel.add(ImgButton_2);
		
		JButton ImgButton_3 = new JButton("New button");
		ImgButton_3.setIcon(new ImageIcon("C:\\Users\\Lautom\\Documents\\BTL java\\BTL-java\\src\\Image\\u6.png"));
		ImgButton_3.setBounds(300, 32, 121, 124);
		ScreenPanel.add(ImgButton_3);
		
		JButton ImgButton_4 = new JButton("New button");
		ImgButton_4.setBounds(447, 32, 121, 124);
		ScreenPanel.add(ImgButton_4);
		
		JButton ImgButton5 = new JButton("New button");
		ImgButton5.setIcon(new ImageIcon("C:\\Users\\Lautom\\Documents\\BTL java\\BTL-java\\src\\Image\\u4.png"));
		ImgButton5.setBounds(10, 167, 121, 124);
		ScreenPanel.add(ImgButton5);
		
		JButton ImgButton_6 = new JButton("New button");
		ImgButton_6.setBounds(157, 167, 121, 124);
		ScreenPanel.add(ImgButton_6);
		
		JButton ImgButton_7 = new JButton("New button");
		ImgButton_7.setBounds(300, 167, 121, 124);
		ScreenPanel.add(ImgButton_7);
		
		JButton ImgButton_8 = new JButton("New button");
		ImgButton_8.setBounds(447, 167, 121, 124);
		ScreenPanel.add(ImgButton_8);
		
		JButton ImgButton_9 = new JButton("New button");
		ImgButton_9.setBounds(10, 312, 121, 124);
		ScreenPanel.add(ImgButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(157, 312, 121, 124);
		ScreenPanel.add(btnNewButton_10);
		
		JButton ImgButton_11 = new JButton("New button");
		ImgButton_11.setBounds(300, 312, 121, 124);
		ScreenPanel.add(ImgButton_11);
		
		JButton ImgButton_12 = new JButton("New button");
		ImgButton_12.setBounds(447, 312, 121, 124);
		ScreenPanel.add(ImgButton_12);
		
		JPanel ControlPanel = new JPanel();
		ControlPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ControlPanel.setBounds(10, 11, 135, 470);
		ContentPanel.add(ControlPanel);
		ControlPanel.setLayout(null);
		
		
		//function
		
		
		
		
		
		JButton NumberButton1 = new JButton("1");
		NumberButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton1.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton1.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton1.setBounds(10, 27, 46, 58);
		ControlPanel.add(NumberButton1);
		
		JButton NumberButton2 = new JButton("2");
		NumberButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton2.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton2.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton2.setBounds(73, 27, 46, 58);
		ControlPanel.add(NumberButton2);
		
		JButton NumberButton3 = new JButton("3");
		NumberButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton3.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton3.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton3.setBounds(10, 96, 46, 58);
		ControlPanel.add(NumberButton3);
		
		JButton NumberButton4 = new JButton("4");
		NumberButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton4.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton4.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton4.setBounds(73, 96, 46, 58);
		ControlPanel.add(NumberButton4);
		
		JButton NumberButton5 = new JButton("5");
		NumberButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton5.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton5.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton5.setBounds(10, 165, 46, 58);
		ControlPanel.add(NumberButton5);
		
		JButton NumberButton6 = new JButton("6");
		NumberButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton6.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton6.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton6.setBounds(73, 165, 46, 58);
		ControlPanel.add(NumberButton6);
		
		JButton NumberButton7 = new JButton("7");
		NumberButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton7.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton7.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton7.setBounds(10, 234, 46, 58);
		ControlPanel.add(NumberButton7);
		
		JButton NumberButton8 = new JButton("8");
		NumberButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton8.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton8.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton8.setBounds(73, 234, 46, 58);
		ControlPanel.add(NumberButton8);
		
		JButton NumberButton9 = new JButton("9");
		NumberButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton9.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton9.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton9.setBounds(10, 303, 46, 58);
		ControlPanel.add(NumberButton9);
		
		JButton NumberButton0 = new JButton("0");
		NumberButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if(EnterNumber == "") {
					CashJTextfield.setText(NumberButton0.getText());
				}
				else {
					EnterNumber = CashJTextfield.getText() + NumberButton0.getText(); 
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		
		
		
		
		
		NumberButton0.setBounds(73, 303, 46, 58);
		ControlPanel.add(NumberButton0);
		
		JButton CButton = new JButton("C");
		CButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashJTextfield.setText("");
				ChangeJTextfield.setText("");
			}
		});
		CButton.setBounds(30, 372, 64, 44);
		ControlPanel.add(CButton);
		
		JPanel detail = new JPanel();
		detail.setBorder(new MatteBorder(3, 3, 2, 2, (Color) new Color(0, 0, 0)));
		detail.setBounds(27, 511, 935, 146);
		ContentPanel.add(detail);
		detail.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel_1.setBounds(10, 11, 290, 124);
		detail.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel SubTotalLabel = new JLabel("SubTotal");
		SubTotalLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		SubTotalLabel.setBounds(10, 11, 84, 27);
		panel_1.add(SubTotalLabel);
		
		JLabel TaxLable = new JLabel("Tax");
		TaxLable.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		TaxLable.setBounds(10, 49, 84, 27);
		panel_1.add(TaxLable);
		
		JLabel TotalLabel = new JLabel("Total");
		TotalLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		TotalLabel.setBounds(10, 86, 84, 27);
		panel_1.add(TotalLabel);
		
		SubTotalJTextfield = new JTextField();
		SubTotalJTextfield.setBounds(104, 11, 165, 27);
		panel_1.add(SubTotalJTextfield);
		SubTotalJTextfield.setColumns(10);
		
		TaxJTextfield = new JTextField();
		TaxJTextfield.setColumns(10);
		TaxJTextfield.setBounds(104, 49, 165, 27);
		panel_1.add(TaxJTextfield);
		
		TotalJTextfield = new JTextField();
		TotalJTextfield.setColumns(10);
		TotalJTextfield.setBounds(104, 86, 165, 27);
		panel_1.add(TotalJTextfield);
		
		JPanel panel_1_1 = 	new JPanel();
		panel_1_1.setForeground(Color.RED);
		panel_1_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel_1_1.setBounds(310, 11, 302, 124);
		detail.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel ChangeLabel = new JLabel("Change");
		ChangeLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		ChangeLabel.setBounds(10, 86, 84, 27);
		panel_1_1.add(ChangeLabel);
		
		JLabel CashLabel = new JLabel("Cash");
		CashLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		CashLabel.setBounds(10, 49, 84, 27);
		panel_1_1.add(CashLabel);
		
		JLabel PaymentMethodLable = new JLabel("PaymentMethod");
		PaymentMethodLable.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 17));
		PaymentMethodLable.setBounds(10, 11, 134, 27);
		panel_1_1.add(PaymentMethodLable);
		
		CashJTextfield = new JTextField();
		CashJTextfield.setColumns(10);
		CashJTextfield.setBounds(144, 49, 148, 27);
		panel_1_1.add(CashJTextfield);
		
		ChangeJTextfield = new JTextField();
		ChangeJTextfield.setColumns(10);
		ChangeJTextfield.setBounds(144, 86, 148, 27);
		panel_1_1.add(ChangeJTextfield);
		
		JComboBox PaymentMethodJComboBox = new JComboBox();
		PaymentMethodJComboBox.setFont(new Font("Stencil", Font.PLAIN, 15));
		PaymentMethodJComboBox.setModel(new DefaultComboBoxModel(new String[] {"Tien mat", "Chuyen khoan ngan hang", "Ghi no"}));
		PaymentMethodJComboBox.setSelectedIndex(-1);
		PaymentMethodJComboBox.setBounds(144, 16, 148, 22);
		panel_1_1.add(PaymentMethodJComboBox);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel_1_2.setBounds(622, 11, 303, 124);
		detail.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton BuyJButton = new JButton("BUY");
		BuyJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PaymentMethodJComboBox.getSelectedItem().equals("Tien mat")) {
					Change();
				}
				else {
					ChangeJTextfield.setText("");
					CashJTextfield.setText("");
					
				}
			}
		});
		BuyJButton.setForeground(Color.RED);
		BuyJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		BuyJButton.setBounds(10, 11, 97, 41);
		panel_1_2.add(BuyJButton);
		
		JButton PrintfJButton = new JButton("PRINTF");
		PrintfJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat Header =new MessageFormat("Đang in");
				MessageFormat Footer =new MessageFormat("Trang {0,number,interger}");
				try {
					table.print(JTable.PrintMode.NORMAL,Header,Footer);
				}
				catch(java.awt.print.PrinterException e) {
					System.err.format("Không tìm thấy máy in", e.getMessage());
				}
			}
		});
		PrintfJButton.setForeground(Color.RED);
		PrintfJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		PrintfJButton.setBounds(10, 62, 97, 41);
		panel_1_2.add(PrintfJButton);
		
		JButton RemoveJButton = new JButton("REMOVE");
		RemoveJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int RemoveItem=table.getSelectedRow();
				if(RemoveItem>0)
				{
					model.removeRow(RemoveItem);
					
				}
				ItemCost();
				if(PaymentMethodJComboBox.getSelectedItem().equals("Tien mat")) {
					Change();
				}
				else {
					ChangeJTextfield.setText("");
					CashJTextfield.setText("");
					
				}
			}
		});
		RemoveJButton.setForeground(Color.RED);
		RemoveJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		RemoveJButton.setBounds(117, 11, 97, 41);
		panel_1_2.add(RemoveJButton);
		
		JButton ResetJButton = new JButton("RESET");
		ResetJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				ChangeJTextfield.setText("");
				TaxJTextfield.setText("");
				TotalJTextfield.setText("");
				SubTotalJTextfield.setText("");
				CashJTextfield.setText("");
				BarCodeJTextField.setText("");
			}
		});
		ResetJButton.setForeground(Color.RED);
		ResetJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ResetJButton.setBounds(117, 62, 97, 41);
		panel_1_2.add(ResetJButton);
		
		JButton ExitJButton = new JButton("EXIT");
		ExitJButton.setBackground(new Color(64, 64, 64));
		ExitJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ExitJButton.setForeground(Color.BLUE);
		ExitJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ExitJButton.setBounds(228, 11, 65, 89);
		panel_1_2.add(ExitJButton);
		
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Item", "Qty", "Amount"},
			},
			new String[] {
				"1", "2", "3"
			}
		));
		table.setBounds(155, 11, 213, 387);
		ContentPanel.add(table);
		
		BarCodeJTextField = new JTextField();
		BarCodeJTextField.setBounds(155, 409, 212, 72);
		ContentPanel.add(BarCodeJTextField);
		BarCodeJTextField.setColumns(10);
		BarCodeJTextField.setFont(new Font("Code39",Font.PLAIN,60));
	}
}
