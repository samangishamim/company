package entities;


public class Product {

    private int productId;
    private String productName;
    private int productDate;
    private int categoryId;
    private int brandId;

    public Product() {
    }

    public Product(int productId, String productName, int productDate, int categoryId, int brandId) {
        this.productId = productId;
        this.productName = productName;
        this.productDate = productDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Product(String productName, int productDate, int categoryId, int brandId) {
        this.productName = productName;
        this.productDate = productDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
