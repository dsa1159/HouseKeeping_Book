import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Iterator;

import java.util.List;

public class WriteStart {

// insert �޼ҵ�

	public void insert() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		setData sv = new setData();

		try {

			System.out.println("�̸��� �Է��ϼ���");

			sv.setname(br.readLine());

			System.out.println("����� �ݾ� �� �Է��ϼ���");

			sv.setPrice(br.readLine());
			
			System.out.println("��볯¥ �� �Է��ϼ���");

			sv.setUsedate(br.readLine());
			
			System.out.println("���ó �� �Է��ϼ���");

			sv.setNotes(br.readLine());

			QueryClass callQuery = new QueryClass(DBconn.getConnection());

			int result = callQuery.insertdata(sv);

			if (result != 0)

				System.out.println("���������� �ԷµǾ����ϴ�.\n");

			else

				System.out.println("�Է¿� �����Ͽ����ϴ�.\n");

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

// select �޼ҵ�

	public void select() {

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		List<setData> lists = callQuery.listdata();

		Iterator<setData> it = lists.iterator();

		String str;

		while (it.hasNext()) {

			setData sv = it.next();

			str = String.format("%s %s %s %s %s", sv.getSequence(), sv.getname(), sv.getPrice(), sv.getUsedate(), sv.getNotes());

			System.out.println(str);

		}

	}

// update �޼ҵ�

	public void update() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		try {

			System.out.println("������ ������ �Է��ϼ���");

			String sequence = br.readLine();

			System.out.println("������ �ݾ��� �Է��ϼ���");

			String price = br.readLine();
			
			/*System.out.println("������ ��� �Է��ϼ���");

			String notes = br.readLine();*/

			int result = callQuery.updatedata(sequence, price);

			if (result != 0)

				System.out.println("���������� �����Ǿ����ϴ�.\n");

			else

				System.out.println("������ �����Ͽ����ϴ�.\n");

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

// delete �޼ҵ�

	public void delete() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		try {

			System.out.println("������ ������ �Է��ϼ���");

			String sequence = br.readLine();

			int result = callQuery.deletedata(sequence);

			if (result == 0)

				System.out.println("��ϵ� �ڷᰡ �����ϴ�.\n");

			else

				System.out.println("������ ���� �Ͽ����ϴ�.\n");

		} catch (Exception e) {

		}

	}

}