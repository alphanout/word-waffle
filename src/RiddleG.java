import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class RiddleG {
		int id;
       RiddleG(int uid){
    	    id=uid;
    	  play(id);
       }
    public void play(int id) {
      int chance=0;
       int score=0;
 	  
 	   String question,answer,crtans;
       try{  
       Connection con=Conn.getInstance();
       Statement stmt=con.createStatement();  
       System.out.println("WELCOME TO RIDDLER GAME");
       System.out.println("TO QUIT ENTER \"QUIT\" IN ANSWER");
       Scanner sc=new Scanner(System.in);
        int c;
        String str1="Select RiddlerData_RID from riddler where user_uid="+id+";";
        ResultSet rs1=stmt.executeQuery(str1);
       if(rs1.next()) {
    	   c=rs1.getInt(1);
       }
       else {
    	   c=1;
       }
       while(chance!=3) {
       ResultSet rs=stmt.executeQuery("select * from Riddlerdata where rid= "+c+";");
       while(rs.next()) {
    	   question=rs.getString(2);
    	   System.out.print("QUESTION : ");
           System.out.println(question);
           System.out.println("ENTER YOUR ANSWER : ");
           answer=sc.nextLine();
   		   if(answer.equalsIgnoreCase("quit")) {
   			   chance=3;
   			break;}
   		   crtans=rs.getString(3);
   		if(answer.equalsIgnoreCase(crtans)) {
			System.out.println("WELL DONE! Your answer is CORRECT!!!");
			score+=1;
			System.out.println("YOUR CURRENT SCORE : "+score);
		}
   		else {
			System.out.println("OOPS! Your answer is WRONG");
			System.out.println("THE CORRECT ANSWER IS : "+crtans);
			System.out.println("YOUR CURRENT SCORE IS : "+score);
			chance+=1;
			if(chance==3)
				break;
			else
			System.out.println("Your left with "+(3-chance)+" chances");
		}
		if(chance==3) {
			break;
		}
       }
       if(c!=100)
       {c=c+1;}
       else
    	   c=0;
       }
       System.out.println("GAME OVER");
	   System.out.println("YOUR TOTAL SCORE IS : "+score);
	   String str="Select user_uid , Tscore from riddler where user_uid="+id+";";
	   ResultSet temp=stmt.executeQuery(str);
	   if(temp.next()) {
	   if(temp.getInt(2)<score) {
		   String sql2="update riddler set Tscore="+score+" , RiddlerData_RID="+c+" where user_uid="+id+";";
		   stmt.executeUpdate(sql2);
	   }
	   else
	   {
		   String sql22="update riddler set RiddlerData_RID="+c+" where user_uid="+id+";";
		   stmt.executeUpdate(sql22);
	   }
	   }
	   else {
	   String sql1="insert into riddler values("+id+","+score+","+c+");";
	   stmt.executeUpdate(sql1);
	   }  
       }
       catch(Exception e){ System.out.println(e);}
	    
     }  
}
