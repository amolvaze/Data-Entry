/* Program for Data entry by asv130130 (Name:- AMOL VAZE )*/
// Code for class that includes various methods that are needed by main GUI class
//just putting this comment for git demo
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Manupulations {

	// Code for writing data to a text file
	public static void writeToFile(ArrayList<StorageData> list) {

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"Textfile.txt"));
			for (Iterator<StorageData> iterator = list.iterator(); iterator
					.hasNext();) {

				StorageData sd = (StorageData) iterator.next();
				String temp = sd.getFname1() + "\t" + sd.getMname() + "\t"
						+ sd.getLname1() + "\t" + sd.getAdd1() + "\t"
						+ sd.getAdd2() + "\t" + sd.getCity1() + "\t"
						+ sd.getZip1() + "\t" + sd.getState1() + "\t"
						+ sd.getPhone1() + "\t" + sd.getCountry1() + "\t"
						+ sd.getEmail1();
				writer.write(temp);
				writer.newLine();

			}
			writer.close();
		} catch (Exception ex) {
			System.out.println("File not found: ");
		}
	}

	// Code for updating table records
	public static void addRowToTable(JTable table, DefaultTableModel dmodel,
			JTextField fname1, JTextField mname, JTextField lname1,
			JTextField phone1) throws IOException {
		String[] rowData = new String[4];
		rowData[0] = fname1.getText();
		rowData[1] = mname.getText();
		rowData[2] = lname1.getText();
		rowData[3] = phone1.getText();
		dmodel.addRow(rowData);
		dmodel.fireTableRowsInserted(0, dmodel.getRowCount());

	}

	// Code for displaying selected row in Jtable

	public static void UpdateSelected(JTextField fname1, JTextField mname,
			JTextField lname1, JTextField add1, JTextField add2,
			JTextField city1, JTextField state1, JTextField phone1,
			JTextField zip1, JTextField country1, JTextField email1, int row)
			throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("Textfile.txt"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line;
		int count = 0;
		String lines[] = new String[100];
		// System.out.println("Row"+row);
		while (((lines[count++] = br.readLine()) != null)) {
			// System.out.println(count);

		}
		// System.out.println("row:"+row+" size of array:"+lines.length);
		line = lines[row];
		br.close();
		String da[] = line.split("\t");
		if (da.length == 11)
			fname1.setText(da[0]);
		mname.setText(da[1]);
		lname1.setText(da[2]);
		add1.setText(da[3]);
		add2.setText(da[4]);
		city1.setText(da[5]);
		zip1.setText(da[6]);
		state1.setText(da[7]);
		phone1.setText(da[8]);
		country1.setText(da[9]);
		email1.setText(da[10]);
	}

	// Code for reading a data and storing into ArrayList

	public static ArrayList<StorageData> read() {

		ArrayList<StorageData> myArray = new ArrayList<StorageData>();

		BufferedReader br = null;
		StorageData d;
		try

		{
			String x;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("Textfile.txt"))));
			while ((x = br.readLine()) != null) {

				d = new StorageData();
				String a[] = x.split("\t");
				if (a.length == 11) {
					d.setFname1(a[0]);
					d.setMname(a[1]);
					d.setLname1(a[2]);
					d.setAdd1(a[3]);
					d.setAdd2(a[4]);
					d.setCity1(a[5]);
					d.setState1(a[6]);
					d.setZip1(a[7]);
					d.setPhone1(a[8]);
					d.setCountry1(a[9]);
					d.setEmail1(a[10]);

					myArray.add(d);
				}

			}
			br.close();

		} catch (IOException e) {
			System.out.print("");
		}
		return myArray;

	}

	// Code for checking duplicate entry in GUI

	public static boolean duplicateCheck(StorageData str) {

		ArrayList<StorageData> b = read();
		for (StorageData current : b) {
			if (current.getFname1().equalsIgnoreCase(str.getFname1())
					&& current.getLname1().equals(str.getLname1())
					&& current.getMname().equals(str.getMname()))
				return true;
		}
		return false;
	}

	

}
