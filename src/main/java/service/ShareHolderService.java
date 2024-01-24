package service;

import entities.Brand;
import entities.Shareholder;
import repository.ShareHolderRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareHolderService {
    private final ShareHolderRepository shareHolderRepository;
    Scanner scanner=new Scanner(System.in);
    public ShareHolderService( ShareHolderRepository shareHolderRepository1) {
        this.shareHolderRepository = shareHolderRepository1;
    }
    public void addShareholder() throws SQLException {
        System.out.println("*** add shareholder ***");
        System.out.println("shareholder enter your name : ");
        String shareholderName = scanner.nextLine();
        System.out.println("enter your national code: ");
        int nationalCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter your phonenumber: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();


        int result = shareHolderRepository.saveShareholder(new Shareholder(shareholderName,nationalCode,phoneNumber));
        if (result != 0) {
            System.out.println("new shareholder  has been added ");
        } else
            System.out.println("error");
    }

    private String getUniqueWebsite() {
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

}
