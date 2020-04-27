import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {

		char option = 0;

		LogicClass CallLogic = new LogicClass();
		
		boolean loop = true;

		while (loop) {

			try {

				System.out.println("1.입력(insert) 2.출력(select) 3.수정(update) 4.삭제(update)");

				option = (char) System.in.read(); // 선택사항중에 하나의 값을 입력받자.

				System.in.skip(2); // 2바이트를 읽지않고 넘어간다는 뜻으로 두개의 로직을 구분하기 위해 사용되었다.

				break;

			} catch (Exception e) {

				System.out.println("1부터 4의 숫자중 1개를 선택하십시오.");

			}

		}

		switch (option) {

		case '1':
			CallLogic.insert();
			break;

		case '2':
			CallLogic.select();
			break;

		case '3':
			CallLogic.update();
			break;

		case '4':
			CallLogic.delete();
			break;

		}

	}

}