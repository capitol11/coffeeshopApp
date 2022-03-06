package swing;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestUI extends JFrame {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> coffees = new ArrayList<String>();
	private JList list;
	private double totalPrice;
	private ArrayList<String> orderedMenu = new ArrayList<String>();
	private String selectedItem;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI frame = new TestUI();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public TestUI() throws IOException { 
		fileread();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 208, 164, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 62, 201, 88);
		contentPane.add(scrollPane); 
		
		list = new JList(coffees.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedItem = (String) list.getSelectedValue();
				textField.setText(selectedItem);
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Willkommen bei Java Bar");
		lblNewLabel.setBounds(25, 31, 219, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Bestellen");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(selectedItem + " got ordered.");
				orderedMenu.add(selectedItem);
				
			}
		});
		btnNewButton.setBounds(199, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Gesamtbeleg: ");
		lblNewLabel_1.setBounds(25, 182, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(102, 182, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
	
	
	// extract only numbers from a text.
	public String readOnlyNumbers(String str) {
		String only_nr = str.replaceAll("[0-9]", "");
		System.out.println(only_nr);
		return only_nr;
	}
	
	// extract only char from 
	public String readOnlyStr(String str) {
		String only_str = str.replaceAll("[^0-9]", "");
		System.out.println(only_str);
		return only_str;
	}
	
	public void fileread() throws IOException {
		File file = new File("C:/Users/Soohyun/Desktop/coffee_menu.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			while((str = br.readLine())!=null) {
				coffees.add(str); // add elements in the list.
				System.out.println(str); 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
