package sample;

public class Fixed {

    private int num;
    private String place;
    private String name;
    private String onePrice;
    private String amount;
    private double spend;

    public Fixed(int num, String place, String name, String onePrice, String amount, double spend) {
        this.num = num;
        this.place = place;
        this.name = name;
        this.onePrice = onePrice;
        this.amount = amount;
        this.spend = spend;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(String onePrice) {
        this.onePrice = onePrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
