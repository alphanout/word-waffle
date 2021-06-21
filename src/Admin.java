
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
public class Admin 
{
	Admin()
	{
	  operations();
	}
 	private void operations() 
	 {
	 	Scanner sc=new Scanner(System.in);
	 	System.out.println("Operations to be performed :");
	 	while(true)
     	{
         	System.out.println("1 - Add Question and Answer to Jumbled Words ");
         	System.out.println("2 - Add Question and Answer to Riddler");
         	System.out.println("3 - Add Question and Answer to Hangman");
         	System.out.println("4 - Delete Question and Answer from Jumbled Words");
         	System.out.println("5 - Delete Question and Answer from Riddler");
         	System.out.println("6 - Delete Question and Answer from Hangman");
         	System.out.println("7 - Remove User");
         	System.out.println("0 - Exit from Operation section");
         	int choice = sc.nextInt();
         	sc.nextLine();
         	switch(choice)
         	{
             	case 1:
             	AddJumbles();
             	break;
             	case 2:
             	AddRiddler();
             	break;
             	case 3:
             	AddHangman();
             	break;
             	case 4:
                Removejumbled();
                break;
             	case 5:
                RemoveRiddler();
                break;
             	case 6:
                RemoveHangman();
                break;
            	case 7:
            	RemoveUser();
            	break;
             	case 0:
            	User u=new User(0,sc);
             	default:
             	System.out.println("Wrong Input!! Please enter again");
             	break;
        	}
     	}
 	}
 	private static void AddJumbles() 
		{
		try
		{  
			Scanner s=new Scanner(System.in);
	    	Connection con=Conn.getInstance();
	    	Statement stmt=con.createStatement(); 
	    	System.out.println("Enter id");
	    	int id=s.nextInt();
	    	s.nextLine();
	    	System.out.println("Enter Question");
	    	String Q=s.nextLine();
	    	System.out.println("Enter Answer");
	    	String A=s.nextLine();
	    	String sqlQ="insert into riddlerdata values("+id+",'"+Q+"','"+A+"');";
	    	int res=stmt.executeUpdate(sqlQ);
	    	if(res==1) 
			{
	    		System.out.println("Added Question and Answer Successfully");
	    	}
	    	else 
			{
		   		System.out.println("Opps! Couldn't add Question and Answer");
	    	}
		}
	 	catch(Exception e) 
		{
		 System.out.println(e);
	 	}
 	}
 	private static void AddRiddler() {
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       s.nextLine();
	       System.out.println("Enter Question");
	       String Q=s.nextLine();
	       System.out.println("Enter Answer");
	       String A=s.nextLine();
	       String sqlQ="insert into riddlerdata values("+id+",'"+Q+"','"+A+"');";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println("Added Question and Answer Successfully");
	       }
	       else 
		   {
	    	   System.out.println("Opps! Couldn't add Question and Answer");
	       }
		}
	 	catch(Exception e) 
		{
			System.out.println(e);
	 	}
 	}
	private static void AddHangman() 
	{
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       s.nextLine();
	       System.out.println("Enter Question");
	       String Q=s.nextLine();
	       String sqlQ="insert into hangmandata values('"+id+"','"+Q+"');";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println("Added Question and Answer Successfully");
	       }
	       else 
		   {
	    	   System.out.println("Opps! Couldn't add Question and Answer");
	       }
	 	}
	 	catch(Exception e) 
		 {
		 System.out.println(e);
		}
 	}
	private static void Removejumbled() 
	{
		try
		{  
		   	Scanner s=new Scanner(System.in);
	       	Connection con=Conn.getInstance();
	       	Statement stmt=con.createStatement(); 
	       	System.out.println("Enter id");
	       	int id=s.nextInt();
	       	String sqlQ="delete from jumbleddata where jid="+id+";";
	       	int res=stmt.executeUpdate(sqlQ);
	       	if(res==1) 
		   	{
	    	   System.out.println("Deleted Question and Answer Successfully");
	       	}
	       	else
			{
	    	   System.out.println("Opps! Couldn't delete Question and Answer");
	       	}
	 	}
	 	catch(Exception e) 
		 {
		 System.out.println(e);
	 	}
	}
	private static void RemoveRiddler() 
	{
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       String sqlQ="delete from riddlerdata where rid="+id+";";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println("Deleted Question and Answer Successfully");
	       }
	       else 
		   {
	    	   System.out.println("Opps! Couldn't delete Question and Answer");
	       }
	 	}
	 	catch(Exception e) 
		 {
		 System.out.println(e);
	 	} 
	}
	private static void RemoveHangman() 
	{
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       String sqlQ="delete from hangmandata where hid="+id+";";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println("Deleted Question and Answer Successfully");
	       }
	       else 
		   {
	    	   System.out.println("Opps! Couldn't delete Question and Answer");
	       }
	 	}
	 	catch(Exception e) 
		{
		 System.out.println(e);
	 	}
	}
	private static void RemoveUser() 
	{
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
	       System.out.println("Enter User id");
	       int id=s.nextInt();
	       String sqlQ="delete from user where uid="+id+";";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println("Deleted User Successfully");
	       }
	       else 
		   {
	    	   System.out.println("Opps! Couldn't delete user");
	       }
	 	}
	 	catch(Exception e) 
		{
		 System.out.println(e);
	 	}
	}
}
