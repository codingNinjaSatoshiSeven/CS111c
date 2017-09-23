
public class HomeworkW08Driver {

	public static void main(String[] args) {
		Integer[] sortedNumbers1 = {2, 5, 7, 9, 13, 15, 18};
		Integer[] sortedNumbers2 = {2, 3, 4, 5, 6, 7, 8};
		Integer[] sortedNumbers3 = {2, 3, 4, 5, 6, 7, 7};
		Integer[] sortedNumbers4 = {2, 2, 2, 2, 2, 2};
		Integer[] sortedNumbers5 = {};
	
		Integer[] unsortedNumbers1 = {8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] unsortedNumbers2 = {2, 9, 7, 13, 18, 15, 4};
		Integer[] unsortedNumbers3 = {2, 3, 4, 5, 6, 7, 6};
		
		String[] sortedWords1 = {"apple", "banana", "carrot", "durian"};
		String[] unsortedWords1 = {"zebra", "hippo", "gorilla", "elephant"};
		
		System.out.println("**********Array Method Test");
		System.out.println("Sorted numbers 1 sorted? " + isSortedAscending(sortedNumbers1));
		System.out.println("Sorted numbers 2 sorted? " + isSortedAscending(sortedNumbers2));
		System.out.println("Sorted numbers 3 sorted? " + isSortedAscending(sortedNumbers3));
		System.out.println("Sorted numbers 4 sorted? " + isSortedAscending(sortedNumbers4));
		System.out.println("Sorted numbers 5 sorted? " + isSortedAscending(sortedNumbers5));
		
		System.out.println("Unsorted numbers 1 sorted? " + isSortedAscending(unsortedNumbers1));
		System.out.println("Unsorted numbers 1 sorted? " + isSortedAscending(unsortedNumbers2));
		System.out.println("Unsorted numbers 1 sorted? " + isSortedAscending(unsortedNumbers3));
		
		System.out.println("Sorted words 1 sorted? " + isSortedAscending(sortedWords1));
		System.out.println("Unsorted nwordsumbers 1 sorted? " + isSortedAscending(unsortedWords1));
		
		// this code uses the same values as the arrays above
		Node<Comparable> sortedChain1 = new Node<Comparable>(2, new Node<Comparable>(5, new Node<Comparable>(7,
				new Node<Comparable>(9, new Node<Comparable>(13, new Node<Comparable>(15, 
				new Node<Comparable>(18)))))));
		Node<Comparable> sortedChain2 = new Node<Comparable>(2, new Node<Comparable>(3, new Node<Comparable>(4,
				new Node<Comparable>(5, new Node<Comparable>(6, new Node<Comparable>(7, 
				new Node<Comparable>(8)))))));
		Node<Comparable> sortedChain3 = new Node<Comparable>(2, new Node<Comparable>(3, new Node<Comparable>(4,
				new Node<Comparable>(5, new Node<Comparable>(6, new Node<Comparable>(7, 
				new Node<Comparable>(7)))))));
		Node<Comparable> sortedChain4 = new Node<Comparable>(2, new Node<Comparable>(2, new Node<Comparable>(2,
				new Node<Comparable>(2, new Node<Comparable>(2, new Node<Comparable>(2, 
				new Node<Comparable>(2)))))));
		Node<Comparable> sortedChain5 = null; // empty chain

		Node<Comparable> unsortedChain1 = new Node<Comparable>(8, new Node<Comparable>(7, new Node<Comparable>(6,
				new Node<Comparable>(5, new Node<Comparable>(4, new Node<Comparable>(3, 
				new Node<Comparable>(2, new Node<Comparable>(1))))))));
		Node<Comparable> unsortedChain2 = new Node<Comparable>(2, new Node<Comparable>(9, new Node<Comparable>(7,
				new Node<Comparable>(13, new Node<Comparable>(18, new Node<Comparable>(15, 
				new Node<Comparable>(4)))))));
		Node<Comparable> unsortedChain3 = new Node<Comparable>(2, new Node<Comparable>(3, new Node<Comparable>(4,
				new Node<Comparable>(5, new Node<Comparable>(6, new Node<Comparable>(7, 
				new Node<Comparable>(6)))))));
		
		Node<Comparable> sortedWordChain1 = new Node<Comparable>("apple", new Node<Comparable>("banana",
				new Node<Comparable>("carrot", new Node<Comparable>("durian"))));
		Node<Comparable> unSortedWordChain1 = new Node<Comparable>("zebra", new Node<Comparable>("hippo",
				new Node<Comparable>("gorilla", new Node<Comparable>("elephant"))));
		
		System.out.println("\n\n**********Linked Nodes Method Test");
		System.out.println("Sorted numbers 1 sorted? " + isSortedAscending(sortedChain1));
		System.out.println("Sorted numbers 2 sorted? " + isSortedAscending(sortedChain2));
		System.out.println("Sorted numbers 3 sorted? " + isSortedAscending(sortedChain3));
		System.out.println("Sorted numbers 4 sorted? " + isSortedAscending(sortedChain4));
		System.out.println("Sorted numbers 5 sorted? " + isSortedAscending(sortedChain5));
		
		System.out.println("Unsorted numbers 1 sorted? " + isSortedAscending(unsortedChain1));
		System.out.println("Unsorted numbers 2 sorted? " + isSortedAscending(unsortedChain2));
		System.out.println("Unsorted numbers 3 sorted? " + isSortedAscending(unsortedChain3));
		
		System.out.println("Sorted words 1 sorted? " + isSortedAscending(sortedWordChain1));
		System.out.println("Unsorted words 1 sorted? " + isSortedAscending(unSortedWordChain1));
		
	}
	
	public static boolean isSortedAscending(Comparable[] array) {
		 for (int i=0; i< array.length-1; i++){
		 	if (array[i].compareTo(array[i+1]) >0) {
		 		return false;
		 	}
		 }
		 return true;
	}
	
	public static boolean isSortedAscending(Node<Comparable> node) {
    	Node currentNode = node;
    	while (currentNode  !=null) {
    		if (currentNode.next !=null) {
    			if (currentNode.data.compareTo(currentNode.next.data) >0) {
    				return false;
    			}
    		}
    		currentNode = currentNode.next;
    	}
    	return true;
	}


}
