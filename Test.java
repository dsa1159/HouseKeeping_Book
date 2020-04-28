import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		LogicClass CallLogic = new LogicClass();

		while (true) {

			try {

				System.out.println("1.�Է�(insert) 2.���(select) 3.����(update) 4.����(update) 5.����(exit)");

				option = sc.nextInt(); // ���û����߿� �ϳ��� ���� �Է¹���.

				System.in.skip(2); // 2����Ʈ�� �����ʰ� �Ѿ�ٴ� ������ �ΰ��� ������ �����ϱ� ���� ���Ǿ���.
				
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

				System.out.println("1���� 4�� ������ 1���� �����Ͻʽÿ�.");

			}

		}

	}

}