// Date of program submission:- 02-14-2014
/* Program for Data entry by asv130130 (Name:- AMOL VAZE )*/
// Code for entire GUI class with basic methods implemented

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class dataentry2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField fname1;
	private static JTextField lname1;
	private static JTextField add1;
	private static JTextField add2;
	private static JTextField city1;
	private static JTextField state1;
	private static JTextField zip1;
	private static JTextField phone1;
	private static JTextField country1;
	private static JTextField email1;
	private static JTable table;
	private static DefaultTableModel dmodel;
	private static JTextField mname;
	ArrayList<StorageData> mydata;
	private static JLabel emailval;
	private static JLabel status;
	private static JLabel phoneval;
	private static JLabel zipval;
	boolean isFnameValid;
	boolean isMnameValid;
	boolean isLnameValid;
	boolean isadd1Valid;
	boolean isadd2Valid;
	boolean isPhoneValid;
	boolean isZipValid;
	boolean isCityValid;
	boolean isStateValid;
	boolean isCountryValid;
	static StorageData d = new StorageData();
	int selRow = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dataentry2 frame = new dataentry2();
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
	/**
	 * @throws IOException
	 */
	// Constructor of main GUI class
	public dataentry2() throws IOException {
		super("Data Entry Form");
        
		mydata = new ArrayList<StorageData>();
		mydata = Manupulations.read();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 476);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel fname = new JLabel("Firstname *");
		fname.setForeground(new Color(0, 0, 205));
		fname.setFont(new Font("Tahoma", Font.BOLD, 12));
		fname.setBounds(21, 11, 102, 14);
		contentPane.add(fname);

		JLabel lname = new JLabel("Lastname *");
		lname.setForeground(new Color(0, 0, 205));
		lname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lname.setBounds(21, 50, 74, 14);
		contentPane.add(lname);

		JLabel address1 = new JLabel("Address 1 *");
		address1.setForeground(new Color(0, 0, 205));
		address1.setFont(new Font("Tahoma", Font.BOLD, 12));
		address1.setBounds(21, 94, 74, 14);
		contentPane.add(address1);

		JLabel address2 = new JLabel("Address 2 ");
		address2.setForeground(new Color(0, 0, 205));
		address2.setFont(new Font("Tahoma", Font.BOLD, 12));
		address2.setBounds(21, 139, 74, 14);
		contentPane.add(address2);

		JLabel city = new JLabel("City *");
		city.setForeground(new Color(0, 0, 205));
		city.setFont(new Font("Tahoma", Font.BOLD, 12));
		city.setBounds(21, 184, 46, 14);
		contentPane.add(city);

		JLabel state = new JLabel("State *");
		state.setForeground(new Color(0, 0, 205));
		state.setFont(new Font("Tahoma", Font.BOLD, 12));
		state.setBounds(21, 228, 46, 14);
		contentPane.add(state);

		JLabel zip = new JLabel("Zip *");
		zip.setForeground(new Color(0, 0, 205));
		zip.setFont(new Font("Tahoma", Font.BOLD, 12));
		zip.setBounds(21, 264, 46, 14);
		contentPane.add(zip);

		JLabel phone = new JLabel("Phone *");
		phone.setForeground(new Color(0, 0, 205));
		phone.setFont(new Font("Tahoma", Font.BOLD, 12));
		phone.setBounds(21, 305, 74, 14);
		contentPane.add(phone);

		JLabel country = new JLabel("Country *");
		country.setForeground(new Color(0, 0, 205));
		country.setFont(new Font("Tahoma", Font.BOLD, 12));
		country.setBounds(21, 354, 74, 14);
		contentPane.add(country);

		JLabel email = new JLabel("Email *");
		email.setForeground(new Color(0, 0, 205));
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(21, 399, 46, 14);
		contentPane.add(email);

		fname1 = new JTextField(20);
		fname1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isFnameValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isFnameValid = false;
				}
				if (!isFnameValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}		
				
				
				
				
				
				
			}
		});
		fname1.setForeground(Color.BLACK);
		fname1.setBackground(Color.WHITE);
		fname1.setBounds(114, 9, 164, 20);
		contentPane.add(fname1);
		fname1.setColumns(10);
		// Code For Limiting Characters Length
		fname1.setDocument(new TextLimit(20));

		lname1 = new JTextField(20);
		lname1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isLnameValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isLnameValid = false;
				}
				if (!isLnameValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}		
				
				
				
				
				
				
				
			}
		});
		lname1.setForeground(Color.BLACK);
		lname1.setBounds(114, 48, 164, 20);
		contentPane.add(lname1);
		lname1.setColumns(10);
		lname1.setDocument(new TextLimit(20));

		add1 = new JTextField(35);
		add1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				/* isadd1Valid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isadd1Valid = false;
				}
				if (!isadd1Valid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}	*/
				
		}
		});
		add1.setForeground(Color.BLACK);
		add1.setBounds(114, 92, 164, 20);
		contentPane.add(add1);
		add1.setColumns(10);
		add1.setDocument(new TextLimit(35));

		add2 = new JTextField(35);
		add2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				/*isadd2Valid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isadd2Valid = false;
				}
				if (!isadd2Valid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}*/
				
	}
		});
		add2.setForeground(Color.BLACK);
		add2.setBounds(114, 137, 164, 20);
		contentPane.add(add2);
		add2.setColumns(10);
		add2.setDocument(new TextLimit(35));

		city1 = new JTextField(25);
		city1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isCityValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isCityValid = false;
				}
				if (!isCityValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
				
			}	});
		city1.setForeground(Color.BLACK);
		city1.setBounds(114, 182, 164, 20);
		contentPane.add(city1);
		city1.setColumns(10);
		city1.setDocument(new TextLimit(25));

		state1 = new JTextField(2);
		state1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isStateValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isStateValid = false;
				}
				if (!isStateValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
	}
		});
		state1.setForeground(Color.BLACK);
		state1.setBounds(114, 226, 164, 20);
		contentPane.add(state1);
		state1.setColumns(10);
		state1.setDocument(new TextLimit(2));

		zip1 = new JTextField(20);
		zip1.setForeground(Color.BLACK);
		// Code for zipcode validation
		zip1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isZipValid = true;
				char c = ev.getKeyChar();
				if (!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					ev.consume();
					isZipValid = false;
				}
				if (!isZipValid) {
					zipval.setText("Please Enter Valid Zipcode ");

				} else {
					zipval.setText("");

				}

			}
		});
		zip1.setBounds(114, 262, 164, 20);
		contentPane.add(zip1);
		zip1.setColumns(10);
		zip1.setDocument(new TextLimit(9));

		phone1 = new JTextField(21);
		phone1.setForeground(Color.BLACK);

		// Code for phone number validation
		phone1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ex) {
				isPhoneValid = true;
				char ch = ex.getKeyChar();
				if (!Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE)
						|| (ch == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					ex.consume();
					isPhoneValid = false;
				}
				if (!isPhoneValid) {
					phoneval.setText("Please Enter Valid Phone Number ");

				} else {
					phoneval.setText("");

				}

			}
		});
		phone1.setBounds(114, 303, 164, 20);
		contentPane.add(phone1);
		phone1.setColumns(10);
		phone1.setDocument(new TextLimit(21));

		country1 = new JTextField(30);
		country1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isCountryValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isCountryValid = false;
				}
				if (!isCountryValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
	}
		});
		country1.setForeground(Color.BLACK);
		country1.setBounds(114, 352, 164, 20);
		contentPane.add(country1);
		country1.setColumns(10);
		country1.setDocument(new TextLimit(30));

		email1 = new JTextField(100);
		email1.setForeground(Color.BLACK);
		email1.setBounds(114, 397, 164, 20);
		contentPane.add(email1);
		email1.setColumns(10);
		email1.setDocument(new TextLimit(100));

		JButton Add = new JButton("ADD");
		Add.setBackground(new Color(230, 230, 250));
		Add.setForeground(new Color(0, 0, 205));
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				saveToFile();

			}
		});
		Add.setFont(new Font("Tahoma", Font.BOLD, 12));
		Add.setBounds(312, 346, 89, 31);
		contentPane.add(Add);

		final JButton Update = new JButton("UPDATE");
		Update.setBackground(new Color(230, 230, 250));
		Update.setForeground(new Color(0, 0, 205));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         // Code for preventing empty data records being entered
				
				if ((fname1.getText().equalsIgnoreCase(""))
						&& (lname1.getText().equalsIgnoreCase(""))
						&& (add1.getText().equalsIgnoreCase(""))
						&& (city1.getText().equalsIgnoreCase(""))
						&& (state1.getText().equalsIgnoreCase(""))
						&& (zip1.getText().equalsIgnoreCase(""))
						&& (country1.getText().equalsIgnoreCase(""))
						&& (phone1.getText().equalsIgnoreCase(""))
						&& (email1.getText().equalsIgnoreCase(""))) {
					status.setText("Please Select Row");
				} else {

					int selRow = table.getSelectedRow();

					if (selRow != -1) {
						mydata.remove(selRow);
						Manupulations.writeToFile(mydata);
						dmodel.removeRow(selRow);
						saveToFile();
						status.setText("Record Modified Successfully ");
						refreshdata();
					}
				}
			}
		}

		);

		Update.setFont(new Font("Tahoma", Font.BOLD, 12));
		Update.setBounds(435, 345, 89, 33);
		contentPane.add(Update);

		final JButton Delete = new JButton("DELETE");
		Delete.setBackground(new Color(230, 230, 250));
		Delete.setForeground(new Color(0, 0, 205));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				// Code for preventing empty data records being entered 
				if ((fname1.getText().equalsIgnoreCase(""))
						&& (lname1.getText().equalsIgnoreCase(""))
						&& (add1.getText().equalsIgnoreCase(""))
						&& (city1.getText().equalsIgnoreCase(""))
						&& (state1.getText().equalsIgnoreCase(""))
						&& (zip1.getText().equalsIgnoreCase(""))
						&& (country1.getText().equalsIgnoreCase(""))
						&& (phone1.getText().equalsIgnoreCase(""))
						&& (email1.getText().equalsIgnoreCase(""))) {
					status.setText("Please Select Row");
				} else {

					int selRow = table.getSelectedRow();

					if (selRow != -1) {
						

						mydata.remove(selRow);

						Manupulations.writeToFile(mydata);
						// Manupulations.removeSelectedRow(f1, m1, l1);
						dmodel.removeRow(selRow);
						// table.setModel(Manupulations.displayDataInTable(mydata));
						status.setText("Record Deleted Successfully ");
					}
					refreshdata();
				}
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		Delete.setBounds(553, 345, 89, 33);
		contentPane.add(Delete);

		JLabel NoteCompulsoryField = new JLabel("Note : * Compulsory Field");
		NoteCompulsoryField.setForeground(new Color(0, 0, 205));
		NoteCompulsoryField.setFont(new Font("Tahoma", Font.BOLD, 11));
		NoteCompulsoryField.setBounds(486, 412, 191, 14);
		contentPane.add(NoteCompulsoryField);

		JLabel studentlist = new JLabel("STUDENT LIST");
		studentlist.setForeground(new Color(0, 0, 205));
		studentlist.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentlist.setBounds(408, 49, 133, 14);
		contentPane.add(studentlist);

		// dmodel = new DefaultTableModel();

		dmodel = new DefaultTableModel() {
			/**
             * 
             */
			private static final long serialVersionUID = -3140186159369930753L;
           // Code for making table cells non-editable
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};

		dmodel.addColumn("First Name");
		dmodel.addColumn("Middle Name");
		dmodel.addColumn("Last Name");
		dmodel.addColumn("Phone No");

		// Code for displaying initial data
		BufferedReader br1 = null;
		try {
			br1 = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("Textfile.txt"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String line;
		int count = 0;
		String lines[] = new String[100];
		// System.out.println("Row"+row);
		while (((lines[count] = br1.readLine()) != null)) {
			String line = lines[count];
			String[] splitArray = line.split("\t");
			if (splitArray.length == 11) {
				// String[] splitArray = new String[11];
				String[] tableData = new String[4];
				tableData[0] = splitArray[0];
				tableData[1] = splitArray[1];
				tableData[2] = splitArray[2];
				tableData[3] = splitArray[8];
				dmodel.addRow(tableData);
			}
		}

		// Code for Default table
		table = new JTable();
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setBounds(296, 35, 360, 100);
		table.setModel(dmodel);
		// table.setValueAt("",0,0);
		table.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(table);
		table.setVisible(true);

		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						try {
							// System.out.println("event:"+arg0.toString()+";"+arg0.getValueIsAdjusting()+";"+arg0.getSource());
							// int row = table.getSelectedRow();

							// String firstName = (String)table.getValueAt(1,
							// 1);
							// String lastName = (String) table.getValueAt(1,
							// 2);
							// int selRow=0;
							if (arg0.getValueIsAdjusting()) {
								Manupulations.UpdateSelected(fname1, mname,
										lname1, add1, add2, city1, state1,
										phone1, zip1, country1, email1,
										table.getSelectedRow());
							}

							/*
							 * f(selRow!=-1) selRow = table.getSelectedRow();
							 * mydata = new ArrayList<StorageData>(); mydata =
							 * Manupulations.read();
							 */
							// mydata.remove(selRow);
							// JOptionPane.showMessageDialog(null,
							// "Record Deleted Successfully: ");
							// Manupulations.removeSelectedRows(table, dmodel,
							// fname1, mname, lname1, phone1,
							// table.getSelectedRowCount());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

		// Code for adding table under ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);
		scrollPane.setBounds(296, 102, 360, 100);
		scrollPane.setViewportView(table);

		JLabel Mi = new JLabel("M.I ");
		Mi.setForeground(new Color(0, 0, 205));
		Mi.setFont(new Font("Tahoma", Font.BOLD, 12));
		Mi.setBounds(341, 12, 46, 14);
		contentPane.add(Mi);

		mname = new JTextField(1);
		mname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isMnameValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isMnameValid = false;
				}
				if (!isMnameValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}	
				
				
				
				
			}
		});
		mname.setBounds(376, 9, 35, 20);
		contentPane.add(mname);
		mname.setColumns(10);
		mname.setDocument(new TextLimit(1));

		emailval = new JLabel("");
		emailval.setForeground(Color.RED);
		emailval.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailval.setBounds(312, 400, 164, 14);
		contentPane.add(emailval);

		phoneval = new JLabel("");
		phoneval.setForeground(Color.RED);
		phoneval.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneval.setBounds(312, 306, 212, 14);
		contentPane.add(phoneval);

		zipval = new JLabel("");
		zipval.setFont(new Font("Tahoma", Font.BOLD, 11));
		zipval.setForeground(Color.RED);
		zipval.setBounds(312, 265, 212, 14);
		contentPane.add(zipval);

		status = new JLabel("");
		status.setForeground(Color.RED);
		status.setFont(new Font("Tahoma", Font.BOLD, 12));
		status.setBounds(408, 229, 234, 20);
		contentPane.add(status);
		scrollPane.repaint();
		// contentPane.add(new JScrollPane(table));

	}

	// Code for adding data to file

	protected void saveToFile() {
		 // Code for preventing empty data records being entered
		if (!(fname1.getText().equalsIgnoreCase(""))
				&& !(lname1.getText().equalsIgnoreCase(""))
				&& !(add1.getText().equalsIgnoreCase(""))
				&& !(city1.getText().equalsIgnoreCase(""))
				&& !(state1.getText().equalsIgnoreCase(""))
				&& !(zip1.getText().equalsIgnoreCase(""))
				&& !(country1.getText().equalsIgnoreCase(""))
				&& !(phone1.getText().equalsIgnoreCase(""))
				&& !(email1.getText().equalsIgnoreCase(""))) {

			// Validating email-address and duplicate enteries being entered

			boolean isEmailValid = Validation.isValidEmailAddress(email1
					.getText());
			if (isEmailValid) {
				emailval.setText("");
			} else {
				emailval.setText("Please Enter Valid Email ");
				return;
			}
			data();

			boolean isDuplicate = Manupulations.duplicateCheck(d);
			if (isDuplicate == true) {
				status.setText("Record Already Exists");
			} else {
				try {

					// Code for getting input from user in textfields
					BufferedWriter reader = new BufferedWriter(new FileWriter(
							"Textfile.txt", true));

					reader.write(fname1.getText());
					reader.write("\t");
					reader.write(mname.getText());
					reader.write("\t");
					reader.write(lname1.getText());
					reader.write("\t");
					reader.write(add1.getText());
					reader.write("\t");
					reader.write(add2.getText());
					reader.write("\t");
					reader.write(city1.getText());
					reader.write("\t");
					reader.write(zip1.getText());
					reader.write("\t");
					reader.write(state1.getText());
					reader.write("\t");
					reader.write(phone1.getText());
					reader.write("\t");
					reader.write(country1.getText());
					reader.write("\t");
					reader.write(email1.getText());
					reader.write("\t");
					reader.newLine();
					reader.close();

					Manupulations.addRowToTable(table, dmodel, fname1, mname,
							lname1, phone1);
					StorageData sd = new StorageData();
					sd.setFname1(fname1.getText());
					sd.setMname(mname.getText());
					sd.setFname1(lname1.getText());
					sd.setAdd1(add1.getText());
					sd.setAdd2(add2.getText());
					sd.setCity1(city1.getText());
					sd.setZip1(zip1.getText());
					sd.setState1(state1.getText());
					sd.setPhone1(phone1.getText());
					sd.setCountry1(country1.getText());
					sd.setEmail1(email1.getText());
					mydata.add(sd);
					refreshdata();

				}

				catch (IOException ex) {
					System.out.println("File not found: ");

				}
			}

		} else {
			status.setText("* Fields are Compulsory");
		}

	}

	// Code for storing all fields data records

	public static void data() {

		d.setFname1(fname1.getText());
		d.setMname(mname.getText());
		d.setLname1(lname1.getText());
		d.setAdd1(add1.getText());
		d.setAdd2(add2.getText());
		d.setCity1(city1.getText());
		d.setZip1(zip1.getText());
		d.setState1(state1.getText());
		d.setPhone1(phone1.getText());
		d.setCountry1(country1.getText());
		d.setEmail1(email1.getText());

	}

	// Code for clearing up all the data after each add, update and delete
	public void refreshdata() {
		fname1.setText("");
		mname.setText("");
		lname1.setText("");
		add1.setText("");
		add2.setText("");
		city1.setText("");
		state1.setText("");
		zip1.setText("");
		phone1.setText("");
		country1.setText("");
		email1.setText("");

	}
}
