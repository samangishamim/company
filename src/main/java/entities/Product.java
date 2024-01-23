package entities;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private int productId;
    private String productName;
    private Date productDate;
    private int categoryId;
    private int brandId;




    public Product(String productName, Date productDate, int categoryId, int brandId) {
        this.productName = productName;
        this.productDate = productDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
