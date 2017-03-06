//Jack Huang, jhuang19@cmc.edu


public class SortedIntListTest {

	public static void main(String[] args) {
		//
		SortedIntList sort1 = new SortedIntList();
			
		System.out.println(sort1.toString());
		sort1.add(-3);
		System.out.println(sort1.toString());
		sort1.add(-3);
		System.out.println(sort1.toString());
		sort1.add(7);
		System.out.println(sort1.toString());
		sort1.add(18);
		System.out.println(sort1.toString());
		sort1.add(42);
		System.out.println(sort1.toString());
		sort1.add(18);
		System.out.println(sort1.toString());
		sort1.add(27);
		System.out.println(sort1.toString());
		
		int index1 = sort1.indexOf(42); // index1 is 4
		System.out.println(index1);
		
		int max = sort1.max();
		System.out.println(max);
				
		System.out.println();
		
		ArrayIntList sort2 = new SortedIntList();
		sort2.add(10);
		sort2.add(0, 1);
		sort2.add(7);
		sort2.add(-3);
		sort2.add(11);
		System.out.println(sort2.toString());
	}
}
