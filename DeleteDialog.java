import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteDialog extends JDialog {
	
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("삭제할 일련번호 입력");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel sequencePanel = new JPanel(new FlowLayout());
			JLabel sequenceLabel = new JLabel("일련번호     : ");
			JTextField sequenceText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("삭제");
			JButton btn2 = new JButton("취소");
		
	
	public DeleteDialog(JFrame frame, String title, JTextArea ta) {
		
		super(frame, title);
		setLayout(new BorderLayout());
		
		upNorth.add(upTitle);
		
		
		sequencePanel.add(sequenceLabel);
		sequencePanel.add(sequenceText);
		
		button.add(btn1);
		button.add(btn2);		
		
		upCenter.add(sequencePanel);
				
		
		add(upNorth, "North");
		add(upCenter, "Center");
		add(button, "South");
		
		setSize(200,150);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				String sequence = sequenceText.getText();
				dao.deleteData(sequence);
				
				ta.append("삭제 완료 \n");
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