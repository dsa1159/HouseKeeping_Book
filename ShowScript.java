
import java.util.ArrayList;

public class ShowScript{
	
	public void ContinueMessage() {
		System.out.print("프로그램을 종료 하시겠습니까? : 0 = 계속 ,1 = 종료 ,2 = 데이터 삭제");
	}
    public void StartMessage() {
    	System.out.print("가계부를 작성할려면 0, 가계부 리스트를 확인 할려면 1 : ");
    }
    public void Date(){
        System.out.print("카드 사용일자를 작성해주세요. \n숫자 0 을 작성하시면 현재 시각으로 작성 됩니다. :");
    }
    public void Price(){
        System.out.print("사용 금액을 작성 해주세요. \n 숫자만 입력하시오. : ");
    }
    public void CardType(){
        System.out.print("카드종류를 작성해주세요. ex)국민, 국민(체크), 국민(신용) : ");
    }
    public void explantion(){
        System.out.print("사용 목적을 작성 해주세요. :");
    }
    public void BankAccountNumber(){
        System.out.print("계좌번호를 입력해주시오. : ");
    }
    public void End(){
        System.out.print("다른 내용을 작성 하시겠습니까? \n 내용을 더 작성 하실려면 숫자 1, 아니면 0");
    }
    public void EndMessage(){
        System.out.println("***********가계부***********");
    }
    public void removeMessage(){
        System.out.println("삭제할 데이터의 위치를 지정해주세요. 0번부터 시작 : ");
    }
    



}