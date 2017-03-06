//Jack Huang, jhuang19@cmc.edu

import java.util.*;

public class SortedIntList extends ArrayIntList {
	boolean isUnique;

	//This constructor should initialize a list of default capacity (10) with uniqueness set to false (duplicates allowed).
	public SortedIntList(){
		this(DEFAULT_CAPACITY);
		setUnique(false);    
		size = 0;
	}
	
	//This constructor should initialize a list of default capacity (10) with uniqueness set to the given value.
	public SortedIntList(boolean unique) {
		this(DEFAULT_CAPACITY);
		setUnique(unique);
		size = 0;
	}
	
	//This constructor should initialize a list with the given capacity and with uniqueness set to false (duplicates allowed)
	//If the capacity is negative, an IllegalArgumentException should occur. ArrayIntList's constructor does so as well.
	public SortedIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Invalid Capacity: " + capacity);
		}
		else {
			elementData = new int[capacity];
			setUnique(false);
			size = 0;
		}
	}
	
	//This constructor should initialize a list with the given capacity and with the given setting for whether or not to limit the
	//list to unique values (true means no duplicates, false means duplicates are allowed). See get/setUnique below.
	//If the capacity is negative, an IllegalArgumentException should occur. ArrayIntList’s constructor does so as well.
	public SortedIntList(boolean unique, int capacity) {
		if (capacity < 0){
			throw new IllegalArgumentException("Invalid Capacity: " + capacity);
		}
		else { 
			elementData = new int[capacity];
		    setUnique(unique);
		    size = 0;
		}
	}
	
	//ensure that elements are added in sorted order
	public void add(int value) {
		//if not unique
		if (getUnique() == false){  
			int index = indexOf(value);
			if ((size + 1) > elementData.length){
				elementData = Arrays.copyOf(elementData, elementData.length+1);
			}
			if (elementData[0] == 0 && elementData[elementData.length-1]==0){
				elementData[0] = value;
			}
			else {
				for(int i = 0; i < elementData.length; i++){
					//if elementData is smaller than the value, shifts it to the right
					if (elementData[i] > value){
						for(int j = elementData.length - 2; j > i; j--){
							elementData[j+1] = elementData[j]; 
						}
						elementData[i] = value;
					}
				}
			}
		}
		else {                      
			//if unique
			if (!contains(value)){  
				//if value isn't in array already
				for(int i = 0; i < elementData.length; i++){
					if (elementData[i] > value){
						for(int j = elementData.length; j > i; j--){
							elementData[j+1] = elementData[j]; 
						}
						elementData[i] = value;
					}
				}
			}
		}
		size++;
	}
	
	@Override
	public void add(int index, int value) {
		throw new UnsupportedOperationException();
	}
	
	//returns whether only unique values are allowed in the list
	public boolean getUnique() {
		return isUnique;
	}
	
	//sets whether only unique values are allowed in the list; if set to
	//true, immediately removes any existing duplicates from the list
	public void setUnique(boolean unique) {
		isUnique = unique;
		if (unique && !isEmpty()){
			for (int i = 0; i < elementData.length; i++){
				if (elementData[i] == elementData[i+1]){
					remove(i);
				}
			}
		}	
	}
	//returns the minimum integer value stored in the list
	//(throws a NoSuchElementException if the list is empty)
	public int min() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return elementData[0];
		}
	}
	//returns the maximum integer value stored in the list
	//(throws a NoSuchElementException if the list is empty)
	public int max() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		else {
			return elementData[size-1];
		}
	}
	
	@Override
	//returns a string version of the list
	public String toString() {
		String arr = "S:[";
		if (size == 0){
			return "[]";
		}
		else {
			for (int i = 0; i < elementData.length; i++){
				if (i == elementData.length - 1){
					arr = arr + elementData[i];
				}
				else{
					arr = arr + elementData[i]+ ", ";
				}
			}
			if (getUnique()){
				arr = arr + "U";
			}
			return arr + "]";
		}
	}
	
	@Override
	//same behavior as before, but optimized;
	//be more efficient by taking advantage of the list’s sorted order
	public int indexOf(int value) {
		return Arrays.binarySearch(elementData, value);
	}
}
