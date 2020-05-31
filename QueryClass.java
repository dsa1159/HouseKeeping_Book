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
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거

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


	// 쿼리문에 입력 메소드
	// Create
		public void insertData(setData data) {
			try {
				String sql = "INSERT INTO TEST(usedate, price, name, notes, userid) values(?, ?, ?, ?, user_id.NEXTVAL)";
				// PrparedStatment객체 생성, 인자로 sql문이 주어짐
				ps = conn.prepareStatement(sql);
				ps.setInt(1, data.usedate);				
				ps.setInt(2, data.price);
				ps.setString(3, data.name);
				ps.setString(4, data.notes);
				
				// executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
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
				// 쿼리문을 db에 넘김, 온전한 문자열 대입
				st = conn.createStatement();

				String sql = "SELECT * FROM TEST ORDER BY usedate ASC";
				//rs:ResultSet은 실행한 쿼리문의 결과 값을 받아들이다.
				rs = st.executeQuery(sql);

				// 받은 결과값을 출력
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
				// 쿼리문을 db에 넘김, 온전한 문자열 대입

				String sql = "SELECT * FROM TEST WHERE NAME=? OR USEDATE=? ORDER BY usedate ASC";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, usedate);
				ps.executeUpdate();
				
				//rs:ResultSet은 실행한 쿼리문의 결과 값을 받아들이다.
				rs = ps.executeQuery(sql);
				
				// 받은 결과값을 출력
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