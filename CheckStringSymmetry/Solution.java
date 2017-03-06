//Jiawei Jack Huang
//jhuang19@cmc.edu

import java.util.*;

public class legal {
	
	public static void main (String [] args) {		
//		Scanner object scans user input, and puts it into a string
//		The next four lines can be used for a user input to test strings
		
//		Scanner sc = new Scanner(System.in);
//	    System.out.println("Enter your text:");
//	    String s = sc.next();
//		compare(s);
	    
		//calls the compare method of the given strings
	    compare("babacbmbcabab");
	    compare("abamba");
	    compare("abmmba");
	    compare("dbamabd");
	}
	
	public static void compare (String s) {
	    boolean result = false;
	    
	    //automatically disregards any string that has doesnt have an odd number of Chars 
	    //in other words: the m in the middle would make the palindrome series of numbers even 
		if (s.length()%2 == 0) {
			System.out.println(result);
		}
		else{ 
			//create two stacks, Left one stores the left half and the right one stores left half
			Stack<Character> Left = new Stack<Character>();
			Stack<Character> Right = new Stack<Character>();
			
			//iterates through the string and pushes each char of the string into 
			for (int i = 0; i < s.length(); i++) {
				Left.push(s.charAt(i));
			}

			//uses a count to pop the top half of the left stack to the right stack, until the central m
			int count = 0;
			while (count < s.length()/2) {	    	
				char temp = Left.pop();
				Right.push(temp);
				count ++;
			}

			//pops m off the Left stack
			Left.pop(); 
			
			//compares each char in each index
			while (!Left.isEmpty() && !Right.isEmpty()) {
				char pL = Left.pop();
				char pR = Right.pop();
				if ((pL == pR) && legalLetter(pL) && legalLetter(pR)) {
					result = true;
				}
				else {
					result = false;
				}
			}
			System.out.println(result);
		}
	}
	
	//This method checks if this is a legal 
	public static boolean legalLetter (char c) {
		if (c == 'a' ||c == 'b' || c == 'c') {
			return true;
		}
		else {
			return false;
		}
	}
}
