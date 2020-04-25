import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.Scanner;



public class JdbcTest02Method {

	Scanner scan = new Scanner(System.in);  // �� �޼ҵ庰 �ߺ��Ǵ� �׸� ����.

	String driver = "oracle.jdbc.driver.OracleDriver"; 

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jhlee";
	String passwd = "Manager1";

		

	public void selectMethod() {        // ��ȸ �޼ҵ� (SELECT)

		String sql = "SELECT * FROM TEST";

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(); 

			while (rs.next()) {

				String userid = rs.getString("USERID"); 

				String name = rs.getString("NAME"); 

				int price = rs.getInt("PRICE");

				String usedate = rs.getString("USEDATE");	
				
				String notes = rs.getString("NOTES");	

				System.out.println(userid + "\t" + name + "\t" + price + "\t" + usedate + "\t" + notes);

			}

		}		

		catch (Exception e) {System.out.println(e.getMessage());}

		

		finally {

			try {rs.close();

				pstmt.close();

				con.close();

			} catch (Exception e) {}

		}

	}

	

	public void updateMethod() {      // ���� �޼ҵ� (UPDATE)	

		String sql = "UPDATE TEST SET NAME = '?', PRICE = ? WHERE USERID = ?";			

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);

			

			System.out.printf("������ �ڵ� �Է�: ");

			String userid = scan.next();

			System.out.printf("������ �̸� �Է�: ");

			String name = scan.next();			

			System.out.printf("������ ���� �Է�: ");

			int price = scan.nextInt();			

			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);			

			

			int cnt = pstmt.executeUpdate(); 

			System.out.println(cnt + "���� ����Ǿ����ϴ�.");

		}

		catch (Exception e) {

			System.out.println(e.getMessage());

		}



		finally {

			try {				

				pstmt.close();

				con.close();

			} catch (Exception e) {

			}

		}

	}

		

	public void deleteMethod() {        // ���� �޼ҵ� (DELETE)

		String sql = "DELETE FROM TEST WHERE USERID = ?";

		String userid = "";		

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);			

			System.out.println("������ �ڵ带 �Է��Ͻÿ�");

			userid = scan.next();			

			pstmt.setString(1, userid);

			int cnt = pstmt.executeUpdate(); 

			System.out.println(cnt);

		}

		catch (Exception e) {System.out.println(e.getMessage());}

		finally {

			try {

				pstmt.close();

				con.close();

			} catch (Exception e) {

			}

		}

	}	



	public void insertMethod() {	        // �Է� �޼ҵ� (INSERT)

		String sql = "INSERT INTO TEST(USERID,NAME,PRICE,USEDATE,NOTES) VALUES(?, ?, ?, ?, ?)";			

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);			

			System.out.printf("�Է��� userid: ");

			String userid = scan.next();

			System.out.printf("�Է��� �̸�: ");

			String name = scan.next();			

			System.out.printf("�Է��� ����: ");

			int price = scan.nextInt();

			System.out.printf("�Է��� ��볯¥: ");

			String usedate = scan.next();	
			
			System.out.printf("�Է��� ��� : ");

			String notes = scan.next();	

			pstmt.setString(1, userid);

			pstmt.setString(2, name);

			pstmt.setInt(3, price);

			pstmt.setString(4, usedate);
			
			pstmt.setString(5, notes);

			int cnt = pstmt.executeUpdate(); 

			System.out.println(cnt + "���� ����Ǿ����ϴ�.");			

		}

		catch (Exception e) {

			System.out.println(e.getMessage());

		}



		finally {

			try {

				pstmt.close();

				con.close();

			} catch (Exception e) {

			}

		}

	}



}
