import java.sql.Connection;
import java.sql.Statement;

public class Test2 {
	public static void main(String[] args) {
		Connection conn = DBConn.getConnection();
		if(conn==null) {
			System.out.println("���� ����!!");
			System.exit(0);
		}
		
		try {
			Statement stmt = conn.createStatement();
			String sql;
			
			sql = "insert into score (hak,name,kor,eng,mat)";
			sql += "values ('222','�̼���',50,20,80)";
			
			//sql = "delte score where hak='222'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("��������!!");
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		DBConn.close();
	}

}
