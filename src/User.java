package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class User {
    int uid;
    String uname;
    int res;
    User(int uid, Scanner sc)
    {
    	if(uid==0) {
    		System.out.println("Enter your choice:");
    		while(true) {
    			System.out.println("1 - Perform Operations ");
    			System.out.println("2 - Play game");
    			int ch=sc.nextInt();
    			switch(ch) {
    			case 1:
    				Admin a=new Admin();
    				break;
    			case 2:
    				gameSelection(0,sc);
    				break;
    			default:
    				System.out.println("Enter correct choice");
    				break;
    			}
    			
    		}
    	}
    	else {
        gameSelection(uid,sc);
    	}
    }
    User(int uid, String uname, Scanner sc)
    {
        this.uid=uid;
        this.uname=uname;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/word_waffle","root","Priya@1508");  
            Statement stmt=con.createStatement(); 
            String sql1="insert into user values("+uid+",'"+uname+"')";
             res=stmt.executeUpdate(sql1);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        if(res==1) {
        System.out.println("User Successfully Registered");
        gameSelection(uid, sc);
        }
        else {
        	System.out.println("Duplicate id");
        	App a=new App();
        	a.userRegister();
        }
    }
    private void gameSelection(int uid, Scanner sc)
    {
        while(true)
        {
            System.out.println("Welcome, we have 3 games with us for now.");
            System.out.println("1 - Jumbled Words");
            System.out.println("2 - Riddler");
            System.out.println("3 - Hangman");
            System.out.println("4 - View History");
            System.out.println("Enter your choice or Enter 0 to exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                new JumbledWord();
                break;
                case 2:
                new RiddleG(uid);
                break;
                case 3:
                new Hangman(sc,uid);
                break;
                case 4:
                	getHistory(uid);
                	break;
                case 0:
                System.exit(0);
                default:
                System.out.println("Wrong Input!! Please enter again");
                break;
            }
        }
    }
    private static void getHistory(int uid){
    	try {
    		Connection con=Conn.getInstance();
 	       Statement stmt=con.createStatement();
 	       String sqli="Select * from user_logs where UID_id="+uid+";";
 	       ResultSet rs=stmt.executeQuery(sqli);
 	      while(rs.next()) {
	    	   for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
	               System.out.print(" "+ rs.getObject(i));
	             }
	             System.out.println("");
	       }
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
     
}

