
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Admin 
{
	public static final String A_RED = "\u001B[31m";
    public static final String A_GREEN = "\u001B[32m";
    public static final String A_RESET = "\u001B[0m";
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
            	new User(0,sc);
             	default:
             	System.out.println(A_RED+"Wrong Input!! Please enter again"+A_RESET);
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
			ResultSet rs = stmt.executeQuery("select * from jumbleddata");
			System.out.println("----- Table contains Following Data -----");
			while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
			System.out.println("-------------------------------------------");	
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
	    		System.out.println(A_GREEN+"Added Question and Answer Successfully"+A_RESET);
	    	}
	    	else 
			{
		   		System.out.println(A_RED+"Opps! Couldn't add Question and Answer"+A_RESET);
	    	}
		}
	 	catch(Exception e) 
		{
		 System.out.println(e);
	 	}
 	}
 	private static void AddRiddler() 
	 {
		try
		{  
		   Scanner s=new Scanner(System.in);
	       Connection con=Conn.getInstance();
	       Statement stmt=con.createStatement(); 
		   ResultSet rs = stmt.executeQuery("select * from riddlerddata");
		   System.out.println("----- Table contains Following Data -----");
		   while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
				System.out.println("-------------------------------------------");	
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
	    	   System.out.println(A_GREEN+"Added Question and Answer Successfully"+A_RESET);
	       }
	       else 
		   {
	    	   System.out.println(A_RED+"Opps! Couldn't add Question and Answer"+A_RESET);
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
		   ResultSet rs = stmt.executeQuery("select * from hangmandata");
		   System.out.println("----- Table contains Following Data -----");	
		   while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            } 
				System.out.println("-------------------------------------------");
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       s.nextLine();
	       System.out.println("Enter Question");
	       String Q=s.nextLine();
	       String sqlQ="insert into hangmandata values('"+id+"','"+Q+"');";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println(A_GREEN+"Added Question and Answer Successfully"+A_RESET);
	       }
	       else 
		   {
	    	   System.out.println(A_RED+"Opps! Couldn't add Question and Answer"+A_RESET);
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
			ResultSet rs = stmt.executeQuery("select * from jumbleddata");
			System.out.println("----- Table contains Following Data -----");
			while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
				System.out.println("-------------------------------------------");
	       	System.out.println("Enter id");
	       	int id=s.nextInt();
	       	String sqlQ="delete from jumbleddata where jid="+id+";";
	       	int res=stmt.executeUpdate(sqlQ);
	       	if(res==1) 
		   	{
	    	   System.out.println(A_GREEN+"Deleted Question and Answer Successfully"+A_RESET);
	       	}
	       	else
			{
	    	   System.out.println(A_RED+"Opps! Couldn't delete Question and Answer"+A_RESET);
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
		   ResultSet rs = stmt.executeQuery("select * from riddlerddata");
		   System.out.println("----- Table contains Following Data -----");	
		   while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
				System.out.println("-------------------------------------------");	
		   System.out.println("Enter id");
	       int id=s.nextInt();
	       String sqlQ="delete from riddlerdata where rid="+id+";";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println(A_GREEN+"Deleted Question and Answer Successfully"+A_RESET);
	       }
	       else 
		   {
	    	   System.out.println(A_RED+"Opps! Couldn't delete Question and Answer"+A_RESET);
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
		   ResultSet rs = stmt.executeQuery("select * from hangmandata");
		   System.out.println("----- Table contains Following Data -----");	
		   while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
				System.out.println("-------------------------------------------");
	       System.out.println("Enter id");
	       int id=s.nextInt();
	       String sqlQ="delete from hangmandata where hid="+id+";";
	       int res=stmt.executeUpdate(sqlQ);
	       if(res==1) 
		   {
	    	   System.out.println(A_GREEN+"Deleted Question and Answer Successfully"+A_RESET);
	       }
	       else 
		   {
	    	   System.out.println(A_RED+"Opps! Couldn't delete Question and Answer"+A_RESET);
	       }
	 	}
	 	catch(Exception e) 
		{
		 System.out.println(e);
	 	}
	}
	private static void RemoveUser() {
		try{  
			   Scanner s=new Scanner(System.in);
			   Connection con=Conn.getInstance();
			   Statement stmt=con.createStatement(); 
			   ResultSet rs = stmt.executeQuery("select * from user");
		   	   System.out.println("----- Table contains Following Data -----");	
		       while(rs.next()) 
                {
	    	        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
                    {
	            	    System.out.print(A_GREEN+rs.getObject(i)+" - "+A_RESET);
	                }
	                System.out.println("");
	            }
				System.out.println("-------------------------------------------");
	         
			   System.out.println("Enter User id");
			   int id=s.nextInt();
			   String sql1="delete from hangman where User_uid="+id+";";
			   stmt.executeUpdate(sql1);
			   String sql2="delete from jwords where User_uid="+id+";";
			   stmt.executeUpdate(sql2);
			   String sql3="delete from riddler where User_uid="+id+";";
			   stmt.executeUpdate(sql3);
			   String sql4="delete from user_logs where UID_id="+id+";";
			   stmt.executeUpdate(sql4);
			   String sqlQ="delete from user where uid="+id+";";
			   int res=stmt.executeUpdate(sqlQ);
			   if(res==1) 
			   {
				   System.out.println(A_GREEN+"Deleted User Successfully"+A_RESET);
			   }
			   else 
			   {
				   System.out.println(A_RED+"Opps! Couldn't delete user"+A_RESET);
			   }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}
}
