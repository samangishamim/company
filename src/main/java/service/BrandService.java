package service;

import repository.BrandRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {


    private final BrandRepository brandRepository;
    Scanner scanner=new Scanner(System.in);

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void addBrand() throws SQLException {
        System.out.println("*** add brand ***");
        String brandName = getBrandNameUnique();
        String website = getWebsite();
        System.out.println("enter brand description");
        String description = scanner.nextLine();

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
}
