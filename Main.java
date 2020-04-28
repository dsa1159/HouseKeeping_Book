import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		WriteStart CallLogic = new WriteStart();

		while (true) {		
			
				System.out.println("******************************우리 집 가계부***********************************");
				System.out.println("1.가계부 작성(insert) 2.가계부확인(select) 3.수정(update) 4.삭제(update) 5.종료(exit)");
				System.out.println("**************************************************************************");
				System.out.print("작업 번호를 선택하세요 : ");


				option = sc.nextInt(); // 선택사항중에 하나의 값을 입력받자.

				System.in.skip(2); // 2바이트를 읽지않고 넘어간다는 뜻으로 두개의 로직을 구분하기 위해 사용되었다.
				
				if (option == 1)
					CallLogic.insert();
				else if (option == 2)
					CallLogic.select();
				else if (option == 3)
					CallLogic.update();
				else if (option == 4)
					CallLogic.delete();
				else {
					System.out.println("프로그램 종료");
					sc.close();
					break;
				}			
		}

	}

}