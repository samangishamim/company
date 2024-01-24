package service;

import entities.Category;
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


        String productDate = getValidDate();

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
        String productDate = scanner.next();
        System.out.println("your category id is: " + product.getCategoryId());
        int productCategoryId = scanner.nextInt();
        System.out.println("your brand id is: " + product.getBrandId());
        int productBrandId = scanner.nextInt();


        int result = productRepository.editProduct(new Product(productId, productName, Date.valueOf(productDate), productCategoryId, productBrandId));
        if (result != 0) {
            System.out.println("edit is done");
        } else
            System.out.println("error -edit");
    }

    private String getValidDate() {
       String date;
        while (true) {
            System.out.println("Enter the date (in the format YYYY-MM-DD):");
            date = scanner.nextLine();
            if (Validation.checkValidDate(date)) {
                break;
            } else
                System.out.println("invalid date");
        }
        return date;
    }
    public void deletProduct(int productId) throws SQLException {
        System.out.println("**** delete product *****");
        Product product= productRepository.findProductById(productId);
        System.out.println(product);
        System.out.println("want to delete this product: [y / n]");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("y")) {
            int delete = productRepository.deleteProduct(productId);
            if (delete != 0)
                System.out.println("product deleted successfully.");
            else
                System.out.println("error");
        } else if (input.equals("n")) {
            System.out.println("product not deleted.");
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }

    }

    public void deletByBrand(int brandId) throws SQLException {
        System.out.println("**** delete by brand  id *****");
        int result = productRepository.deleteByBrandId(brandId);
        if (result !=0)
            System.out.println("success to delete product by brand ID");
        else
            System.out.println("error to delete product by brand ID");
    }



    public void deletByCategoryId(int categoryId) throws SQLException {
        System.out.println("**** delete by CATEGORY  id *****");
        int result = productRepository.deleteByCategoryId(categoryId);
        if (result !=0)
            System.out.println("success to delete product by category ID");
        else
            System.out.println("error to delete product by category ID");
    }
    }

