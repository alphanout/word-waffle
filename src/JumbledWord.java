package src;
import java.util.*;
import java.sql.*;
public class JumbledWord {
    public static final String A_RED = "\u001B[31m";
    public static final String A_GREEN = "\u001B[32m";
    public static final String A_RESET = "\u001B[0m";
    public JumbledWord()
    {
        startGame();
    }
    public static void startGame()
    {
        int totalScore=0;
        int chances=0;
        try{  
            //System.out.println("Welcome");
           /* Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/word_waffle","root","mysqladmin");
            */
            Connection c=Conn.getInstance();
             Statement stmt=c.createStatement();  
            System.out.println(" "+A_RESET+ "WELCOME TO JUMBLED WORD GAME");
            System.out.println(" "+A_RESET+ "TO QUIT ENTER \"QUIT\" IN ANSWER");
            Scanner sc=new Scanner(System.in);
            String words="";
            String answer="";
            String crr="";
            ResultSet rs=stmt.executeQuery("select * from jumbleddata");
            while(rs.next()) {
                words=rs.getString(2);
                System.out.print(A_RESET+"QUESTION : ");
                System.out.println(words);
                System.out.println("ENTER YOUR ANSWER : ");
                answer=sc.nextLine();
                   if(answer.equalsIgnoreCase("quit")) break;
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
                 if(chances==3)
                     break;
                 else
                 System.out.println(A_RESET+"You left with "+(3-chances)+" chances");
             }
             if(chances==3) {
                 break;
             }
            }
            System.out.println(A_RED+"GAME OVER"+A_RESET);
            System.out.println(A_GREEN+"YOUR TOTAL SCORE IS : "+totalScore+A_RESET);
        
            c.close();  
            }
            catch(Exception e){ System.out.println(e);
            }
         
          }  
    
           

        }    

    
    

