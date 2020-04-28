import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		LogicClass CallLogic = new LogicClass();

		while (true) {

			try {

				System.out.println("1.입력(insert) 2.출력(select) 3.수정(update) 4.삭제(update) 5.종료(exit)");

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
					sc.close();
					break;
				}

			} catch (Exception e) {

				System.out.println("1부터 4의 숫자중 1개를 선택하십시오.");

			}

		}

	}

}