package service;

import entities.Brand;
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
        int result = brandRepository.saveBrand(new Brand(brandName, website, description));
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
            System.out.println("enter your brand name : ");
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
        boolean brandExist = brandRepository.isBrandIdExist(brandId);
        System.out.println("want to delete this brand: [y / n]");
        System.out.println(brandExist);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("y")) {
            int delete = brandRepository.delete(brandId);
            if (delete != 0)
                System.out.println("Brand deleted successfully.");
            else
                System.out.println("error");
        } else if (input.equals("n")) {
            System.out.println("Brand not deleted.");
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }


    public void editBrand(int brandId) throws SQLException {
        Brand brand = brandRepository.load(brandId);
        if (brand == null) {
            return;
        }
        System.out.println(brand);
        System.out.println("your brand name is: " + brand.getBrandName());
        String nameUnique = getBrandNameUnique();
        System.out.println("your website url is: " + brand.getWebsite());
        String website = getCheckWebsitewebsite();
        System.out.println("enter you brand description: ");
        String description=scanner.nextLine();


        int result = brandRepository.edit(new Brand(brandId,nameUnique, website, description));
        if (result != 0){
            System.out.println("edit is done");
        }else
            System.out.println("error -edit");
    }

    private String getCheckWebsitewebsite() {
        String website;
        while (true) {
            System.out.println("enter your newest brand website : ");
             website = scanner.nextLine();
            boolean checked = Validation.checkWebsite(website);
            if (checked)
                break;
            else
                System.out.println("invalid website url");
        }
        return website;
    }

}