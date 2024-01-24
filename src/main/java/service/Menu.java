package service;

import utilities.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserService userService = ApplicationContext.getUserService();
    BrandService brandService = ApplicationContext.getBrandService();
    ProductService productService = ApplicationContext.getProductService();

    ShareholderBrandService shareholderBrandService = ApplicationContext.getShareholderBrandService();
    CategoryService categoryService = ApplicationContext.getCategoryService();

    public void menu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("***** main menu *****");
            System.out.println("1-sign up");
            System.out.println("2-sign in");
            System.out.println("0-exit");
            System.out.println("enter a number ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> userService.SignUp();
                case 2 -> {
                    boolean result = userService.signIn();
                    if (result)
                        subMenu();

                }
                case 0 -> {
                    System.out.println("byeeeeee");
                    break;
                }

            }
        }


    }

    public void subMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**** sub menu ****");
            System.out.println("1-brand");
            System.out.println("2-category");
            System.out.println("3-product");
            System.out.println("4-shareholder");
            System.out.println("5-shareholderBrand");
            System.out.println("0-exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> brandMenu();
                case 2 -> categoryMenu();
                case 3 -> productMenu();
                case 4 -> shareholderMenu();
                case 5 -> shareholderBrandMenu();
                case 0 -> {
                    System.out.println("exit from subMenu");
                    break;
                }

            }
        }
    }

    public void brandMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("***** BRAND MENU *****");
            System.out.println("1-add ");
            System.out.println("2-edit ");
            System.out.println("3-delete ");
            System.out.println("0-exit");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> brandService.addBrand();
                case 2 -> {
                    System.out.println("enter the brand id to edit ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
                    brandService.editBrand(brandId);
                }
                case 3 -> {
                    System.out.println("enter the brand id to delete ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
                    productService.deletByBrand(brandId);
                    shareholderBrandService.deleteByBrandId(brandId);
                    brandService.deleteBrand(brandId);
                }
                case 0 -> {
                    System.out.println("exit from brand Menu ");
                    break;
                }
            }
        }
    }




}
