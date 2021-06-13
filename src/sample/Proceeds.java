package sample;

public class Proceeds {

    private int num;
    private String service;
    private String measure;
    private String price;
    private String amount;
    private double income;

    public Proceeds(int num, String service, String measure, String price, String amount, double income) {
        this.num = num;
        this.service = service;
        this.measure = measure;
        this.price = price;
        this.amount = amount;
        this.income = income;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
