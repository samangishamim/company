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
    private int phoneNumber;
    private Brand[] brands;


    public Shareholder(String shareholderName, int nationalCode, int phoneNumber) {
        this.shareholderName = shareholderName;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }




}
