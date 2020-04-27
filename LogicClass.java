import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Iterator;

import java.util.List;

public class LogicClass {

// insert 메소드

	public void insert() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		SaveClass sv = new SaveClass();

		try {

			System.out.println("이름을 입력하세요");

			sv.setname(br.readLine());

			System.out.println("가격을 입력하세요");

			sv.setPrice(br.readLine());
			
			System.out.println("사용날짜를 입력하세요");

			sv.setUsedate(br.readLine());
			
			System.out.println("비고를 입력하세요");

			sv.setNotes(br.readLine());

			QueryClass callQuery = new QueryClass(DBconn.getConnection());

			int result = callQuery.insertdata(sv);

			if (result != 0)

				System.out.println("성공적으로 입력되었습니다.\n");

			else

				System.out.println("입력에 실패하였습니다.\n");

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

// select 메소드

	public void select() {

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		List<SaveClass> lists = callQuery.listdata();

		Iterator<SaveClass> it = lists.iterator();

		String str;

		while (it.hasNext()) {

			SaveClass sv = it.next();

			str = String.format("%s %s %s %s %s", sv.getUserid(), sv.getname(), sv.getPrice(), sv.getUsedate(), sv.getNotes());

			System.out.println(str);

		}

	}

// update 메소드

	public void update() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		try {

			System.out.println("수정할 이름을 입력하세요");

			String name = br.readLine();

			System.out.println("수정할 가격을 입력하세요");

			String price = br.readLine();
			
			/*System.out.println("수정할 비고를 입력하세요");

			String notes = br.readLine();*/

			int result = callQuery.updatedata(name, price);

			if (result != 0)

				System.out.println("성공적으로 수정되었습니다.\n");

			else

				System.out.println("수정에 실패하였습니다.\n");

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

// delete 메소드

	public void delete() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		QueryClass callQuery = new QueryClass(DBconn.getConnection());

		try {

			System.out.println("삭제할 제목을입력하세요");

			String subject = br.readLine();

			int result = callQuery.deletedata(subject);

			if (result == 0)

				System.out.println("등록된 자료가 없습니다.\n");

			else

				System.out.println("삭제가 성공 하였습니다.\n");

		} catch (Exception e) {

		}

	}

}