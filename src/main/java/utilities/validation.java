package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {
    private static final Pattern PASSWORD_PATTERN ;
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    static {
        PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])" +
                "(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$") ;
    }
}
