package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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
