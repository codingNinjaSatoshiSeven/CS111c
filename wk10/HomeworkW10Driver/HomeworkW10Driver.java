import java.util.*;

public class HomeworkW10Driver {

	public static void main(String[] args) {
		Integer[] unsortedNumbers = { 1, 4, 3, 2, 6, 7, 2, 4 };
		Integer[] sortedNumbers = Arrays.copyOf(unsortedNumbers,unsortedNumbers.length);
		Arrays.sort(sortedNumbers);

		// Q7: recursive linear search on unsorted data
		System.out.println("Q7");
		System.out.println("contains 2 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 2));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 4));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 8));
		System.out.println("");
		
		// Q8: recursive linear search on sorted data
		// note: you might want to add additional print statements to make sure
		// that your method is not only returning the correct value, but also
		// taking advantage of the list being sorted
		System.out.println("Q8");
		System.out.println("contains 1 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 1));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 4));
		System.out.println("contains 7 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 7));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearSorted(sortedNumbers, 8));
		System.out.println("");
		
		// Q9: return all indices of the target; recursive
		System.out.println("Q9");		
		ArrayList<Integer> indices;
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(1));
		System.out.println("1 is at [0]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(2));
		System.out.println("2 is at [3, 6]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(4));
		System.out.println("4 is at [1, 7]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(5));
		System.out.println("5 is at []: " + indices.toString());
		System.out.println("");
		
		//Q11 
		SortedLinkedList<Integer> sortedNumList = new SortedLinkedList<Integer>();
		sortedNumList.add(4);
		sortedNumList.add(2);
		sortedNumList.add(1);
		sortedNumList.add(9);
		sortedNumList.add(3);
		sortedNumList.add(7);
		sortedNumList.add(4);
		System.out.println("Q11");
		System.out.println("contains 2 (true): " + sortedNumList.contains(2));
		System.out.println("contains 9 (true): " + sortedNumList.contains(9));
		System.out.println("contains 1 (true): " + sortedNumList.contains(1));
		System.out.println("contains 4 (true): " + sortedNumList.contains(4));
		System.out.println("contains 11 (false): " + sortedNumList.contains(11));
		System.out.println("contains 5 (false): " + sortedNumList.contains(5));
		SortedLinkedList<String> sortedWordList = new SortedLinkedList<String>();
		sortedWordList.add("plum");
		sortedWordList.add("apple");
		sortedWordList.add("grapes");
		sortedWordList.add("banana");
		sortedWordList.add("plum");
		sortedWordList.add("tomato");
		sortedWordList.add("pear");
		System.out.println("contains tomato (true): " + sortedWordList.contains("tomato"));
		System.out.println("contains banana (true): " + sortedWordList.contains("banana"));
		System.out.println("contains orange (false): " + sortedWordList.contains("orange"));
		System.out.println("");
		System.out.println("the mode is 4 " + getMode(sortedNumList));
		sortedNumList.remove(4);
		System.out.println("the mode is 1 " + getMode(sortedNumList));
		sortedNumList.add(7);
		System.out.println("the mode is 7 " + getMode(sortedNumList));
		sortedNumList.add(7);
		System.out.println("the mode is 7 " + getMode(sortedNumList));
		SortedLinkedList<Integer> emptyList = new SortedLinkedList<Integer>();
		System.out.println("the mode is 0 " + getMode(emptyList));
		emptyList.add(2);
		System.out.println("the mode is 2 " + getMode(emptyList));
		emptyList.add(2);
		emptyList.add(3);
		emptyList.add(3);
		emptyList.add(3);
		System.out.println("the mode is 3 " + getMode(emptyList));
	}

	// Q7
	public static boolean searchRecursiveLinearFromLast(Object[] array,
			Object target) {
		return search(array, 0, array.length-1, target);
	}

	private static boolean search(Object[] array, int first, int last, Object target)
	{
		boolean found;
		if (first > last){
			found = false; // no elements to search
		} else if (target.equals(array[last])){
			found = true;
		} else {
			found = search(array, first, last-1, target);
		}
		return found;
	} // end search


	// Q8
	public static boolean searchRecursiveLinearSorted(Comparable[] array,
			Comparable target) {
		return recursiveLinearSorted (array, 0, array.length-1, target);
	}

	private static boolean recursiveLinearSorted(Comparable[] array, int first, int last, Comparable target){
		boolean found;
		if (first > last){
			found = false; 
		} else if (target.equals(array[first])){
			found = true;
		} else if (target.compareTo(array[first]) < 0 || target.compareTo(array[last]) > 0){
			found = false;
		} else {
			found = recursiveLinearSorted(array, first+1, last, target);
		}
		return found;
	}

	// Q9
	public static ArrayList<Integer> findIndicesUnsorted(Object[] array,
			Object target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=0;i <array.length; i++){
			if (array[i].equals(target)){
				result.add(i);
			}
		}
		return result;
	}

	// Extra
	public static int getMode(SortedListInterface<Integer> sList){
		int size = sList.getLength();
		if (size<1){
			return 0;
		}
		int currentMode = sList.getEntry(1);
		int mode = currentMode;
		int currentStrike =1, longestStrike = 1;
		if (size ==1){
			return mode;
		}
		for (int i=2; i<=size; i++){
			int current = sList.getEntry(i);
			if (current != currentMode){
				currentStrike =1; 
				currentMode = current;
			} else {
				currentMode = current; 
				currentStrike +=1; 
				if (currentStrike > longestStrike){
					mode = currentMode;
					longestStrike = currentStrike;
				}
			}
		}
		return mode;
	}


	

}

