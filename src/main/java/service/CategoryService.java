package service;

import entities.Brand;
import repository.BrandRepository;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    Scanner scanner=new Scanner(System.in);

    public CategoryService(CategoryRepository categoryRepository1) {
        this.categoryRepository = categoryRepository1;
    }
    public void addBrand() throws SQLException {
        System.out.println("*** add brand ***");
        String brandName = getBrandNameUnique();
        String website = getWebsite();
        System.out.println("enter brand description");
        String description = scanner.nextLine();
        int result = BrandRepository.saveBrand(new Brand(brandName, website, description));
        if (result != 0) {
            System.out.println("your brand has added ");
        } else
            System.out.println("error");
    }
    private String getCategoryNameUnique() throws SQLException {
        String categoryName;
        while (true) {
            System.out.println("enter your website name : ");
            categoryName = scanner.nextLine();
            boolean categoryNameExist = categoryRepository.isCategoryNameExist(categoryName);
            if (!categoryNameExist)
                break;
            else
                System.out.println("username is not available");
        }
        return categoryName;
    }
}
