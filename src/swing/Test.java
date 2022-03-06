package swing;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Test extends JFrame {

	private JPanel contentPane;
	private String[] testNames = {"수현", "모나", "엄마", "이모"};
	private ArrayList<String> orderedItemList = new ArrayList<String>();
	JScrollPane scrollPane_2;
	private String selectedItemName;
	
	private JList list;
	private JList orderItemList;
	private JTextField txtOrderItem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 64, 175, 108);
		contentPane.add(scrollPane);
		
		list = new JList(testNames);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedItemName = (String) list.getSelectedValue();
				txtOrderItem.setText(selectedItemName);
				
				// show orderItemList on the shopping list
				orderItemList = new JList(orderedItemList.toArray()); // only array is allowed. 
				scrollPane_2.setViewportView(orderItemList);
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("\uC8FC\uBB38");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderedItemList.add(selectedItemName); 
				System.out.print(orderedItemList);
			}
		});
		btnNewButton.setBounds(20, 220, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel titleLabel = new JLabel("\uB3C4\uB77C\uC5D0\uBABD \uBC14\uC5D0 \uC624\uC2E0 \uAC83\uC744 \uD658\uC601\uD569\uB2C8\uB2E4.");
		titleLabel.setBounds(10, 11, 261, 23);
		contentPane.add(titleLabel);
		
		JLabel selectedItem = new JLabel("\uC120\uD0DD\uD55C \uC544\uC774\uD15C:");
		selectedItem.setBounds(20, 186, 261, 23);
		contentPane.add(selectedItem);
		
		txtOrderItem = new JTextField();
		txtOrderItem.setEditable(false);
		txtOrderItem.setBounds(110, 187, 86, 20);
		txtOrderItem.setColumns(10);
	
		contentPane.add(txtOrderItem);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(219, 71, 136, 138);
		contentPane.add(scrollPane_2);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38 \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setBounds(219, 29, 106, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD1D: ");
		lblNewLabel_1.setBounds(219, 224, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uBAA8\uB450 \uCDE8\uC18C");
		btnNewButton_1.setBounds(110, 220, 89, 23);
		contentPane.add(btnNewButton_1);
		

	}	
}
