import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteDialog extends JDialog {
	
	
	JPanel upNorth = new JPanel(new FlowLayout());
		JLabel upTitle = new JLabel("������ �Ϸù�ȣ �Է�");
				
	JPanel upCenter = new JPanel(new  GridLayout(0,1));		
		JPanel sequencePanel = new JPanel(new FlowLayout());
			JLabel sequenceLabel = new JLabel("�Ϸù�ȣ     : ");
			JTextField sequenceText = new JTextField(10);
	
		JPanel button = new JPanel(new FlowLayout());
			JButton btn1 = new JButton("����");
			JButton btn2 = new JButton("���");
		
	
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