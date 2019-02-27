import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class setData{
    
    Scanner sc = new Scanner(System.in);
    ArrayList<BookItem> arrayList = new ArrayList<>();
    String date;
    String CardType;
    String explanation;
    int money;
    Date nowDate = new Date();

    public void Dateset(){
        date = nowDate.toString();
    }
    public void setMoney() {
        while(true){
            try{
                money = sc.nextInt();
                break;
            }catch(InputMismatchException e){
               
                System.out.print("잘못 입력하셨습니다. 숫자만 입력해주세요. : ");
                 sc = new Scanner(System.in);

                
            }
        }
    }
    public void removeItem(int removePosition){
        arrayList.remove(removePosition);
        
    }
    public void setCardType() {
    	CardType = sc.next();
    	
    }
    public void setExplanation() {
    	explanation = sc.next();
    	
    }
    public void addItem() {
    	BookItem bookItem = new BookItem();
    	bookItem.setDate(date);
    	bookItem.setMoney(money);
    	bookItem.setCardType(CardType);
    	bookItem.setExplanation(explanation);
    	arrayList.add(bookItem);
    }
    public void showHouseKeepingBook(int positon) {
    	arrayList.get(positon);
    }
    
}