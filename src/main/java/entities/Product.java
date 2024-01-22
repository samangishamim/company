package entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {

    private int productId;
    private String productName;
    private int productDate;
    private int categoryId;
    private int brandId;
}
