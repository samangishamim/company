package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shareholder {
    private int shareholderId;
    private String shareholderName;
    private int nationalCode;
    private String phoneNumber;
    private Brand[] brands;


    public Shareholder(String shareholderName, int nationalCode, String phoneNumber) {
        this.shareholderName = shareholderName;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }

    public Shareholder(int shareholderId, String shareholderName, int nationalCode, String phoneNumber) {
        this.shareholderId = shareholderId;
        this.shareholderName = shareholderName;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }



}
