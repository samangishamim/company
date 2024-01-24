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
    Scanner scanner = new Scanner(System.in);

    public ShareHolderService(ShareHolderRepository shareHolderRepository1) {
        this.shareHolderRepository = shareHolderRepository1;
    }

    public void addShareholder() throws SQLException {

        System.out.println("*** add shareholder ***");
        System.out.println("shareholder enter your name : ");
        String shareholderName = scanner.nextLine();
        String nationalCode = getUniqueNationalCode();

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

    public String getUniqueNationalCode() {
        while (true) {
            System.out.println("Enter your national code: ");
            String input = scanner.nextLine();
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
}