package utilities;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])" +
            "(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String WEBSITE_PATTERN = "^(https?://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";

    public static final String PHONE_NUMBER_PATTERN = "^\\d{11}$";



    public static boolean isValidNationalCode(String input) {
            if (input.length() != 10)
                return false;

            if (!input.matches("\\d+"))
                return false;

            int[] array = new int[10];
            for (int i = 0; i < 10; i++)
                array[i] = Integer.parseInt(input.substring(i, i + 1));

            int num = array[0] * 10 + array[1] * 9 + array[2] * 8 + array[3] * 7 + array[4] * 6 + array[5] * 5 + array[6] * 4 + array[7] * 3 + array[8] * 2;
            int remain = num % 11;
            int control = 11 - remain;

            if (control == 11)
                control = 1;
            if (control == 10)
                control = 0;

            return control == array[9];
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
        System.out.println(pattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        System.out.println(matcher.matches());
        return matcher.matches();
    }



}
