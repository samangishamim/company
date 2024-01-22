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
    private int phoneNmber;
}
