package sample;

public class Expenses {

    private int num;
    private String type;
    private String spend;

    public Expenses(int num, String type, String spend) {
        this.num = num;
        this.type = type;
        this.spend = spend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpend() {
        return spend;
    }

    public void setSpend(String spend) {
        this.spend = spend;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
