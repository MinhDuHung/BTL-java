import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.text.MessageFormat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class GiaoDien extends JFrame {
	private JPanel ContentPanel;
	private JTextField SubTotalJTextfield;
	private JTextField TaxJTextfield;
	private JTextField TotalJTextfield;
	private JTextField CashJTextfield;
	private JTextField ChangeJTextfield;
	private JTable table;
	private JTextField BarCodeJTextField;

	public void ItemCost() {
		double sum = 0;
		for (int i = 1; i < table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		SubTotalJTextfield.setText(Double.toString(sum));
		double cTotal1 = Double.parseDouble(SubTotalJTextfield.getText());

		double cTax = (cTotal1 * 4) / 100;
		String iTaxTotal = String.format("VND %.2f", cTax);
		TaxJTextfield.setText(iTaxTotal);

		String iSubTotal = String.format("VND %.2f", cTotal1);
		SubTotalJTextfield.setText(iSubTotal);

		String BarCode = String.format("%.2f", cTotal1 + cTax);
		BarCodeJTextField.setText(BarCode);
	}

	public void Change1() {

		double sum = 0;
		double cash = Double.parseDouble(CashJTextfield.getText());
		for (int i = 1; i < table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		double cTax = (sum * 4) / 100;
		double cChange = (cash - (sum + cTax));
		String ChangeGiven = String.format("VND %.2f", cChange);
		ChangeJTextfield.setText(ChangeGiven);
		TotalJTextfield.setText(String.format("VND %.2f",cash-cChange));
	}

	public void Change2() {

		double sum = 0;
		double cash = Double.parseDouble(CashJTextfield.getText());
		for (int i = 1; i < table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		double cTax = (sum * 2) / 100;
		double cChange = (cash - (sum + cTax));
		String ChangeGiven = String.format("VND %.2f", cChange);
		ChangeJTextfield.setText(ChangeGiven);
		TotalJTextfield.setText(String.format("VND %.2f",cash-cChange));
	}

	public void Change3() {

		double sum = 0;
		double cash = Double.parseDouble(CashJTextfield.getText());
		for (int i = 1; i < table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		double cTax = (sum * 1.5) / 100;
		double cChange = (cash - (sum + cTax));
		String ChangeGiven = String.format("VND %.2f", cChange);
		ChangeJTextfield.setText(ChangeGiven);
		TotalJTextfield.setText(String.format("VND %.2f",cash-cChange));
	}

	public GiaoDien(String UserID) {
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Hello " + UserID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 706);
		ContentPanel = new JPanel();
		ContentPanel.setBackground(new Color(135, 206, 235));
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);

		JPanel ScreenPanel = new JPanel();
		ScreenPanel.setBackground(new Color(255, 255, 224));
		ScreenPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ScreenPanel.setBounds(475, 11, 585, 470);
		ContentPanel.add(ScreenPanel);
		ScreenPanel.setLayout(null);

		JButton ImgButton_1 = new JButton("New button");
		ImgButton_1.setBackground(Color.WHITE);
		ImgButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 44000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Coca chanh")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Coca chanh", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_1.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/Untitled-1.png")));
		ImgButton_1.setBounds(10, 32, 121, 134);
		ScreenPanel.add(ImgButton_1);

		JButton ImgButton_2 = new JButton("New button");
		ImgButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 35000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc duong chanh bac ha")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc duong chanh bac ha", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_2.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/Untitled-2.png")));
		ImgButton_2.setBounds(157, 32, 121, 134);
		ScreenPanel.add(ImgButton_2);

		JButton ImgButton_3 = new JButton("New button");
		ImgButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 45000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc que chanh")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc que chanh", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_3.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u3.png")));
		ImgButton_3.setBounds(300, 32, 121, 134);
		ScreenPanel.add(ImgButton_3);

		JButton ImgButton_4 = new JButton("New button");
		ImgButton_4.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u4.png")));
		ImgButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 45000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Combo nuoc ep chanh va dau")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Combo nuoc ep chanh va dau", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_4.setBounds(447, 32, 121, 134);
		ScreenPanel.add(ImgButton_4);

		JButton ImgButton_5 = new JButton("New button");
		ImgButton_5.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u5.png")));
		ImgButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 27000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Bia SaiGon F1")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Bia SaiGon F1", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_5.setBounds(10, 177, 121, 134);
		ScreenPanel.add(ImgButton_5);

		JButton ImgButton_6 = new JButton("New button");
		ImgButton_6.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u6.png")));
		ImgButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 25000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Cafe sua")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Cafe sua", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_6.setBounds(157, 177, 121, 134);
		ScreenPanel.add(ImgButton_6);

		JButton ImgButton_7 = new JButton("New button");
		ImgButton_7.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u7.png")));
		ImgButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 26000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Combo 3 nuoc ngam hoa qua")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Combo 3 nuoc ngam hoa qua", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_7.setBounds(300, 177, 121, 134);
		ScreenPanel.add(ImgButton_7);

		JButton ImgButton_8 = new JButton("New button");
		ImgButton_8.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u8.png")));
		ImgButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 37000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Bia HaNoi F1")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Bia HaNoi F1", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_8.setBounds(447, 177, 121, 134);
		ScreenPanel.add(ImgButton_8);

		JButton ImgButton_9 = new JButton("New button");
		ImgButton_9.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u9.png")));
		ImgButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 48000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc ep chanh Thuy Sy")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc ep chanh Thuy Sy", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_9.setBounds(10, 325, 121, 134);
		ScreenPanel.add(ImgButton_9);

		JButton ImgButton_10 = new JButton("New button");
		ImgButton_10.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u10.png")));
		ImgButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 50000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc ep chanh leo Ha Lan")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc ep chanh leo Ha Lan", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_10.setBounds(157, 325, 121, 134);
		ScreenPanel.add(ImgButton_10);

		JButton ImgButton_11 = new JButton("New button");
		ImgButton_11.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u11.png")));
		ImgButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 40000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc ep dau Phap")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc ep dau Phap", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_11.setBounds(300, 325, 121, 134);
		ScreenPanel.add(ImgButton_11);

		JButton ImgButton_12 = new JButton("New button");
		ImgButton_12.setIcon(new ImageIcon(GiaoDien.class.getResource("/Image/u12.png")));
		ImgButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PriceOfItem = 65000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int x = -1;
				for (int i = 1; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals("Nuoc ngam chuoi Bi")) {
						x = Integer.parseInt(table.getValueAt(i, 1).toString()) + 1;
						PriceOfItem *= x;
						table.setValueAt(x, i, 1);
						table.setValueAt(PriceOfItem, i, 2);
						break;
					}
				}
				if (x == -1) {
					model.addRow(new Object[] { "Nuoc ngam chuoi Bi", "1", PriceOfItem });
				}
				ItemCost();
			}
		});
		ImgButton_12.setBounds(447, 325, 121, 134);
		ScreenPanel.add(ImgButton_12);

		JPanel ControlPanel = new JPanel();
		ControlPanel.setBackground(new Color(255, 218, 185));
		ControlPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ControlPanel.setBounds(10, 11, 155, 470);
		ContentPanel.add(ControlPanel);
		ControlPanel.setLayout(null);

		// function

		JButton NumberButton1 = new JButton("1");
		NumberButton1.setFocusable(false);
		NumberButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton1.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton1.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton1.setBounds(21, 27, 46, 58);
		ControlPanel.add(NumberButton1);

		JButton NumberButton2 = new JButton("2");
		NumberButton2.setFocusable(false);
		NumberButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton2.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton2.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton2.setBounds(84, 27, 46, 58);
		ControlPanel.add(NumberButton2);

		JButton NumberButton3 = new JButton("3");
		NumberButton3.setFocusable(false);
		NumberButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton3.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton3.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton3.setBounds(21, 96, 46, 58);
		ControlPanel.add(NumberButton3);

		JButton NumberButton4 = new JButton("4");
		NumberButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton4.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton4.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton4.setBounds(84, 96, 46, 58);
		ControlPanel.add(NumberButton4);

		JButton NumberButton5 = new JButton("5");
		NumberButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton5.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton5.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton5.setBounds(21, 165, 46, 58);
		ControlPanel.add(NumberButton5);

		JButton NumberButton6 = new JButton("6");
		NumberButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton6.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton6.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton6.setBounds(84, 165, 46, 58);
		ControlPanel.add(NumberButton6);

		JButton NumberButton7 = new JButton("7");
		NumberButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton7.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton7.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton7.setBounds(21, 234, 46, 58);
		ControlPanel.add(NumberButton7);

		JButton NumberButton8 = new JButton("8");
		NumberButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton8.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton8.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton8.setBounds(84, 234, 46, 58);
		ControlPanel.add(NumberButton8);

		JButton NumberButton9 = new JButton("9");
		NumberButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton9.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton9.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton9.setBounds(21, 303, 46, 58);
		ControlPanel.add(NumberButton9);

		JButton NumberButton0 = new JButton("0");
		NumberButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = CashJTextfield.getText();
				if (EnterNumber == "") {
					CashJTextfield.setText(NumberButton0.getText());
				} else {
					EnterNumber = CashJTextfield.getText() + NumberButton0.getText();
					CashJTextfield.setText(EnterNumber);
				}
			}
		});
		NumberButton4.setFocusable(false);
		NumberButton5.setFocusable(false);
		NumberButton6.setFocusable(false);
		NumberButton7.setFocusable(false);
		NumberButton8.setFocusable(false);
		NumberButton9.setFocusable(false);
		NumberButton0.setFocusable(false);
		NumberButton0.setBounds(84, 303, 46, 58);
		ControlPanel.add(NumberButton0);

		JButton CButton = new JButton("C");
		CButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashJTextfield.setText("");
				ChangeJTextfield.setText("");
			}
		});
		CButton.setBounds(45, 382, 64, 44);
		ControlPanel.add(CButton);

		JPanel detail = new JPanel();
		detail.setBorder(new MatteBorder(3, 3, 2, 2, (Color) new Color(0, 0, 0)));
		detail.setBounds(63, 510, 935, 146);
		ContentPanel.add(detail);
		detail.setLayout(null);

		JPanel Panel_1 = new JPanel();
		Panel_1.setBackground(new Color(255, 245, 238));
		Panel_1.setForeground(new Color(255, 143, 89));
		Panel_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		Panel_1.setBounds(10, 11, 290, 124);
		detail.add(Panel_1);
		Panel_1.setLayout(null);

		JLabel SubTotalLabel = new JLabel("SubTotal");
		SubTotalLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		SubTotalLabel.setBounds(10, 11, 84, 27);
		Panel_1.add(SubTotalLabel);

		JLabel TaxLable = new JLabel("Tax");
		TaxLable.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		TaxLable.setBounds(10, 49, 84, 27);
		Panel_1.add(TaxLable);

		JLabel TotalLabel = new JLabel("Total");
		TotalLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		TotalLabel.setBounds(10, 86, 84, 27);
		Panel_1.add(TotalLabel);

		SubTotalJTextfield = new JTextField();
		SubTotalJTextfield.setEditable(false);
		SubTotalJTextfield.setBounds(104, 11, 165, 27);
		Panel_1.add(SubTotalJTextfield);
		SubTotalJTextfield.setColumns(10);

		TaxJTextfield = new JTextField();
		TaxJTextfield.setEditable(false);
		TaxJTextfield.setColumns(10);
		TaxJTextfield.setBounds(104, 49, 165, 27);
		Panel_1.add(TaxJTextfield);

		TotalJTextfield = new JTextField();
		TotalJTextfield.setEditable(false);
		TotalJTextfield.setColumns(10);
		TotalJTextfield.setBounds(104, 86, 165, 27);
		Panel_1.add(TotalJTextfield);

		JPanel Panel_2 = new JPanel();
		Panel_2.setBackground(new Color(255, 250, 205));
		Panel_2.setForeground(Color.RED);
		Panel_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		Panel_2.setBounds(310, 11, 302, 124);
		detail.add(Panel_2);
		Panel_2.setLayout(null);

		JLabel ChangeLabel = new JLabel("Change");
		ChangeLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		ChangeLabel.setBounds(10, 86, 84, 27);
		Panel_2.add(ChangeLabel);

		JLabel CashLabel = new JLabel("Cash");
		CashLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		CashLabel.setBounds(10, 49, 84, 27);
		Panel_2.add(CashLabel);

		JLabel PaymentMethodLable = new JLabel("PaymentMethod");
		PaymentMethodLable.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 17));
		PaymentMethodLable.setBounds(10, 11, 134, 27);
		Panel_2.add(PaymentMethodLable);

		CashJTextfield = new JTextField();
		CashJTextfield.setColumns(10);
		CashJTextfield.setBounds(144, 49, 148, 27);
		Panel_2.add(CashJTextfield);

		ChangeJTextfield = new JTextField();
		ChangeJTextfield.setEditable(false);
		ChangeJTextfield.setColumns(10);
		ChangeJTextfield.setBounds(144, 86, 148, 27);
		Panel_2.add(ChangeJTextfield);

		JComboBox PaymentMethodJComboBox = new JComboBox();
		PaymentMethodJComboBox.setFont(new Font("Stencil", Font.PLAIN, 15));
		PaymentMethodJComboBox.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Banking", "Momo" }));
		PaymentMethodJComboBox.setSelectedIndex(-1);
		PaymentMethodJComboBox.setBounds(144, 16, 148, 22);
		Panel_2.add(PaymentMethodJComboBox);

		JPanel Panel_3 = new JPanel();
		Panel_3.setBackground(new Color(245, 245, 220));
		Panel_3.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		Panel_3.setBounds(622, 11, 303, 124);
		detail.add(Panel_3);
		Panel_3.setLayout(null);

		JButton BuyJButton = new JButton("BUY");
		BuyJButton.setFocusable(false);
		BuyJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PaymentMethodJComboBox.getSelectedItem().equals("Cash")) {
					Change1();
				} else if (PaymentMethodJComboBox.getSelectedItem().equals("Banking")) {
					Change2();
				} else
					Change3();
			}
		});
		BuyJButton.setForeground(Color.RED);
		BuyJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		BuyJButton.setBounds(10, 11, 97, 41);
		Panel_3.add(BuyJButton);

		JButton PrintfJButton = new JButton("PRINTF");
		PrintfJButton.setFocusable(false);
		PrintfJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat Header = new MessageFormat("Bill");
				MessageFormat Footer = new MessageFormat("Page {0,number,interger}");
				try {
					table.print(JTable.PrintMode.NORMAL, Header, Footer);
				} catch (java.awt.print.PrinterException er) {
					System.err.format("not found", er.getMessage());
				}
			}
		});
		PrintfJButton.setForeground(Color.RED);
		PrintfJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		PrintfJButton.setBounds(10, 62, 97, 41);
		Panel_3.add(PrintfJButton);

		JButton RemoveJButton = new JButton("REMOVE");
		RemoveJButton.setFocusable(false);
		RemoveJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int RemoveItem = table.getSelectedRow();
				if (RemoveItem > 0) {
					model.removeRow(RemoveItem);

				}
				ItemCost();
				if (PaymentMethodJComboBox.getSelectedItem().equals("Cash")) {
					Change1();
				} else if (PaymentMethodJComboBox.getSelectedItem().equals("Banking")) {
					Change2();
				} else
					Change3();
			}
		});
		RemoveJButton.setForeground(Color.RED);
		RemoveJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		RemoveJButton.setBounds(117, 11, 97, 41);
		Panel_3.add(RemoveJButton);

		JButton ResetJButton = new JButton("RESET");
		ResetJButton.setFocusable(false);
		ResetJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				CashJTextfield.setText("");
				ChangeJTextfield.setText("");
				BarCodeJTextField.setText("");
				TaxJTextfield.setText("");
				SubTotalJTextfield.setText("");
				TotalJTextfield.setText("");
			}
		});
		ResetJButton.setForeground(Color.RED);
		ResetJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ResetJButton.setBounds(117, 62, 97, 41);
		Panel_3.add(ResetJButton);
		JButton ExitJButton = new JButton("EXIT");
		ExitJButton.setFocusable(false);
		ExitJButton.setBackground(new Color(224, 255, 255));
		ExitJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you wanna exit", "Point of sale",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		ExitJButton.setForeground(Color.BLUE);
		ExitJButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ExitJButton.setBounds(228, 11, 65, 89);
		Panel_3.add(ExitJButton);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(
				new DefaultTableModel(new Object[][] { { "Item", "Qty", "Amount" }, }, new String[] { "1", "2", "3" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.setBounds(175, 11, 290, 387);
		ContentPanel.add(table);

		BarCodeJTextField = new JTextField();
		BarCodeJTextField.setEditable(false);
		BarCodeJTextField.setBounds(175, 409, 290, 72);
		ContentPanel.add(BarCodeJTextField);
		BarCodeJTextField.setColumns(10);
		BarCodeJTextField.setFont(new Font("barcode font", Font.PLAIN, 62));
	}
}