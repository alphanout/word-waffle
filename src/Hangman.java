package src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Hangman {

    private static String[] words = new String[15];
    private String word = "";
    private String asterisk = "";
    private int count = 0;
    private int id;
    private int played_till;
    private boolean user_exists = false;
    private int score = 0;
    Hangman(Scanner sc, int UID) 
    {
        id = UID;
        play(sc);
    }
    void play(Scanner sc)
    {
        Connection c = Conn.getInstance();
        try 
        {
            Statement st = c.createStatement();
            String str1="Select RiddlerData_RID from riddler where user_uid="+id+";";
            ResultSet rs1=st.executeQuery(str1);
            if(rs1.next()) 
            {
    	        played_till=rs1.getInt(1);
                user_exists = true;
            }
            else
            {
    	        played_till=1;
            }
            ResultSet rs = st.executeQuery("select * from hangmandata");
            int i=0;
            while(rs.next())
            {
                words[i] = rs.getString(2);
                //System.out.println(words[i]);
                i++;
            }
            word = words[(int) (Math.random() * words.length)];
            asterisk = new String(new char[word.length()]).replace("\0", "*");
            hangman_play(st,sc);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    private void hangman_play(Statement st, Scanner sc)
    {
        while (count < 7 && asterisk.contains("*")) 
        {
            System.out.println("--------------Welcome to HANGMAN Game--------------");
            System.out.println("TO QUIT ENTER \"QUIT\" IN ANSWER");
            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);
            String guess = sc.next();
            if(guess.equalsIgnoreCase("quit"))
            {
                break;
            }
            else if (guess.length() != 1)
                System.out.println("Guess only a alphabet, PLEASE :-)");
            else
                hang(guess,st);
        }    
    }
    private void hang(String guess, Statement st) 
    {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == guess.charAt(0)) 
            {
                newasterisk += guess.charAt(0);
            } 
            else if (asterisk.charAt(i) != '*') 
            {
                newasterisk += word.charAt(i);
            } 
            else 
            {
                newasterisk += "*";
            }
        }
        if (asterisk.equals(newasterisk)) 
        {
            count++;
            hangmanImage();
        } 
        else 
        {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) 
        {
            System.out.println("Correct! You win! The word was " + word+" :)");
            score = score+10;
            String str="Select user_uid , Tscore from hangman where user_uid="+id+";";
	        ResultSet temp;
            try 
            {
                temp = st.executeQuery(str);
                if(temp.next()) 
                {
                    if(temp.getInt(2)<score) 
                    {
		                String sql2="update hangman set Tscore="+score+", HangmanData_HID = hangmanData_HID + "+played_till+" where user_uid="+id+";";
		                st.executeUpdate(sql2);
	                }
	                else
	                {
		                String sql22="update hangman set HangmanData_HID = HangmanData_HID + "+played_till+" where user_uid="+id+";";
		                st.executeUpdate(sql22);
	                }
	            }
	            else 
                {
	                String sql1="insert into hangman values("+id+","+score+","+played_till+");";
	                st.executeUpdate(sql1);
	            }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
	        
        }
    }

    private void hangmanImage() 
    {
        if (count == 1) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) 
        {
            System.out.println("Wrong guess, Try Again :(");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) 
        {
            System.out.println("GAME OVER! You have lost :(");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("The Correct Word was -> " + word);
        }
    }
}
