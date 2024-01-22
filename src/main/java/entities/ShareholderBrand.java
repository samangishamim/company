package entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShareholderBrand {
    private int shareholderbId;
    private int shareholderId;
    private int brandId;

    public ShareholderBrand(int shareholderId, int brandId) {
        this.shareholderId = shareholderId;
        this.brandId = brandId;
    }
}
