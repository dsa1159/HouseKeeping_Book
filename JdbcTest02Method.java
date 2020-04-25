import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.Scanner;



public class JdbcTest02Method {

	Scanner scan = new Scanner(System.in);  // 각 메소드별 중복되는 항목 빼냄.

	String driver = "oracle.jdbc.driver.OracleDriver"; 

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jhlee";
	String passwd = "Manager1";

		

	public void selectMethod() {        // 조회 메소드 (SELECT)

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

	

	public void updateMethod() {      // 수정 메소드 (UPDATE)	

		String sql = "UPDATE TEST SET NAME = '?', PRICE = ? WHERE USERID = ?";			

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);

			

			System.out.printf("수정할 코드 입력: ");

			String userid = scan.next();

			System.out.printf("수정할 이름 입력: ");

			String name = scan.next();			

			System.out.printf("수정할 가격 입력: ");

			int price = scan.nextInt();			

			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);			

			

			int cnt = pstmt.executeUpdate(); 

			System.out.println(cnt + "건이 실행되었습니다.");

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

		

	public void deleteMethod() {        // 삭제 메소드 (DELETE)

		String sql = "DELETE FROM TEST WHERE USERID = ?";

		String userid = "";		

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);			

			System.out.println("삭제할 코드를 입력하시오");

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



	public void insertMethod() {	        // 입력 메소드 (INSERT)

		String sql = "INSERT INTO TEST(USERID,NAME,PRICE,USEDATE,NOTES) VALUES(?, ?, ?, ?, ?)";			

		Connection con = null;

		PreparedStatement pstmt = null;		

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, passwd);

			pstmt = con.prepareStatement(sql);			

			System.out.printf("입력할 userid: ");

			String userid = scan.next();

			System.out.printf("입력할 이름: ");

			String name = scan.next();			

			System.out.printf("입력할 가격: ");

			int price = scan.nextInt();

			System.out.printf("입력할 사용날짜: ");

			String usedate = scan.next();	
			
			System.out.printf("입력할 비고 : ");

			String notes = scan.next();	

			pstmt.setString(1, userid);

			pstmt.setString(2, name);

			pstmt.setInt(3, price);

			pstmt.setString(4, usedate);
			
			pstmt.setString(5, notes);

			int cnt = pstmt.executeUpdate(); 

			System.out.println(cnt + "건이 실행되었습니다.");			

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
