package PW;
import java.util.*;
public class JumbledWord {
    public JumbledWord()
    {
        startGame();
    }
    public static void startGame()
    {
        int totalScore=0;
        int chances=3;
        System.out.println("Welcome to Jumbled word game!!");
  
        LinkedHashMap<String,String> words=new LinkedHashMap<>();
        words.put("RAE","ARE");
        words.put("EHT","THE");
        words.put("ANEM","NAME");
        words.put("REAB","BEAR");
        words.put("IFLE","LIFE");
        words.put("MITE","TIME");
        words.put("WLEL","WELL");
        words.put("SHIINF","FINISH");
    
         Scanner sc=new Scanner(System.in);
            int i=0;
            for(String w:words.keySet())
            {
                if(chances==0) break;
       if(i==0)   System.out.println("************Easy Level**********");
       else if(i==2)  System.out.println("************Medium Level**********");
       else if(i==7)    System.out.println("************Hard Level**********");
                System.out.println(w);
                System.out.println("Enter the correct String: ");
                String ans=sc.nextLine();
                if(ans.equalsIgnoreCase(words.get(w)))
                {
                     System.out.println("Welldone!!");
                     totalScore+=10;
                }
                else
                {   
                    System.out.println("Oops Wrong Answer!");
                    chances--;
                }
                i++;
            }
            System.out.println("Your total Score is : "+totalScore);
        
        sc.close();
        }    

    }
    
