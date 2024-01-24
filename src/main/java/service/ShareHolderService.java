package service;

import entities.Brand;
import entities.Product;
import entities.Shareholder;
import repository.ShareHolderRepository;
import utilities.Validation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShareHolderService {
    private final ShareHolderRepository shareHolderRepository;
    Scanner scanner = new Scanner(System.in);

    public ShareHolderService(ShareHolderRepository shareHolderRepository) {
        this.shareHolderRepository = shareHolderRepository;
    }

    public void addShareholder() throws SQLException {

        System.out.println("*** add shareholder ***");
        System.out.println("shareholder enter your name : ");
        String shareholderName = scanner.nextLine();
        String nationalCode = getUniqueNationalCode("");

        String phoneNumber = getPhoneNumber();

        int result = shareHolderRepository.saveShareholder(new Shareholder(shareholderName, nationalCode, phoneNumber));
        if (result != 0) {
            System.out.println("New shareholder has been added");
        } else {
            System.out.println("Error adding shareholder");
        }
    }

    public String getPhoneNumber() {
        while (true) {
            System.out.println("Enter your phone number: ");
            String input = scanner.nextLine();
            if (Validation.checkPhoneNumber(input)) {
                return input;
            } else {
                System.out.println("Invalid phone number. Please try again.");
            }
        }
    }

    public String getUniqueNationalCode(String str) {
        while (true) {
            System.out.println("Enter your national code: ");
            String input = scanner.nextLine();
            if (!str.equals("")&&str.equals(input))
                return input;
            if (Validation.isValidNationalCode(input)) {
                return input;
            } else {
                System.out.println("Invalid national code. Please try again.");
            }
        }
    }

    public void listOfShareholder() throws SQLException {
        Shareholder[] shareholders = shareHolderRepository.listOfShareholder();
        for (Shareholder shareholder : shareholders) {
            System.out.println(shareholder);
        }
    }
    public void editShareholder(int id) throws SQLException {
        Shareholder shareholder = shareHolderRepository.findshareholderById(id);
        if (shareholder == null) {
            return;
        }
        System.out.println(shareholder);
        System.out.println("your shareholder name is: " + shareholder.getShareholderName());
        String shareholderName = scanner.nextLine();
        System.out.println("your shareholder national code is: " + shareholder.getNationalCode());
        String uniqueNationalCode = getUniqueNationalCode(shareholder.getNationalCode());
        System.out.println("your phone number is: " + shareholder.getPhoneNumber());
        String phoneNumber = getPhoneNumber();


        int result = shareHolderRepository.editShareholder(new Shareholder(id,shareholderName,uniqueNationalCode,phoneNumber));
        if (result != 0) {
            System.out.println("edit is done");
        } else
            System.out.println("error -edit");
    }

}