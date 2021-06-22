
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        System.out.println("Enter 1 for New USER \n Enter 2 for Registered USER");
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
            try {
            Connection con=Conn.getInstance();
            Statement stmt=con.createStatement();
            String sql="select uid from user where uid="+uid+";";
            ResultSet r=stmt.executeQuery(sql);
            if(r.next()) {
            	new User(uid, sc);
            }
            else {
            	System.out.println("User doesnt exist");
            	App a2=new App();
            	a2.userRegister();
            }
            }
            catch(Exception e) {
            	System.out.println(e);
            }
            break;
    }
}
}

