//package PW;
import java.util.*;
import java.sql.*;
public class JumbledWord {
    int id;
    public static final String A_RED = "\u001B[31m";
    public static final String A_GREEN = "\u001B[32m";
    public static final String A_RESET = "\u001B[0m";
    public JumbledWord(int uid)
    {
        this.id=uid;
        startGame(id);
    }
    public static void startGame(int id)
    {
        int totalScore=0;
        int chances=0;
        int ch=0;
        try{  
         
            Connection c=Conn.getInstance();
             Statement stmt=c.createStatement();  
            System.out.println(A_RESET+"WELCOME TO JUMBLED WORD GAME");
            System.out.println(A_RESET+"TO QUIT ENTER \"QUIT\" IN ANSWER");
            Scanner sc=new Scanner(System.in);
            String words="";
            String answer="";
            String crr=""; 
        String str1="Select jumbleddata_JID from jwords where user_uid="+id+";";
            ResultSet rs1=stmt.executeQuery(str1);
             if(rs1.next()) {
                ch=rs1.getInt(1);
                 }
            else {
                 ch=1;
                 }
                while(chances!=3)
                 {
                ResultSet rs=stmt.executeQuery("select * from jumbleddata where jid= "+ch+";");
                 while(rs.next())
             {
                words=rs.getString(2);
                System.out.print(A_RESET+"QUESTION : ");
                System.out.println(words);
                System.out.println("ENTER YOUR ANSWER : ");
                answer=sc.nextLine();
                if(answer.equalsIgnoreCase("quit"))
                {
                    chances=3;
                     break;
                }
                   crr=rs.getString(3);
                if(answer.equalsIgnoreCase(crr)) {
                 System.out.println(A_GREEN+"WELL DONE! Your answer is CORRECT!!!"+A_RESET);
                 totalScore+=10;
                 System.out.println(A_GREEN+"YOUR CURRENT SCORE : "+totalScore+A_RESET);
                 }
                else {
                 System.out.println(A_RED+"OOPS! Your answer is WRONG"+A_RESET);
                 System.out.println(A_RESET+"THE CORRECT ANSWER IS : "+crr+A_RESET);
                 System.out.println(A_GREEN+"YOUR CURRENT SCORE IS : "+totalScore+A_RESET);
                 chances+=1;
                 if(chances==3) break;
                 else System.out.println(A_RESET+"You left with "+(3-chances)+" chances");
                 }
             if(chances==3)   break;
             
            if(ch!=8)  ch=ch+1;
              else ch=0;
            }
        }
            System.out.println(A_RED+"GAME OVER"+A_RESET);
            System.out.println(A_GREEN+"YOUR TOTAL SCORE IS : "+totalScore+A_RESET);
        
            String str="Select user_uid , Tscore from jwords where user_uid="+id+";";

	   ResultSet temp=stmt.executeQuery(str);
	   if(temp.next()) {
	   if(temp.getInt(2)<totalScore) {
		   String sql2="update jwords set Tscore="+totalScore+" , JumbledData_JID="+ch+" where user_uid="+id+";";
		   stmt.executeUpdate(sql2);
	   }
	   else
	   {
		   String sql22="update jwords set JumbledData_JID="+ch+" where user_uid="+id+";";
		   stmt.executeUpdate(sql22);
	   }
	   }
	   else {
           System.out.println("Happening");
       
          // stmt.executeUpdate("insert into jwords value('+id+','+totalScore+','+ch+');");
	   String sql1="insert into jwords values("+id+","+totalScore+","+ch+");";
	   stmt.executeUpdate(sql1);
	   }
           c.close();  
            }
            catch(Exception e){ System.out.println(e);
            }
         
          }  
    
           

        }    

    
    
