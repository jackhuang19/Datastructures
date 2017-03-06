import java.util.*;

public class MissionairesAndCannibals {
	
	public static final int COUNT = 3;  // number of missionaries and cannibals

	public static void main(String[] args) {
		/* ArrayList stores the combination that leads to the solution
		 * Set stores every move that the algorithm performs
		 * Each time a move is successful in the combo ArrayList, it is removed				 
		 * from the set.
		 */
		List<String> combo = new ArrayList<String>();
		Set<String> tried = new HashSet<String>();

		System.out.println("This is the Missionaries and Cannibals Problem");
		System.out.println("This will display the sets of moves required to transfer three cannibals and three missionaries across the river");
		System.out.println();
		System.out.println("Order of moves : ");
		System.out.println();
		//store the original base state
		String base = render(COUNT, COUNT, true);
		combo.add(base);
		tried.add(base);
		//initiate explore method and print out each move state
		if (explore(COUNT, COUNT, true, combo, tried)) {
			for (String s : combo) {
				System.out.println(s);
				System.out.println();
			}
		}
		else {
			//unsolvable if all branches don't lead to a solution
			System.out.println("Unsolvable");
		}
		System.out.println("Possibilities tried = " + tried.size());
	}
	
	//checks to see if there are enough people on each bank to be transfered
    public static boolean isValid(int leftM, int leftC) {
        return (leftM >= 0 && leftM <= COUNT && leftC >= 0 && leftC <= COUNT
        		&& (leftM == 0 || leftM >= leftC) && (leftM == COUNT || (COUNT - leftM) >= (COUNT - leftC)));
    }

    //Data structure goes through and records the different moves that have been completed and records into sets
    public static boolean explore(int leftM, int leftC, boolean leftBank, List<String> combo, Set<String> tried) {
		//check to see if case has been solved
		if (leftM == 0 && leftC == 0 && !leftBank) {
            return true;
        }
		//if not solved then try branches, attempt five combinations
		else {
            if (transfer(leftM, leftC, 1, 0, leftBank, combo, tried)) {
            	return true;//one missionary
            }
            else if (transfer(leftM, leftC, 0, 1, leftBank, combo, tried)) {
            	return true;//one cannibal
            }
            else if (transfer(leftM, leftC, 1, 1, leftBank, combo, tried)) {
            	return true;//one missionary one cannibal
            }
            else if (transfer(leftM, leftC, 2, 0, leftBank, combo, tried)) {
            	return true;//two missionaries
            }
            else if (transfer(leftM, leftC, 0, 2, leftBank, combo, tried)) {
                return true;//two cannibals
            }
			else {
				//goes back two steps to go on another branch
				combo.remove(combo.size() - 1);
                combo.remove(combo.size() - 1);
                return false;
            }
        }
    }

    //The action method, transfers the count over
    public static boolean transfer(int leftM, int leftC, int boatM, int boatC, boolean leftBank, List<String> combo, Set<String> tried) {
    	//depending on location of boat, transfers onto boat
    	if (leftBank) {
            leftC -= boatC;
			leftM -= boatM;
        }
		else {
            leftC += boatC;
			leftM += boatM;
        }
		//represents move into a string image
        String img = render(leftM, leftC, !leftBank);
       
        if (!isValid(leftM, leftC) || tried.contains(img)) {
            //if the move doesn't work or the move is contained in the list of tried sets, return false
        	return false;
        } 
        else {
        	//add on the image represent it, and add the move and the result into the ArrayList 
            tried.add(img);
            String boat = display(COUNT*2, " ") + "      (" + display(boatM, "M") + display(boatC, "C")  + ")";
            combo.add(boat);
            combo.add(img);
            return explore(leftM, leftC, !leftBank, combo, tried);
        }
    }

    public static String render(int leftM, int leftC, boolean leftBank) {
        String result = display(leftM, "M") + display(leftC, "C") + display(COUNT*2 - (leftM + leftC), "-");
        if (leftBank) {
		//display left bank
            result += "^ (__)           ^";
        }
		else {
		//display right bank
            result += "^           (__) ^";
        }
		//displays location of M and C
        result += display(COUNT - leftM, "M") + display(COUNT - leftC, "C") + display(leftM + leftC, "-");
        return result;
    }
    
	//this method helps to display the number of M and C's in the render
    public static String display(int x, String s) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += s;
        }
        return result;
    }
}
