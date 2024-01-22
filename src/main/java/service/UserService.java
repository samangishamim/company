package service;

import repository.UserRepository;

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
        return  username;
    }


}
