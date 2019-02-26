public class BookItem{
    String date;
    int money;
    String CardType;
    int BankAccountNumber;


    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCardType() {
        return this.CardType;
    }

    public void setCardType(String CardType) {
        this.CardType = CardType;
    }

    public int getBankAccountNumber() {
        return this.BankAccountNumber;
    }

    public void setBankAccountNumber(int BankAccountNumber) {
        this.BankAccountNumber = BankAccountNumber;
    }


    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", money='" + getMoney() + "'" +
            ", CardType='" + getCardType() + "'" +
            ", BankAccountNumber='" + getBankAccountNumber() + "'" +
            "}";
    }

}