package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private int productId;
    private String productName;
    private int productDate;
    private int categoryId;
    private int brandId;




    public Product(String productName, int productDate, int categoryId, int brandId) {
        this.productName = productName;
        this.productDate = productDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
