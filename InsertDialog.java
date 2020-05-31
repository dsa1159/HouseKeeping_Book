import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class InsertDialog extends JDialog implements ItemListener{
	
	JRadioButton radio1 = new JRadioButton("수입");
	JRadioButton radio2 = new JRadioButton("지출");
	boolean money = true;
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("가계부 내용 입력");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));
		JPanel datePanel = new JPanel(new FlowLayout());
			JLabel dateLabel = new JLabel("날짜     : ");
			JTextField dateText = new JTextField("ex ) 20200520",10);
		JPanel pricePanel = new JPanel(new FlowLayout());
			JLabel priceLabel = new JLabel("금액     : ");
			JTextField priceText = new JTextField(10);
		JPanel namePanel = new JPanel(new FlowLayout());
			JLabel nameLabel = new JLabel("이름     : ");
			JTextField nameText = new JTextField(10);
		JPanel notePanel = new JPanel(new FlowLayout());
			JLabel noteLabel = new JLabel("비고     : ");
			JTextField noteText = new JTextField(10);
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("등록");
			JButton btn2 = new JButton("취소");
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
		
		upCenter.add(check);
		upCenter.add(datePanel);
		upCenter.add(pricePanel);
		upCenter.add(namePanel);
		upCenter.add(notePanel);
		upCenter.add(button);
		
		
		add(upNorth, "North");
		add(upCenter, "Center");
		
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		
		setSize(200,300);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				
				int price = 0;
				String name = nameText.getText();
				String sequence = "user_id.NEXTVAL";
				
				int usedate = Integer.parseInt(dateText.getText());
				String notes = noteText.getText();
				if(money == true)
					price =Integer.parseInt(priceText.getText());
				else if(money == false)
					price =-(Integer.parseInt(priceText.getText()));
				
				dao.insertData(new setData(usedate, price, name, notes, sequence));
				
				ta.append("입력 완료 \n");				
				
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
	public void itemStateChanged(ItemEvent e) {
		if(radio1.isSelected()) {
			money = true;
			System.out.println("money = true");
		}
		else if(radio2.isSelected()) {
			money = false;
			System.out.println("money = false");
	}
}
}
