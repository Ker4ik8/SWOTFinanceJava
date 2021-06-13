package sample;

public class Salary {

    private int num;
    private String post;
    private String salary;
    private String percent;
    private String insurance;
    private String tax;

    public Salary(int num, String post, String salary, String percent, String insurance, String tax) {
        this.num = num;
        this.post = post;
        this.salary = salary;
        this.percent = percent;
        this.insurance = insurance;
        this.tax = tax;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
