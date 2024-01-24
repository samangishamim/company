package service;

import entities.Brand;
import entities.Category;
import repository.BrandRepository;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    Scanner scanner = new Scanner(System.in);

    public CategoryService(CategoryRepository categoryRepository1) {
        this.categoryRepository = categoryRepository1;
    }

    public void addCategory() throws SQLException {
        System.out.println("*** add category ***");
        String categoryName = getCategoryNameUnique("");
        System.out.println("enter brand description");
        String description = scanner.nextLine();
        int result = categoryRepository.saveCategory(new Category(categoryName, description));
        if (result != 0) {
            System.out.println("your category has added ");
        } else
            System.out.println("error");
    }

    private String getCategoryNameUnique(String str) throws SQLException {
        String categoryName;
        while (true) {
            System.out.println("enter your category name : ");
            categoryName = scanner.nextLine();
            if (!str.equals("") && str.equals(categoryName))
                return categoryName;
            boolean categoryNameExist = categoryRepository.isCategoryNameExist(categoryName);
            if (!categoryNameExist)
                break;
            else
                System.out.println("category name  is not available");
        }
        return categoryName;
    }

    public void listOfCategory() throws SQLException {
        Category[] categories = categoryRepository.listOfCategory();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public void editCat(int categoryId) throws SQLException {
        System.out.println("***** edit category *****");
        Category category = categoryRepository.findByCategoryId(categoryId);
        System.out.println(category);
        System.out.println("enter new name of category ");
        String newName = getCategoryNameUnique(category.getCategoryName());
        System.out.println("enter new description ");
        String description = scanner.nextLine();

        int result = categoryRepository.editCategory(new Category(categoryId, newName, description));
        if (result!=0)
            System.out.println("edit is done");
        else
            System.out.println("error");
    }

    public void deletCat(int categoryId) throws SQLException {
        System.out.println("**** delete category *****");
        Category category = categoryRepository.findByCategoryId(categoryId);
        System.out.println(category);
        System.out.println("want to delete this category: [y / n]");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("y")) {
            int delete = categoryRepository.deleteCategory(categoryId);
            if (delete != 0)
                System.out.println("category deleted successfully.");
            else
                System.out.println("error");
        } else if (input.equals("n")) {
            System.out.println("category not deleted.");
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }

    }

}
