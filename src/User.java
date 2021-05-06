package src;

import java.util.*;

public class User {
    int uid;
    String uname;

    User(int uid, String uname, Scanner sc) {
        this.uid = uid;
        this.uname = uname;
        System.out.println("User Successfully Registered");
        gameSelection(uid, sc);
    }

    private void gameSelection(int uid, Scanner sc) {
        while (true) {
            System.out.println("Welcome, we have 3 games with us for now.");
            System.out.println("1 - Jumbled Words");
            System.out.println("2 - Riddler");
            System.out.println("3 - Hangman");
            System.out.println("Enter your choice or Enter 0 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("First Game running");
                    // constructor calling for first game
                    break;
                case 2:
                    System.out.println("Second Game running");
                    // constructor calling for 2nd game
                    break;
                case 3:
                    System.out.println("Third Game running");
                    new Hangman(sc);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong Input!! Please enter again");
                    break;
            }
        }
    }

    private void getHistory() {

    }
}
