import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class InsertDialog extends JDialog {
	
	JRadioButton radio1 = new JRadioButton("����");
	JRadioButton radio2 = new JRadioButton("����");
	
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("����� ���� �Է�");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));
		JPanel datePanel = new JPanel(new FlowLayout());
			JLabel dateLabel = new JLabel("��¥     : ");
			JTextField dateText = new JTextField(10);
			JLabel dateEx = new JLabel("ex ) 20200520");
		JPanel pricePanel = new JPanel(new FlowLayout());
			JLabel priceLabel = new JLabel("�ݾ�     : ");
			JTextField priceText = new JTextField(10);
		JPanel namePanel = new JPanel(new FlowLayout());
			JLabel nameLabel = new JLabel("�̸�     : ");
			JTextField nameText = new JTextField(10);
		JPanel notePanel = new JPanel(new FlowLayout());
			JLabel noteLabel = new JLabel("���ó : ");
			JTextField noteText = new JTextField(10);
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("���");
			JButton btn2 = new JButton("���");
		JPanel check = new JPanel(new FlowLayout());
	
	
	public InsertDialog(JFrame frame, String title, JTextArea ta) {
		
		super(frame, title);
		setLayout(new BorderLayout());
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(radio1);
		group.add(radio2);
		
		upNorth.add(upTitle);
		datePanel.add(dateLabel);
		datePanel.add(dateText);
		datePanel.add(dateEx);
		pricePanel.add(priceLabel);
		pricePanel.add(priceText);
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		notePanel.add(noteLabel);
		notePanel.add(noteText);
		button.add(btn1);
		button.add(btn2);
		check.add(radio1);
		check.add(radio2);
		
		upCenter.add(datePanel);
		upCenter.add(pricePanel);
		upCenter.add(namePanel);
		upCenter.add(notePanel);
		upCenter.add(button);
		upCenter.add(check);
		
		add(upNorth, "North");
		add(upCenter, "Center");
		
		setSize(600,300);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				
				String name = nameText.getText();
				int price =Integer.parseInt(priceText.getText());
				int usedate = Integer.parseInt(dateText.getText());
				String notes = noteText.getText();
				
				dao.insertData(new setData(name, price, usedate, notes));
				
				ta.append("�Է� �Ϸ� \n");				
				
				nameText.setText(""); priceText.setText("");dateText.setText(""); noteText.setText("");
				
				setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				setVisible(false);
			}
		});		
	}
}
