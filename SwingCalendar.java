import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class SwingCalendar extends JFrame implements ActionListener{
//left
	JPanel left = new JPanel(new BorderLayout());
	
	//North
	JPanel topPane = new JPanel();

		JButton prevBtn = new JButton("��");

		JButton nextBtn = new JButton("��");

				

		JLabel yearLbl = new JLabel("��");

		JLabel monthLbl = new JLabel("��");

				

		JComboBox<Integer> yearCombo = new JComboBox<Integer>();

			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

		JComboBox<Integer> monthCombo = new JComboBox<Integer>();

		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	

	//Center

		JPanel centerPane = new JPanel(new BorderLayout());

			JPanel titlePane = new JPanel(new GridLayout(1, 7));

				String titleStr[] = {"��", "��", "ȭ", "��", "��", "��", "��"};

			JPanel datePane = new JPanel(new GridLayout(0, 7));
// right 
			JPanel right = new JPanel(new BorderLayout());
			JPanel rightUp = new JPanel(new BorderLayout());
				JPanel upNorth = new JPanel(new FlowLayout());
					JLabel upTitle = new JLabel("����� ���� �Է�");
						
				JPanel upCenter = new JPanel(new  GridLayout(0,1));
					JPanel datePanel = new JPanel(new FlowLayout());
					JLabel dateLabel = new JLabel("��¥     : ");
					JTextField dateText = new JTextField("ex ) 20200520",10);
					//JLabel dateEx = new JLabel("ex ) 20200520");
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
						JButton btn1 = new JButton("�Է�");
						JButton btn2 = new JButton("�ҷ�����");
						JButton btn3 = new JButton("����");
						JButton btn4 = new JButton("����");
						JButton btn5 = new JButton("�˻�");
					
			JPanel rightDown = new JPanel(new BorderLayout());				
				JPanel downNorth = new JPanel(new FlowLayout());
					JLabel downTitle = new JLabel("����� ����");
					
					
				JPanel downCenter = new JPanel(new BorderLayout());
					JTextArea ta = new JTextArea();
					JScrollPane jsp = new JScrollPane(ta);
					
					
								

	Calendar now;

	int year, month, date;

	

	public SwingCalendar() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	//�ڿ� ���� �� ����
		setLayout(new GridLayout(1,2));
		
		now = Calendar.getInstance();	//���� ��¥

		year = now.get(Calendar.YEAR);

		month = now.get(Calendar.MONTH)+1;

		date = now.get(Calendar.DATE);

		

		topPane.add(prevBtn);

		

		for(int i=year-100; i<=year+50; i++){

			yearModel.addElement(i);

		}

		yearCombo.setModel(yearModel);

		yearCombo.setSelectedItem(year);	//���� �⵵ ����

		topPane.add(yearCombo);

		

		topPane.add(yearLbl);

		

		for(int i=1; i<=12; i++){

			monthModel.addElement(i);

		}

		monthCombo.setModel(monthModel);

		monthCombo.setSelectedItem(month);	//���� �� ����

		topPane.add(monthCombo);

		

		topPane.add(monthLbl);

		

		topPane.add(nextBtn);

		

		topPane.setBackground(new Color(100, 200, 200));

		left.add(topPane, "North");

		//Center

		titlePane.setBackground(Color.white);

		for(int i=0; i<titleStr.length; i++){

			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);

			if(i == 0){

				lbl.setForeground(Color.red);

			}else if(i == 6){

				lbl.setForeground(Color.blue);

			}

			titlePane.add(lbl);

		}

		centerPane.add(titlePane, "North");

		//��¥ ���

		dayPrint(year, month);

		centerPane.add(datePane, "Center");

		

		left.add(centerPane, "Center");

		datePanel.setBackground(Color.white);
		pricePanel.setBackground(Color.white);
		namePanel.setBackground(Color.white);
		notePanel.setBackground(Color.white);
		button.setBackground(Color.white);		
		upNorth.setBackground(Color.white);
		upCenter.setBackground(Color.white);
		downNorth.setBackground(Color.white);
		rightUp.setBackground(Color.white);
		rightDown.setBackground(Color.white);
		downCenter.setBackground(Color.white);
		
		//right
		datePanel.add(dateLabel);
		datePanel.add(dateText);
		//datePanel.add(dateEx);
		pricePanel.add(priceLabel);
		pricePanel.add(priceText);
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		notePanel.add(noteLabel);
		notePanel.add(noteText);
		button.add(btn1);
		button.add(btn2);
		button.add(btn3);
		button.add(btn4);
		button.add(btn5);
		
		upNorth.add(upTitle);
		
		upCenter.add(datePanel);
		upCenter.add(pricePanel);
		upCenter.add(namePanel);
		upCenter.add(notePanel);
		upCenter.add(button);
		
		downNorth.add(downTitle);
		downCenter.add(jsp);
		
		rightUp.add(upNorth,"North");
		rightUp.add(upCenter);
		rightDown.add(downNorth,"North");
		rightDown.add(downCenter,"Center");
		rightDown.add(button,"South");
		
		
		
		//right.add(rightUp);		
		right.add(rightDown);
		
		add(left);
		add(right);
		
		

		setSize(1200, 500);

		setVisible(true);

		

		prevBtn.addActionListener(this);

		nextBtn.addActionListener(this);

		yearCombo.addActionListener(this);

		monthCombo.addActionListener(this);
		
		QueryClass dao = new QueryClass(DBconn.getConnection());
		
		InsertDialog dialog1 = new InsertDialog(this, "���", ta);
		DeleteDialog dialog2 = new DeleteDialog(this, "����", ta);
		UpdateDialog dialog3 = new UpdateDialog(this, "����", ta);
		SerchDialog dialog4 = new SerchDialog(this, "�˻�", ta);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				dialog1.setVisible(true);				
			}
		});

		// ��� ��ư �̺�Ʈ
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				ArrayList<setData> arr = new ArrayList<setData>();
				arr = dao.readData();
				
				ta.append("|  ��¥"+"\t"+"|  �ݾ�"+"\t"+"|  �̸�"+"\t"+"|  ��� \t"+"| �Ϸù�ȣ\t\n");
				ta.append("------------------------------------------------------------------------------------------------\n");
				
				// ��ü ���
				for (int i = 0; i < arr.size(); i++) {
					ta.append(arr.get(i).getUsedate() +" \t "+ arr.get(i).getPrice() + "\t" +arr.get(i).getname() + "\t"+arr.get(i).getNotes() + "\t"+arr.get(i).getSequence()+"\n");
				}
			}
		});

		// ���� ��ư �̺�Ʈ
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog3.setVisible(true);	
			}
		});

		// ���� ��ư �̺�Ʈ
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				dialog2.setVisible(true);				
			}
		});

		// �˻� ��ư �̺�Ʈ
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog4.setVisible(true);				
			}
		});

	}

	//Overring

	public void actionPerformed(ActionEvent ae){

		Object obj = ae.getSource();

		if(obj instanceof JButton){

			JButton eventBtn = (JButton)obj;

			int yy = (Integer)yearCombo.getSelectedItem();

			int mm = (Integer)monthCombo.getSelectedItem();

			if(eventBtn.equals(prevBtn)){	//����

				if(mm==1){

					yy--; mm=12;

				}else{

					mm--;

				}				

			}else if(eventBtn.equals(nextBtn)){	//������

				if(mm==12){

					yy++; mm=1;

				}else{

					mm++;

				}

			}

			yearCombo.setSelectedItem(yy);

			monthCombo.setSelectedItem(mm);

		}else if(obj instanceof JComboBox){	//�޺��ڽ� �̺�Ʈ �߻���

			createDayStart();

		}

	}

	public void createDayStart(){

		datePane.setVisible(false);	//�г� �����

		datePane.removeAll();	//��¥ ����� �� �����

		dayPrint((Integer)yearCombo.getSelectedItem(), (Integer)monthCombo.getSelectedItem());

		datePane.setVisible(true);	//�г� �����				

	}

	

	public void dayPrint(int y, int m){

		Calendar cal = Calendar.getInstance();		
		
		int today = cal.get(Calendar.DATE);
		
		cal.set(y, m-1, 1);	//����� ù���� ��ü �����.\

		int week = cal.get(Calendar.DAY_OF_WEEK);	//1�Ͽ� ���� ����	�Ͽ��� : 0

		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	//�� ���� ������ ��

		for(int i=1; i<week; i++){	//��¥ ��� �������� ���� ���

			datePane.add(new JLabel(" "));

		}

		for(int i=1; i<=lastDate; i++){

			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);

			cal.set(y, m-1, i);

			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			
			
			if(outWeek==1){

				lbl.setForeground(Color.red);				

			}else if(outWeek==7){

				lbl.setForeground(Color.BLUE);

			}
			
			if(i == today) {
				lbl.setForeground(Color.yellow);
			}


			datePane.add(lbl);

		}
		
	}	

}