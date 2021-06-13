package sample;

public class Credit {

    private int num;
    private String rate;
    private String value;

    public Credit(int num, String rate) {
        this.num = num;
        this.rate = rate;
        this.value = "";
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
