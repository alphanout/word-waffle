package PW;
import java.util.*;
public class App 
{
    public static void main(String[] args) throws Exception {
        int uid;
        String username;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter 1 for New USER \nEnter 2 for Registered USER");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1 :
            System.out.println("Enter your UID");
            uid = sc.nextInt();
            System.out.println("Enter your Name");
            username = sc.next();
            new User(uid, username,sc);
            break;
            case 2 :
            System.out.println("Welcome Back!!!, Please enter your UserID");
            uid = sc.nextInt();
            new User(uid, sc);
            break;
        }
    }
}
