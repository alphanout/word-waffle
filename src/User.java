import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class User {
    int uid;
    String uname;
    int res;
    public static final String A_RED = "\u001B[31m";
    public static final String A_GREEN = "\u001B[32m";
    public static final String A_RESET = "\u001B[0m";
    User(int uid, Scanner sc)
    {
    	if(uid==0) {
    		System.out.println("Enter your choice:");
    		while(true) {
    			System.out.println("1 - Perform Operations ");
    			System.out.println("2 - Play game");
    			System.out.println("3 - Logout");
    			int ch=sc.nextInt();
    			switch(ch) {
    			case 1:
    				new Admin();
    				break;
    			case 2:
    				gameSelection(0,sc);
    				break;
    			case 3:
				System.out.println(A_GREEN+"Thank you for playing the game"+A_RESET);
    				App z=new App();
    				z.userRegister();
    				break;
    			default:
    				System.out.println("Enter correct choice");
    				break;
    			}
    		}
    	}
    	else {
        gameSelection(uid,sc);
        System.out.println(A_GREEN+"Thank you for playing the game"+A_RESET);
        App az=new App();
        az.userRegister();
    	}
    }
    User(int uid, String uname, Scanner sc)
    {
        this.uid=uid;
        this.uname=uname;
        
        try {
        	Connection con = Conn.getInstance();
            Statement stmt=con.createStatement(); 
            String sql1="insert into user values("+uid+",'"+uname+"')";
             res=stmt.executeUpdate(sql1);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        if(res==1) {
        System.out.println(A_GREEN+"User Successfully Registered"+A_RESET);
        gameSelection(uid, sc);
        }
        else {
        	System.out.println(A_RED+"Duplicate id"+A_RESET);
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
            System.out.println("5 - View Leader_Board");
            System.out.println("6 - LOGOUT");
            System.out.println("Enter your choice or Enter 0 to exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                new JumbledWord(uid);
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
                case 5:
                this.getleaderboard(uid, sc);
                case 0:
                System.exit(0);
                case 6:
                App a = new App();
                a.userRegister();
                default:
                System.out.println(A_RED+"Wrong Input!! Please enter again"+A_RESET);
                break;
            }
            if(choice==5)
            	break;
        }
    }
    private static void getHistory(int uid)
    {
    	
    		try 
            {
        		Connection con=Conn.getInstance();
     	        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     	        String sqli="Select * from user_logs where U_id="+uid+";";
     	        ResultSet rs=stmt.executeQuery(sqli);
                if(rs.next())
                {
                        rs.previous();
                        System.out.println("U_ID --- Total-Score --- Date/Time --- Game Name ");  
                        while(rs.next())
                        {
                        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                        {
    	                System.out.print(A_GREEN+rs.getObject(i)+" --- ");
    	                }
    	                System.out.println(""+A_RESET);
                        }
                }
                else
                {
                    System.out.println(A_RED+"No History Available!! Play some games first."+A_RESET);
                }
        	}
        	catch(Exception e) 
            {
        		System.out.println(e);
        	}
    }
    private void getleaderboard(int uid, Scanner sc)
    {
        try 
            {
        		Connection con=Conn.getInstance();
     	        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                System.out.println("Enter 1 for Jumbled_Words");
                System.out.println("Enter 2 for Riddler");
                System.out.println("Enter 3 for Hangman");
                int choice = sc.nextInt();
                String sqli="";
                switch(choice)
                {
                    case 1:
                    sqli="call leader_board('jwords')";
                    break;
                    case 2:
                    sqli="call leader_board('riddler')";
                    break;
                    case 3:
                    sqli="call leader_board('hangman')";
                    break; 
                }
                ResultSet rs=stmt.executeQuery(sqli);
                if(rs.next())
                {
                    System.out.println("U_ID ------ U_Name --- Score");  
                    while(rs.next()) 
                    {
    	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                        {
    	                System.out.print(A_GREEN+rs.getObject(i)+" --- ");
    	                }
    	                System.out.println(""+A_RESET);
    	            }
                }
                else
                {
                    System.out.println(A_RED+"LeaderBoard Unavailable, Try later !"+A_RESET);
                }
        	}

        	catch(Exception e) 
            {
        		System.out.println(e);
        	}
            gameSelection(uid, sc);
    }
     
}

