import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static Connection dbConn;
	
	public static Connection getConnection() {
		if(dbConn==null) {//null일 경우 연결이 되지 않은 상태
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "jhlee";
				String password = "Manager1";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, password);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}
	public static void close() {
		if(dbConn!=null) {//null이 아니면 연결되어 있는 상태
			try {
				if(!dbConn.isClosed()) {
					dbConn.close();
				}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
		dbConn = null;
	}

}
