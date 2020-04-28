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

	public int insertdata(setData sv) {

		int result = 0;

		Statement stmt = null;

		StringBuffer sb = new StringBuffer();

		sb.append("INSERT INTO TEST(SEQUENCE, NAME, PRICE, USEDATE,NOTES)");

		sb.append(" VALUES (T_NUMBER.NEXTVAL, "); // SEQ_NUMBER��� �������� ������ȣ�� �Է¹��̴�.
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

	public List<setData> listdata() {

		List<setData> lists = new ArrayList<setData>();

		Statement stmt = null;

		ResultSet rs = null;

		String sql;

		sql = "SELECT SEQUENCE, NAME, PRICE, USEDATE, NOTES";

		sql += " FROM TEST";

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql); // ����� ��� ���� �ִ� ��ü rs

			while (rs.next()) {

				setData sv = new setData(); // ���� ���⼭ ��ü����

				sv.setSequence(rs.getString("SEQUENCE"));

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

	public int updatedata(String sequence, String newcontent) {

		int result = 0;

		Statement stmt = null;

		String sql;

		sql = " UPDATE TEST SET PRICE = '" + newcontent + "'";

		sql += " WHERE SEQUENCE = '" + sequence + "'";

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

		sql += " WHERE SEQUENCE = '" + string + "'";

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