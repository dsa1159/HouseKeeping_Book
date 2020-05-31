import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class UpdateDialog extends JDialog {
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("수정할 일련번호와 금액 입력");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel pricePanel = new JPanel(new FlowLayout());
			JLabel priceLabel = new JLabel("    금액        : ");
			JTextField priceText = new JTextField(10);
		JPanel sequencePanel = new JPanel(new FlowLayout());
			JLabel sequenceLabel = new JLabel("일련번호     : ");
			JTextField sequenceText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("수정");
			JButton btn2 = new JButton("취소");
		
	
	public UpdateDialog(JFrame frame, String title, JTextArea ta) {
		
		super(frame, title);
		setLayout(new BorderLayout());
		
		upNorth.add(upTitle);
		
		pricePanel.add(priceLabel);
		pricePanel.add(priceText);
		sequencePanel.add(sequenceLabel);
		sequencePanel.add(sequenceText);
		
		button.add(btn1);
		button.add(btn2);		
		
		upCenter.add(sequencePanel);
		upCenter.add(pricePanel);			
		
		add(upNorth, "North");
		add(upCenter, "Center");
		add(button, "South");
		
		setSize(200,200);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText(""); 
				
				String sequence = sequenceText.getText();
				int price= Integer.parseInt(priceText.getText());
				dao.updateData(sequence, price);
				ta.append("수정 완료 \n");
				
				sequenceText.setText(""); priceText.setText("");
				
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