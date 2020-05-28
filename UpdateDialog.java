import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class UpdateDialog extends JDialog {
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("수정할 이름과 금액 입력");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel pricePanel = new JPanel(new FlowLayout());
			JLabel priceLabel = new JLabel("금액     : ");
			JTextField priceText = new JTextField(10);
		JPanel namePanel = new JPanel(new FlowLayout());
			JLabel nameLabel = new JLabel("이름     : ");
			JTextField nameText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("수정");
			JButton btn2 = new JButton("취소");
		
	
	public UpdateDialog(JFrame frame, String title, JTextArea ta) {
		
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
		upCenter.add(pricePanel);			
		
		add(upNorth, "North");
		add(upCenter, "Center");
		add(button, "South");
		
		setSize(500,400);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText(""); 
				
				String name = nameText.getText();
				int price= Integer.parseInt(priceText.getText());
				dao.updateData(name, price);
				ta.append("수정 완료 \n");
				
				nameText.setText(""); priceText.setText("");
				
				setVisible(false);
			}
			}
		);
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				setVisible(false);
			}
		});		
	}
}