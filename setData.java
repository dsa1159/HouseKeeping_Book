import java.util.ArrayList;
import java.util.Scanner;

public class setData{
    
    Scanner sc = new Scanner(System.in);
    ArrayList<BookItem> arrayList = new ArrayList<>();
    String date;
    String CardType;
    int BankAccountNumber;
    int money;
    public void Dateset(){
    	date = sc.next();
    	if(date == "0") {
    		date = "2019-00-00";	
    	}     
    	
    }
    public void setMoney() {
    	money = sc.nextInt();
    	
    }
    public void setCardType() {
    	CardType = sc.next();
    	
    }
    public void setBankAccountNumber() {
    	BankAccountNumber = sc.nextInt();
    	
    }
    public void addItem() {
    	BookItem bookItem = new BookItem();
    	bookItem.setDate(date);
    	bookItem.setMoney(money);
    	bookItem.setCardType(CardType);
    	bookItem.setBankAccountNumber(BankAccountNumber);
    	arrayList.add(bookItem);
    }
    public void showHouseKeepingBook(int positon) {
    	arrayList.get(positon);
    }
    
}