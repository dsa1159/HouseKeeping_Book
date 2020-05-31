import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class SerchDialog extends JDialog {
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("검색할 이름또는 날짜 입력");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel datePanel = new JPanel(new FlowLayout());
			JLabel dateLabel = new JLabel("날짜     : ");
			JTextField dateText = new JTextField(10);
		JPanel namePanel = new JPanel(new FlowLayout());
			JLabel nameLabel = new JLabel("이름     : ");
			JTextField nameText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("검색");
			JButton btn2 = new JButton("취소");
		
	
	public SerchDialog(JFrame frame, String title, JTextArea ta) {
		
		super(frame, title);
		setLayout(new BorderLayout());
		
		upNorth.add(upTitle);
		
		datePanel.add(dateLabel);
		datePanel.add(dateText);
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		button.add(btn1);
		button.add(btn2);		
		
		upCenter.add(namePanel);
		upCenter.add(datePanel);			
		
		add(upNorth, "North");
		add(upCenter, "Center");
		add(button, "South");
		
		setSize(200,200);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");				
				
				ArrayList<setData> arr = new ArrayList<setData>();
				String name = nameText.getText();
				String usedate = dateText.getText();
				
				arr = dao.serchData(name, usedate);
				
				ta.append("|  name"+"\t"+"|  price"+"\t"+"|  usedate"+"\t"+"|  notes \t|"+"\n");
				ta.append("------------------------------------------------------------------------\n");
							
				// 전체 출력
				for (int i = 0; i < arr.size(); i++) {
					ta.append(arr.get(i).getname() +" \t "+ arr.get(i).getPrice() + "\t" +arr.get(i).getUsedate() + "\t"+arr.get(i).getNotes() + "\n");		
					
				setVisible(false);
			}
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