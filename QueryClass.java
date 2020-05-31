import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryClass {

	private Connection conn;
	ResultSet rs = null;
	Statement st = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�

	public QueryClass(Connection conn) {
		this.conn = conn;
	}
	
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}


	// �������� �Է� �޼ҵ�
	// Create
		public void insertData(setData data) {
			try {
				String sql = "INSERT INTO TEST(usedate, price, name, notes, userid) values(?, ?, ?, ?, user_id.NEXTVAL)";
				// PrparedStatment��ü ����, ���ڷ� sql���� �־���
				ps = conn.prepareStatement(sql);
				ps.setInt(1, data.usedate);				
				ps.setInt(2, data.price);
				ps.setString(3, data.name);
				ps.setString(4, data.notes);
				
				// executeUpdate : insert, delete, update�� ���� ���� �޾ƿ��� �ʴ� ������ ����
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}

		// Read
		public ArrayList<setData> readData() {
			ArrayList<setData> arr = new ArrayList<setData>();
			System.out.println(arr);
			try {
				// �������� db�� �ѱ�, ������ ���ڿ� ����
				st = conn.createStatement();

				String sql = "SELECT * FROM TEST ORDER BY usedate ASC";
				//rs:ResultSet�� ������ �������� ��� ���� �޾Ƶ��̴�.
				rs = st.executeQuery(sql);

				// ���� ������� ���
				while (rs.next()) {
					arr.add(new setData(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return arr;
		}

		// Update
		public void updateData(String sequence, int price) {
			try {
				String sql = "UPDATE TEST SET PRICE=? WHERE USERID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, price);
				ps.setString(2, sequence);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}

		// Delete
		public void deleteData(String sequence) {
			try {

				String sql = "DELETE FROM TEST WHERE USERID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sequence);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		
		public ArrayList<setData> serchData(String name, String usedate) {
			ArrayList<setData> arr = new ArrayList<setData>();
			System.out.println(arr);
			try {
				// �������� db�� �ѱ�, ������ ���ڿ� ����

				String sql = "SELECT * FROM TEST WHERE NAME=? OR USEDATE=? ORDER BY usedate ASC";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, usedate);
				ps.executeUpdate();
				
				//rs:ResultSet�� ������ �������� ��� ���� �޾Ƶ��̴�.
				rs = ps.executeQuery(sql);
				
				// ���� ������� ���
				while (rs.next()) {
					arr.add(new setData(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return arr;
		}
		
	}