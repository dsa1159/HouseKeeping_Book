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

		JButton prevBtn = new JButton("◀");

		JButton nextBtn = new JButton("▶");

				

		JLabel yearLbl = new JLabel("년");

		JLabel monthLbl = new JLabel("월");

				

		JComboBox<Integer> yearCombo = new JComboBox<Integer>();

			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

		JComboBox<Integer> monthCombo = new JComboBox<Integer>();

		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	

	//Center

		JPanel centerPane = new JPanel(new BorderLayout());

			JPanel titlePane = new JPanel(new GridLayout(1, 7));

				String titleStr[] = {"일", "월", "화", "수", "목", "금", "토"};

			JPanel datePane = new JPanel(new GridLayout(0, 7));
// right 
			JPanel right = new JPanel(new BorderLayout());
			JPanel rightUp = new JPanel(new BorderLayout());
				JPanel upNorth = new JPanel(new FlowLayout());
					JLabel upTitle = new JLabel("가계부 내용 입력");
						
				JPanel upCenter = new JPanel(new  GridLayout(0,1));
					JPanel datePanel = new JPanel(new FlowLayout());
					JLabel dateLabel = new JLabel("날짜     : ");
					JTextField dateText = new JTextField("ex ) 20200520",10);
					//JLabel dateEx = new JLabel("ex ) 20200520");
					JPanel pricePanel = new JPanel(new FlowLayout());
					JLabel priceLabel = new JLabel("금액     : ");
					JTextField priceText = new JTextField(10);
					JPanel namePanel = new JPanel(new FlowLayout());
					JLabel nameLabel = new JLabel("이름     : ");
					JTextField nameText = new JTextField(10);
					JPanel notePanel = new JPanel(new FlowLayout());
					JLabel noteLabel = new JLabel("사용처 : ");
					JTextField noteText = new JTextField(10);
					JPanel button = new JPanel(new FlowLayout());
						JButton btn1 = new JButton("입력");
						JButton btn2 = new JButton("불러오기");
						JButton btn3 = new JButton("수정");
						JButton btn4 = new JButton("삭제");
						JButton btn5 = new JButton("검색");
					
			JPanel rightDown = new JPanel(new BorderLayout());				
				JPanel downNorth = new JPanel(new FlowLayout());
					JLabel downTitle = new JLabel("가계부 내역");
					
					
				JPanel downCenter = new JPanel(new BorderLayout());
					JTextArea ta = new JTextArea();
					JScrollPane jsp = new JScrollPane(ta);
					
					
								

	Calendar now;

	int year, month, date;

	

	public SwingCalendar() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	//자원 해제 후 종료
		setLayout(new GridLayout(1,2));
		
		now = Calendar.getInstance();	//현재 날짜

		year = now.get(Calendar.YEAR);

		month = now.get(Calendar.MONTH)+1;

		date = now.get(Calendar.DATE);

		

		topPane.add(prevBtn);

		

		for(int i=year-100; i<=year+50; i++){

			yearModel.addElement(i);

		}

		yearCombo.setModel(yearModel);

		yearCombo.setSelectedItem(year);	//현재 년도 선택

		topPane.add(yearCombo);

		

		topPane.add(yearLbl);

		

		for(int i=1; i<=12; i++){

			monthModel.addElement(i);

		}

		monthCombo.setModel(monthModel);

		monthCombo.setSelectedItem(month);	//현재 월 선택

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

		//날짜 출력

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
		
		InsertDialog dialog1 = new InsertDialog(this, "등록", ta);
		DeleteDialog dialog2 = new DeleteDialog(this, "삭제", ta);
		UpdateDialog dialog3 = new UpdateDialog(this, "수정", ta);
		SerchDialog dialog4 = new SerchDialog(this, "검색", ta);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				dialog1.setVisible(true);				
			}
		});

		// 출력 버튼 이벤트
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				ArrayList<setData> arr = new ArrayList<setData>();
				arr = dao.readData();
				
				ta.append("|  날짜"+"\t"+"|  금액"+"\t"+"|  이름"+"\t"+"|  비고 \t"+"| 일련번호\t\n");
				ta.append("------------------------------------------------------------------------------------------------\n");
				
				// 전체 출력
				for (int i = 0; i < arr.size(); i++) {
					ta.append(arr.get(i).getUsedate() +" \t "+ arr.get(i).getPrice() + "\t" +arr.get(i).getname() + "\t"+arr.get(i).getNotes() + "\t"+arr.get(i).getSequence()+"\n");
				}
			}
		});

		// 수정 버튼 이벤트
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog3.setVisible(true);	
			}
		});

		// 삭제 버튼 이벤트
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				dialog2.setVisible(true);				
			}
		});

		// 검색 버튼 이벤트
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

			if(eventBtn.equals(prevBtn)){	//전달

				if(mm==1){

					yy--; mm=12;

				}else{

					mm--;

				}				

			}else if(eventBtn.equals(nextBtn)){	//다음달

				if(mm==12){

					yy++; mm=1;

				}else{

					mm++;

				}

			}

			yearCombo.setSelectedItem(yy);

			monthCombo.setSelectedItem(mm);

		}else if(obj instanceof JComboBox){	//콤보박스 이벤트 발생시

			createDayStart();

		}

	}

	public void createDayStart(){

		datePane.setVisible(false);	//패널 숨기기

		datePane.removeAll();	//날짜 출력한 라벨 지우기

		dayPrint((Integer)yearCombo.getSelectedItem(), (Integer)monthCombo.getSelectedItem());

		datePane.setVisible(true);	//패널 재출력				

	}

	

	public void dayPrint(int y, int m){

		Calendar cal = Calendar.getInstance();		
		
		int today = cal.get(Calendar.DATE);
		
		cal.set(y, m-1, 1);	//출력할 첫날의 객체 만든다.\

		int week = cal.get(Calendar.DAY_OF_WEEK);	//1일에 대한 요일	일요일 : 0

		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	//그 달의 마지막 날

		for(int i=1; i<week; i++){	//날짜 출력 전까지의 공백 출력

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