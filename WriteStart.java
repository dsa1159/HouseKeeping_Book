


public class WriteStart{
    ShowScript showScript = new ShowScript();
    setData setdata = new setData();
    public void start(){
    	
    	boolean loop = true;
    	while(loop) {
    	showScript.StartMessage();
        int input_Scanner = sc.nextInt();
        switch(input_Scanner) {
        	case 0:
        		showScript.Date();
        	    setdata.Dateset();
        	    //////////////////////////////
        	    showScript.Price();
        	    setdata.setMoney();
        	    /////////////////////////////
        	    showScript.CardType();
        	    setdata.setCardType();
        	    /////////////////////////////
        	    showScript.BankAccountNumber();
        	    setdata.setBankAccountNumber();
        	    //////////////////////////////
        	    setdata.addItem();
        	    
        	case 1:
        		
        		for(int i=0;i<setdata.arrayList.size();i++) {
        			System.out.println(setdata.arrayList.get(i));
        		}      		
        	
        	}
        	showScript.ContinueMessage();
        	int question = sc.nextInt();
        	if(question == 1) {
        		loop = false;
        	}
    	}

    }
    
    
            
}