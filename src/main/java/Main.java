import entities.Shareholder;
import service.*;
import utilities.ApplicationContext;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
    Menu menu =new Menu();
    menu.menu();

    }
}
