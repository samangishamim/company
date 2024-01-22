package entities;


public class Shareholder {
    private int shareholderId;
    private String shareholderName;
    private int nationalCode;
    private int phoneNmber;

    public Shareholder() {
    }

    public Shareholder(String shareholderName, int nationalCode, int phoneNmber) {
        this.shareholderName = shareholderName;
        this.nationalCode = nationalCode;
        this.phoneNmber = phoneNmber;
    }

    public Shareholder(int shareholderId, String shareholderName, int nationalCode, int phoneNmber) {
        this.shareholderId = shareholderId;
        this.shareholderName = shareholderName;
        this.nationalCode = nationalCode;
        this.phoneNmber = phoneNmber;
    }
}
