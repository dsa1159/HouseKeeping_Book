import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		WriteStart CallLogic = new WriteStart();

		while (true) {		
			
				System.out.println("******************************�츮 �� �����***********************************");
				System.out.println("1.����� �ۼ�(insert) 2.�����Ȯ��(select) 3.����(update) 4.����(update) 5.����(exit)");
				System.out.println("**************************************************************************");
				System.out.print("�۾� ��ȣ�� �����ϼ��� : ");


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
					System.out.println("���α׷� ����");
					sc.close();
					break;
				}			
		}

	}

}