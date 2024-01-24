package service;

import entities.Shareholder;
import entities.ShareholderBrand;
import repository.ShareHolderBrandRepository;
import utilities.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ShareHolderBrandService {
    private final ShareHolderBrandRepository shareHolderBrandRepository;
    private final ShareHolderService shareHolderService = ApplicationContext.getShareHolderService();
    private  final  BrandService brandService=ApplicationContext.getBrandService();
    Scanner scanner = new Scanner(System.in);

    public ShareHolderBrandService(ShareHolderBrandRepository shareHolderBrandRepository1) {

        this.shareHolderBrandRepository = shareHolderBrandRepository1;
    }

    public void addShareholderBrand() throws SQLException {

        System.out.println("*** add shareholderBrand ***");
        System.out.println("enter shareholder id ");
        shareHolderService.listOfShareholder();
        int shareholderId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter brand id");
        brandService.listOfBrand();
        int brandId = scanner.nextInt();
        scanner.nextLine();


        int result = shareHolderBrandRepository.saveShareholderBrand(new ShareholderBrand(shareholderId,brandId));
        if (result != 0) {
            System.out.println("New shareholder has been added");
        } else {
            System.out.println("Error adding shareholder");
        }
    }


}
