import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteDialog extends JDialog {
	
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("������ �̸� �Է�");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel pricePanel = new JPanel(new FlowLayout());
			JLabel priceLabel = new JLabel("�ݾ�     : ");
			JTextField priceText = new JTextField(10);
		JPanel namePanel = new JPanel(new FlowLayout());
			JLabel nameLabel = new JLabel("�̸�     : ");
			JTextField nameText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("����");
			JButton btn2 = new JButton("���");
		
	
	public DeleteDialog(JFrame frame, String title, JTextArea ta) {
		
		super(frame, title);
		setLayout(new BorderLayout());
		
		upNorth.add(upTitle);
		
		pricePanel.add(priceLabel);
		pricePanel.add(priceText);
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		button.add(btn1);
		button.add(btn2);		
		
		upCenter.add(namePanel);
		//upCenter.add(pricePanel);			
		
		add(upNorth, "North");
		add(upCenter, "Center");
		add(button, "South");
		
		setSize(200,300);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				String name = nameText.getText();
				dao.deleteData(name);
				
				ta.append("���� �Ϸ� \n");
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