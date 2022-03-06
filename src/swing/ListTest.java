package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame implements ListSelectionListener{

	//FIELDS
	private JLabel label = new JLabel();
	private JTextField selectedList = new JTextField(10); //10���ڱ��� ����
	private JPanel listPanel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private JList list;
	private JScrollPane scroll;
	private String[] names = {"��ö��", "�迵��", "�����", "���ڸ�"};

	//CONSTRUCTOR
	public ListTest() {
		setTitle("����Ʈ ����");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�������� ���� �� ������ ����
		
		list = new JList(names);

		//����Ʈ�� ��輱 ����
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		//����Ʈ�� ��ũ�ѹ� �߰�
		scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(300, 300));

		//����Ʈ�� ���� ���� ��� ����
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//����Ʈ ���� ������ ���
		list.addListSelectionListener(this);

		label.setText("���õ� �׸� : ");
		selectedList.setEditable(false); //�ؽ�Ʈ �ʵ� ���� �Ұ����·� �ٲٱ�

		listPanel.add(scroll); //����Ʈ�� �гο� �߰�
		labelPanel.add(label); //���� �гο� �߰�
		labelPanel.add(selectedList); //�ؽ�Ʈ �ʵ带 �гο� �߰�

		add(listPanel, BorderLayout.CENTER); //������ �߾ӿ� ����Ʈ�� ��ġ
		add(labelPanel, BorderLayout.SOUTH); //������ �ϴܿ� �󺧰� �ؽ�Ʈ �ʵ� ��ġ

		setVisible(true);
	}

	//METHODS
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// ���õ� �̸� ���
		String name = (String) list.getSelectedValue();

		selectedList.setText(name);
		System.out.println(name);

	}

	public static void main(String[] args) {
		ListTest listFrame = new ListTest();
	}
}

