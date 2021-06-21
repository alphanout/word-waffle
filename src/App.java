
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
       App a1=new App();
       a1.userRegister();
    }
        void userRegister() {
        int uid;
        String username;
        Scanner sc= new Scanner(System.in);
        System.out.println("WELCOME TO WORD-WAFFLE GAME");
        System.out.println("Enter 1 for New USER \nEnter 2 for Registered USER");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1 :
            System.out.println("Enter your UID");
            uid = sc.nextInt();
            System.out.println("Enter your Name");
            username = sc.next();
            User u = new User(uid, username,sc);
            break;
            case 2 :
            System.out.println("Welcome Back!!!, Please enter your UserID");
            uid = sc.nextInt();
            User s = new User(uid, sc);
            break;
    }
}
}
