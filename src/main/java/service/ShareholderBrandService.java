package service;

import entities.ShareholderBrand;
import repository.ShareholderBrandRepository;
import utilities.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandService {
    private final ShareholderBrandRepository shareholderBrandRepository;
    private final ShareHolderService shareholderService = ApplicationContext.getShareHolderService();
    private final BrandService brandService = ApplicationContext.getBrandService();
    Scanner scanner = new Scanner(System.in);

    public ShareholderBrandService(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }

    public void addShareholderBrand() throws SQLException {
        System.out.println("*** add shareholderBrand ***");
        System.out.println("enter shareholder id ");
//        shareholderService.listOfShareholder();
        int shareholderId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter brand id");
        brandService.listOfBrand();
        int brandId = scanner.nextInt();
        scanner.nextLine();


        int result = shareholderBrandRepository.save(new ShareholderBrand(shareholderId, brandId));
        if (result != 0) {
            System.out.println("New shareholder has been added");
        } else {
            System.out.println("Error adding shareholder");
        }
    }

    public void deleteShareholderBrand(int id) throws SQLException {
        int result = shareholderBrandRepository.deleteShareholderBrandId(id);
        if (result !=0){
            System.out.println("delete is done");
        }else
            System.out.println("error");
    }

    public  void deleteByBrandId (int brandId) throws SQLException {
        int result = shareholderBrandRepository.deleteByBrandId(brandId);
        if (result!=0){
            System.out.println("delete is done");
        }else
            System.out.println("error");
    }
    public  void deleteByShareholderId (int shareholderId) throws SQLException {
        int result = shareholderBrandRepository.deleteByShareholderId(shareholderId);
        if (result!=0){
            System.out.println("delete is done");
        }else
            System.out.println("error");
    }


}
