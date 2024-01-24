package utilities;

import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])" +
            "(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String WEBSITE_PATTERN = "^(https?://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";

    public static final String PHONE_NUMBER_PATTERN = "^\\d{11}$";
    public static final String DATE_PATTERN = "((18|19|20)[0-9]{2}[\\-.](0[13578]|1[02])[\\-.]" +
            "(0[1-9]|[12][0-9]|3[01]))|(18|19|20)[0-9]{2}[\\-.](0[469]|11)[\\-.](0[1-9]|[12]" +
            "[0-9]|30)|(18|19|20)[0-9]{2}[\\-.](02)[\\-.](0[1-9]|1[0-9]|2[0-8])" +
            "|(((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)[\\-.](02)[\\-.]29";


    public static boolean isValidNationalCode(String melliCode) {

        String[] identicalDigits = {
                "0000000000",
                "1111111111",
                "2222222222",
                "3333333333",
                "4444444444",
                "5555555555",
                "6666666666",
                "7777777777",
                "8888888888",
                "9999999999"};

        if (melliCode.trim().isEmpty()) {
            System.out.println("National Code is empty");
            return false; // National Code is empty
        } else if (melliCode.length() != 10) {
            System.out.println("National Code must be exactly 10 digits");
            return false; // National Code is less or more than 10 digits
        } else if (Arrays.asList(identicalDigits).contains(melliCode)) {
            System.out.println("MelliCode is not valid (Fake MelliCode)");
            return false; // Fake National Code
        } else {
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(melliCode.charAt(i)) * (10 - i);
            }

            int lastDigit;
            int divideRemaining = sum % 11;

            if (divideRemaining < 2) {
                lastDigit = divideRemaining;
            } else {
                lastDigit = 11 - (divideRemaining);
            }

            if (Character.getNumericValue(melliCode.charAt(9)) == lastDigit) {
                System.out.println("MelliCode is valid");
                return true;
            } else {
                System.out.println("MelliCode is not valid");
                return false; // Invalid MelliCode
            }
        }
    }

    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean checkWebsite(String website) {
        Pattern pattern = Pattern.compile(WEBSITE_PATTERN);
        Matcher matcher = pattern.matcher(website);
        return matcher.matches();

    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean checkValidDate(String date){
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}