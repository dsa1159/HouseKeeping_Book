import java.util.*;

public class JdbcTest02 {



	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		int cmdNo = 0;



		while (true) {

			System.out.println("");

			System.out.println("���ϴ� �޴��� �����Ͻʽÿ�.");

			System.out.println("1.��ȸ 2.���� 3.���� 4.�Է� 5.����");

			cmdNo = scan.nextInt();



			if (cmdNo == 1) {

				JdbcTest02Method select = new JdbcTest02Method(); // �޼ҵ� Ŭ������ ��ü ����

				select.selectMethod(); // �޼ҵ� Ŭ������ ��ȸ �޼ҵ� ����

			}

			else if (cmdNo == 2) {

				JdbcTest02Method update = new JdbcTest02Method();

				update.updateMethod(); // �޼ҵ� Ŭ������ ���� �޼ҵ� ����

			}

			else if (cmdNo == 3) {

				JdbcTest02Method delete = new JdbcTest02Method();

				delete.deleteMethod(); // �޼ҵ� Ŭ������ ���� �޼ҵ� ����

			}

			else if (cmdNo == 4) {

				JdbcTest02Method insert = new JdbcTest02Method();

				insert.insertMethod(); // �޼ҵ� Ŭ������ �Է� �޼ҵ� ����

			}

			else {

				scan.close();

			break;

			}			

		}

	}

}
