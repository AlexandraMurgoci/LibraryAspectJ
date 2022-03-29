package library.controller;

import library.security.Role;
import library.security.SessionData;

import java.util.Scanner;

public class MainController {
    private BookController bookController = new BookController();

    public void run() {
        runMenu();
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            if(option == 1) {
                bookController.viewAll();
                System.out.println("\n\n");
            }
            else if(option == 2) {
                //TODO
            }
            else if(option == 3) {
                bookController.addBook();
                System.out.println("\n\n");
            }
            else if(option == 4) {
                SessionData.setActiveRole(Role.ADMIN);
            }
            else if(option == 5) {
                SessionData.setActiveRole(null);
            }
        } while (option != 0);
    }

    private void displayMenu() {
        System.out.println(
                "" +
                        "1. View book list\n" +
                        "2. View a book\n" +
                        "3. Add a book\n" +
                        "4. Login\n" +
                        "5. Logout\n" +
                        "0. EXIT"
        );
    }

}
