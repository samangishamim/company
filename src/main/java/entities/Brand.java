package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Brand {
    private int brandId;
    private String brandName;
    private String website;
    private  String brandDescription;

    public Brand(String brandName, String website, String brandDescription) {
        this.brandName = brandName;
        this.website = website;
        this.brandDescription = brandDescription;
    }
}
