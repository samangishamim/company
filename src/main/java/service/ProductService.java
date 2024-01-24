package service;

import entities.Brand;
import entities.Product;
import repository.ProductRepository;
import utilities.ApplicationContext;
import utilities.Validation;

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

    public void editProduct(int productId) throws SQLException {
        Product product = productRepository.loadProduct(productId);
        if (product == null) {
            return;
        }
        System.out.println(product);
        System.out.println("your product name is: " + product.getProductName());
        String productName = scanner.nextLine();
        System.out.println("your product date is: " + product.getProductDate());
        Date productDate = scanner.nextInt();
        System.out.println("your category id is: " + product.getCategoryId());
        int productCategoryId = scanner.nextInt();
        System.out.println("your brand id is: " + product.getBrandId());
        int productBrandId = scanner.nextInt();


        int result = productRepository.editProduct(new Product(productId, productName, productDate, productCategoryId, productBrandId));
        if (result != 0) {
            System.out.println("edit is done");
        } else
            System.out.println("error -edit");
    }

    private Date getValidDate() {
        Date date = Date.valueOf("");
        while (true) {
            System.out.println("Enter the date (in the format MM/DD/YYYY):");
            date = Date.valueOf(scanner.nextLine());
            if (Validation.checkValidDate(date)) {
                break;
            } else
                System.out.println("invalid date");
        }
        return date;
    }
}
