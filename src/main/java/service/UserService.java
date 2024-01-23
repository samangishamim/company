package service;

import entities.User;
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
        String password = getPassword();


        int result = userRepository.SignUp(new User(name, username, email, password));
        if (result != 0) {
            System.out.println("you have signup ");
        } else
            System.out.println("error");
    }

    private String getPassword() {
        String password;
        while (true) {
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            boolean checkPassword = Validation.checkPassword(password);
            if (checkPassword)
                break;
            else
                System.out.println("this is not strong password");
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
            else
                System.out.println("username is not available");
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
                else
                    System.out.println("email exists ");
            }else
                System.out.println("invalid email");
        }
        return email;
    }
    public boolean signIn () throws SQLException {
        System.out.println("***** sign in *****");
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        System.out.println("enter your password ");
        String password = scanner.nextLine();
        boolean signedIn = userRepository.SignIn(username, password);
        if (signedIn)
            System.out.println("welcome");
        else
            System.out.println("username or password is wrong");
        return signedIn;
    }
}
