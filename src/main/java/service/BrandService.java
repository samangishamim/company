package service;

import entities.Brand;
import entities.User;
import repository.BrandRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {
    private final BrandRepository brandRepository;
    Scanner scanner = new Scanner(System.in);

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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

    private String getWebsite() {
        String website;
        while (true) {
            System.out.println("enter your website url: ");
            website = scanner.nextLine();
            boolean checkWebsite = Validation.checkWebsite(website);
            if (checkWebsite)
                break;
            else
                System.out.println("this is not correct website url");
        }
        return website;
    }

    private String getBrandNameUnique() throws SQLException {
        String brandName;
        while (true) {
            System.out.println("enter your website name : ");
            brandName = scanner.nextLine();
            boolean usernameExist = brandRepository.isBrandNameExist(brandName);
            if (!usernameExist)
                break;
            else
                System.out.println("username is not available");
        }
        return brandName;
    }

    public Brand findBrandById(int brandId) throws SQLException {
        return brandRepository.load(brandId);
    }

    public void deleteBrand(int brandId) throws SQLException {
        System.out.println("*** delete brand ***");
        Brand brand = findBrandById(brandId);
        System.out.println("want to delete this brand: [yes or no]");
        System.out.println(brand);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("yes")) {
            brandRepository.delete(brandId);
            System.out.println("Brand deleted successfully.");
        } else if (input.equals("no")) {
            System.out.println("Brand not deleted.");
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}