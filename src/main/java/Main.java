import service.UserService;
import utilities.ApplicationContext;
import utilities.Validation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService= ApplicationContext.getUserService();
//        userService.SignUp();
        userService.signIn();
    }
}
