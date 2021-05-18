package PW;
import java.util.*;
public class RiddleG {
 public RiddleG()
 {
	play();
 }
 public int play() {
	 Scanner sc = new Scanner(System.in);
	 LinkedHashMap<String, String> myMap = new LinkedHashMap<String, String>() {{
	        put("What has to be broken before you can use it?","egg");
	        put("I'm tall when I'm young, and I'm short when I'm old. What am I?","candle");
	        put("What goes up but never comes down?","age");
	        put("What gets wet while drying?","towel");
	        put("What has lots of eyes, but can't see?","potato");
	        put("What has one eye, but can't see?","needle");
	        put("What has hands, but can't clap?","clock");
	        put("What has one head, one foot and four legs?","bed");
	        put("What can you catch, but not throw?","cold");
	        put("What has many teeth, but can't bite?","comb");
	        put("What has words, but never speaks?","book");
	        put("What can travel all around the world without leaving its corner?","stamp");
	        put("What has a thumb and four fingers, but is not a hand?","glove");
	        put("What has a head and a tail but no body?","coin");
	        put("What can't talk but will reply when spoken to?","echo");
	        put("You walk into a room that contains a match, a kerosene lamp, a candle and a fireplace. What would you light first?","match");
	        put("I have branches, but no fruit, trunk or leaves. What am I?","bank");
	        put("What can fill a room but takes up no space?","Light");
	        put("What gets bigger when more is taken away?","hole");
	        put("David's parents have three sons: Snap, Crackle, and what's the name of the third son?","david");
	        put("I follow you all the time and copy your every move, but you can't touch me or catch me. What am I?","shadow");
	        put("What has many keys but can't open a single lock?","piano");
	        put("I turn once, what is out will not get in. I turn again, what is in will not get out. What am I?","key");
	        put("What can you catch but never throw?","cold");
	        put("What word of five letters has one left when two are removed?","Stone");
	        put("What word is pronounced the same if you take away four of its five letters?","Queue");
	        put("People make me, save me, change me, raise me. What am I?","money");
	        put("What goes through cities and fields, but never moves?","road");
	        put("What is full of holes but still holds water?","sponge");
	        put("What is always in front of you but can't be seen?","future");
	        put("A word I know, six letters it contains, remove one letter and 12 remains. What is it?","Dozens");
	        put("I am a word of letters three; add two and fewer there will be. What word am I?","Few");
	        put("I have lakes with no water, mountains with no stone and cities with no buildings. What am I?","map");
	        put("You'll find me in Mercury, Earth, Mars and Jupiter, but not in Venus or Neptune. What am I?","R");
	        put("I am always hungry and will die if not fed, but whatever I touch will soon turn red. What am I?","fire");
	        put("I am a word that begins with the letter 'i.' If you add the letter 'a' to me, I become a new word with a different meaning, but that sounds exactly the same. What word am I?","Isle");
	        put("What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?","river");
	        put("I shave every day, but my beard stays the same. What am I?","barber");
	        put("The more of this there is, the less you see. What is it?","Darkness");
	        put("If you've got me, you want to share me; if you share me, you haven't kept me. What am I?","secret");
	        put("What is black when it's clean and white when it's dirty","chalkboard");
	        put("What begins with an 'e' and only contains one letter?","envelope");
	        put("If you drop me I'm sure to crack, but give me a smile and I'll always smile back. What am I?","mirror");
	        put("The more you take, the more you leave behind. What are they?","Footsteps");
	        put("What invention lets you look right through a wall?","window");
	        put("Where does today come before yesterday?","dictionary");
	        put("With pointed fangs I sit and wait; with piercing force I crunch out fate; grabbing victims, proclaiming might; physically joining with a single bite. What am I?","stapler");
	        put("What can you break, even if you never pick it up or touch it?","promise");
	        put("I make a loud sound when I'm changing. When I do change, I get bigger but weigh less. What am I?","Popcorn");
	        put("It has keys, but no locks. It has space, but no room. You can enter, but can't go inside. What is it?","keyboard");
	        put("What goes away as soon as you talk about it?","Silence");
	        put("What kind of room has no doors or windows?","mushroom");
	        
	      
	    }};
	    System.out.println("WELCOME TO RIDDLER GAME");
	    System.out.println("TO QUIT ENTER \"QUIT\" IN ANSWER");
	    int chance=0,score=0;
	    String question,answer,crtans;
	    	for(Map.Entry<String,String> pair : myMap.entrySet()) {
	    		question=pair.getKey();
	    		System.out.print("QUESTION : ");
	    		System.out.println(question);
	    		System.out.println("ENTER YOUR ANSWER : ");
	    		answer=sc.nextLine();
	    		crtans=pair.getValue();
			if(answer.equalsIgnoreCase("quit"))
	    			break;
	    		if(answer.equalsIgnoreCase(crtans)) {
	    			System.out.println("WELL DONE! Your answer is right! ");
	    			score+=1;
	    			System.out.println("Your current score: "+score);
	    		}
	    		
	    		else {
	    			System.out.println("OOPS! Your answer is wrong");
					System.out.println("The Correct Answer was "+crtans);
	    			System.out.println("Your current score: "+score);
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
	    System.out.println("GAME OVER");
		System.out.println("Your total score is "+score);
		sc.close();
		return score;
		
 }
}
