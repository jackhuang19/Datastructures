//Jiawei Jack Huang
//jhuang19@cmc.edu
//CS62

import java.io.*;
import java.io.IOException;
import java.util.*;

public class arrangeNames {

	public static void main(String[] args) throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		
		//Buffered Reader grabs the whole file and reads the file
		//this makes it more efficient than using a file reader 
		BufferedReader br = new BufferedReader(new FileReader("names.txt"));
		
		//create a string to be a temp holder for each name on each line
		String line;
		//stores each name into a string and put it into index in the ArrayList
		while((line = br.readLine()) !=null) {
			names.add(line);
		}
		//closes the Buffered Reader
		br.close();
		
		//calls the mergeSort method to merge sort the names ArrayList
		mergeSort(names);
		
		//iterates through and prints out the names in sorted order
		for (int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
	    }
		
	}
	
	//Merge sort the list of names using the merge method
    public static ArrayList<String> mergeSort(ArrayList<String> result) {
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        int center;
        
        //base case if there is only one element in arraylist
        if ( result.size() == 1 ) {    
            return result;
        } 
        else {
            center = result.size()/2;
            // copy the left half of result into the left.
            for ( int i = 0; i < center; i++ ) {
                    left.add(result.get(i));
            }
 
            //copy the right half of result into the new arraylist.
            for ( int i = center; i < result.size(); i++ ) {
                    right.add(result.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            // Merge the results back together.
            merge(left, right, result);
        }
        return result;
    }
    
    // Merges the given left and right arrays into the given 
    // result array.  Second, working version.
    // pre : result is empty; left/right are sorted
    // post: result contains result of merging sorted lists;
    public static void merge( ArrayList<String> left, ArrayList<String> right, ArrayList<String> result) {
    	int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
     
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
        	//This call figures out if the left is above or below the right, ignoring the cases of the letters
            if ( (left.get(leftIndex).compareToIgnoreCase(right.get(rightIndex))) < 0) {
                result.set(resultIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                result.set(resultIndex, right.get(rightIndex));
                rightIndex++;
            }
            resultIndex++;
        }
        
        
        ArrayList<String> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // Check if the left ArrayList is full
            rest = right;
            restIndex = rightIndex;
        } else {
            // otherwise fill up the right one
            rest = left;
            restIndex = leftIndex;
        }
     
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            result.set(resultIndex, rest.get(i));
            resultIndex++;
        }
    }
}
