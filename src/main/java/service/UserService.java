package service;

import repository.UserRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final UserRepository userRepository;
    Scanner scanner = new Scanner(System.in);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void SignUp() throws SQLException {

        System.out.println("**** signup ****");
        System.out.println("enter your name: ");
        String name = scanner.nextLine();
        String username = getUsernameUnique();
        String email = getUniqueEmail();
        getPassword();

    }

    private String getPassword() {
        String password;
        while (true) {
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            boolean checkPassword = Validation.checkPassword(password);
            if (checkPassword)
                break;
        }
        return password;
    }

    private String getUsernameUnique() throws SQLException {
        String username;
        while (true) {
            System.out.println("enter your username: ");
            username = scanner.nextLine();
            boolean usernameExist = userRepository.isUsernameExist(username);
            if (!usernameExist)
                break;
        }
        return username;
    }

    public String getUniqueEmail() throws SQLException {
        String email;
        while (true) {
            System.out.println("enter your email: ");
            email = scanner.nextLine();
            if (Validation.checkEmail(email)) {
                boolean emailExist = userRepository.isEmailExist(email);
                if (!emailExist)
                    break;
            }
        }
        return email;
    }
}
