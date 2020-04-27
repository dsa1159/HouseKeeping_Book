import java.sql.Connection;

import java.sql.DriverManager;

public class DBconn {

	private static Connection conn = null; // 먼저 conn 이라는 레퍼런스 변수로 오브젝트 객체 Connection을 선언

	public static Connection getConnection() { // 리턴값이 Connection인 getConnectio() 메소드를 선언

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		String user = "jhlee";

		String pwd = "Manager1";

		if (conn == null) {

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클드라이버를 메모리에 로딩한다.

				conn = DriverManager.getConnection(url, user, pwd);

			} catch (Exception e) {

				System.out.println(e.toString());

			}

		}

		return conn;

	}

}