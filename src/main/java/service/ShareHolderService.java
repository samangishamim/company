package service;

import entities.Brand;
import entities.Shareholder;
import repository.ShareHolderRepository;
import utilities.Validation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        int phoneNumber = getUniquephonenumber();
        scanner.nextLine();


        int result = shareHolderRepository.saveShareholder(new Shareholder(shareholderName,nationalCode,phoneNumber));
        if (result != 0) {
            System.out.println("new shareholder  has been added ");
        } else
            System.out.println("error");
    }

    public int getUniquephonenumber() throws SQLException {
        int phoneNumber;
        while (true) {
            System.out.println("enter your phone number: ");
            phoneNumber = scanner.nextInt();
            scanner.nextLine();
            if (Validation.checkPhoneNumber(String.valueOf(phoneNumber))) {
                boolean phoneNumberExist = shareHolderRepository.isPhoneNumberExist(String.valueOf(phoneNumber));

                if (!phoneNumberExist)
                    break;
                else
                    System.out.println("phone number  exists ");
            }else
                System.out.println("invalid phone number");
        }
        return phoneNumber;
    }

    public int getUniqueNationalCode() throws SQLException {
        int nationalCode;
        while (true) {
            System.out.println("enter your email: ");
            nationalCode = scanner.nextInt();
            if (Validation.validateMelliCode(String.valueOf(nationalCode))) {
                boolean nationalCodeExist = shareHolderRepository.isNationalCodeExist(String.valueOf(nationalCode));

                if (!nationalCodeExist) {
                    break;
                } else {
                    System.out.println("National code already exists");
                }
            } else {
                System.out.println("Invalid national code");
            }
        }
        return nationalCode;
    }

}
