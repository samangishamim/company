package service;

import entities.Product;
import repository.ProductRepository;
import utilities.ApplicationContext;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService = ApplicationContext.getCategoryService();
    private final BrandService brandService = ApplicationContext.getBrandService();
    Scanner scanner = new Scanner(System.in);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct() throws SQLException {
        System.out.println("**** add product ****");
        System.out.println("enter product name:");
        String productName = scanner.nextLine();
        System.out.println("enter product create date: ");
        String productDate = scanner.nextLine();
        categoryService.listOfCategory();
        System.out.println("enter category id: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine();
        brandService.listOfBrand();
        System.out.println("enter brand id: ");
        int brandId = scanner.nextInt();
        scanner.nextLine();


        int result = productRepository.saveProduct(new Product(productName,
                Date.valueOf(productDate), categoryId, brandId));
        if (result != 0) {
            System.out.println("product is added");
        } else
            System.out.println("product is not added");
    }
}
