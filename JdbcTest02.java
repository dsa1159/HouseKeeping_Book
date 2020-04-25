import java.util.*;

public class JdbcTest02 {



	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		int cmdNo = 0;



		while (true) {

			System.out.println("");

			System.out.println("원하는 메뉴를 선택하십시오.");

			System.out.println("1.조회 2.수정 3.삭제 4.입력 5.종료");

			cmdNo = scan.nextInt();



			if (cmdNo == 1) {

				JdbcTest02Method select = new JdbcTest02Method(); // 메소드 클래스의 객체 생성

				select.selectMethod(); // 메소드 클래스의 조회 메소드 실행

			}

			else if (cmdNo == 2) {

				JdbcTest02Method update = new JdbcTest02Method();

				update.updateMethod(); // 메소드 클래스의 수정 메소드 실행

			}

			else if (cmdNo == 3) {

				JdbcTest02Method delete = new JdbcTest02Method();

				delete.deleteMethod(); // 메소드 클래스의 삭제 메소드 실행

			}

			else if (cmdNo == 4) {

				JdbcTest02Method insert = new JdbcTest02Method();

				insert.insertMethod(); // 메소드 클래스의 입력 메소드 실행

			}

			else {

				scan.close();

			break;

			}			

		}

	}

}
