import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {

		char option = 0;

		LogicClass CallLogic = new LogicClass();
		
		boolean loop = true;

		while (loop) {

			try {

				System.out.println("1.�Է�(insert) 2.���(select) 3.����(update) 4.����(update)");

				option = (char) System.in.read(); // ���û����߿� �ϳ��� ���� �Է¹���.

				System.in.skip(2); // 2����Ʈ�� �����ʰ� �Ѿ�ٴ� ������ �ΰ��� ������ �����ϱ� ���� ���Ǿ���.

				break;

			} catch (Exception e) {

				System.out.println("1���� 4�� ������ 1���� �����Ͻʽÿ�.");

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