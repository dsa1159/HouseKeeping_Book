import java.sql.Connection;

import java.sql.DriverManager;

public class DBconn {

	private static Connection conn = null; // ���� conn �̶�� ���۷��� ������ ������Ʈ ��ü Connection�� ����

	public static Connection getConnection() { // ���ϰ��� Connection�� getConnectio() �޼ҵ带 ����

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		String user = "jhlee";

		String pwd = "Manager1";

		if (conn == null) {

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver"); // ����Ŭ����̹��� �޸𸮿� �ε��Ѵ�.

				conn = DriverManager.getConnection(url, user, pwd);

			} catch (Exception e) {

				System.out.println(e.toString());

			}

		}

		return conn;

	}

}