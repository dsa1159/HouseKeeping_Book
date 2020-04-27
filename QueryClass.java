import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

public class QueryClass {

	private Connection conn;

	public QueryClass(Connection conn) {
		this.conn = conn;
	}

	// �������� �Է� �޼ҵ�

	public int insertdata(SaveClass sv) {

		int result = 0;

		Statement stmt = null;

		StringBuffer sb = new StringBuffer();

		sb.append("INSERT INTO TEST(USERID, NAME, PRICE, USEDATE,NOTES)");

		sb.append(" VALUES (SEQ_NUMBER.NEXTVAL, "); // SEQ_NUMBER��� �������� ������ȣ�� �Է¹��̴�.
		//sb.append(" VALUES (" + sv.getUserid() + "',");
		sb.append("'" + sv.getname() + "',");
		sb.append("'" + sv.getPrice() + "',");
		sb.append("'" + sv.getUsedate() + "',");
		sb.append("'" + sv.getNotes() + "')");

		try {

			stmt = conn.createStatement(); // stmt ��ü�� �� ������ �̸� result ���� �Է¹޾� ����

			result = stmt.executeUpdate(sb.toString());

			stmt.close();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return result;

	}

	// �������� ��� �޼ҵ�

	public List<SaveClass> listdata() {

		List<SaveClass> lists = new ArrayList<SaveClass>();

		Statement stmt = null;

		ResultSet rs = null;

		String sql;

		sql = "SELECT USERID, NAME, PRICE, USEDATE, NOTES";

		sql += " FROM TEST";

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql); // ����� ��� ���� �ִ� ��ü rs

			while (rs.next()) {

				SaveClass sv = new SaveClass(); // ���� ���⼭ ��ü����

				sv.setUserid(rs.getString("USERID"));

				sv.setname(rs.getString("NAME"));

				sv.setPrice(rs.getString("PRICE"));
				
				sv.setUsedate(rs.getString("USEDATE"));
				
				sv.setNotes(rs.getString("NOTES"));

				lists.add(sv);

			}

			rs.close();

			stmt.close();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return lists;

	}

	// �������� ���� �޼ҵ�

	public int updatedata(String name, String newcontent) {

		int result = 0;

		Statement stmt = null;

		String sql;

		sql = " UPDATE TEST SET CONTENT = '" + newcontent + "'";

		sql += " WHERE NAME = '" + name + "'";

		try {

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

			stmt.close();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return result;

	}

	// �������� ���� �޼ҵ�

	public int deletedata(String string) {

		int result = 0;

		Statement stmt = null;

		String sql;

		sql = "DELETE FROM TEST";

		sql += " WHERE NAME = '" + string + "'";

		try {

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

			stmt.close();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return result;

	}

}