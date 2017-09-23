import java.util.Arrays;

public class Homework05Driver {

	public static void main(String[] args) {

		// setting up Nodes to test
		
		System.out.println("TESTING NODES");

		Node<Integer> node5 = new Node<Integer>(new Integer(6));
		Node<Integer> node4 = new Node<Integer>(new Integer(4), node5);
		Node<Integer> node3 = new Node<Integer>(new Integer(2), node4);
		Node<Integer> node2 = new Node<Integer>(new Integer(8), node3);
		Node<Integer> node1 = new Node<Integer>(new Integer(3), node2);
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6
		//System.out.println(countEvens(node1));
		/*
		// Q2 determine if divisible
		System.out.println("Are all divisible by 2? false: " + isDivisibleBy(node1, 2));

		node1.data = 4;
		node5.data = 1;
		// sets up the chain 4 -> 8 -> 2 -> 4 -> 1 
		System.out.println("Are all divisible by 2? false: " + isDivisibleBy(node1, 2));
	
		node4.next.data = 6;
		// sets up the chain 4 -> 8 -> 2 -> 4 -> 6 
		System.out.println("Are all divisible by 2? true: " + isDivisibleBy(node1, 2));
		
		// Q3 print every other
		System.out.println("Should print 4, 2, 6");
		printEveryOther(node1);

		node5.next = new Node<Integer>(new Integer(11));
		// sets up the chain 4 -> 8 -> 2 -> 4 -> 6 -> 11
		System.out.println("Should still print 4, 2, 6");
		printEveryOther(node1);
		
		// setting up an LinkedBag to test
		System.out.println("\nTESTING BAG");
		LinkedBag<Integer> numbersBag = new LinkedBag<Integer>();
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		
		// Q4 getMin method
		System.out.println("The min in the bag is 1: " + numbersBag.getMin());
		numbersBag.add(0);
		System.out.println("The bag contains[0, 3, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		System.out.println("The max in the bag is 0: " + numbersBag.getMin());
		*/
		// Q5 union
		/*
		LinkedBag<Integer> firstBag = new LinkedBag<Integer>();
		firstBag.add(8);
		firstBag.add(2);
		firstBag.add(4);
		firstBag.add(5);
		firstBag.add(6);
		firstBag.add(2);
		*/
		/*
		LinkedBag<Integer> secondBag = new LinkedBag<Integer>();
		secondBag.add(3);
		secondBag.add(1);
		secondBag.add(2);
		BagInterface<Integer> unionBag = firstBag.union(secondBag);
		System.out.println("Bag1 contains   [2, 6, 5, 4, 2, 8]  (any order)\n\t\t"
						+ Arrays.toString(firstBag.toArray()));
		System.out.println("Bag2 contains   [2, 1, 3]  (any order)\n\t\t"
						+ Arrays.toString(secondBag.toArray()));
		System.out.println("Union Bag contains [3, 1, 2, 8, 2, 4, 5, 6, 2] (any order) \n\t\t   "
						+ Arrays.toString(unionBag.toArray()));

		// setting up LList to test
		*/
		/*
		System.out.println("\nTESTING LIST");
		LList<String> produceList = new LList<String>();
		String[] stringArray = { "banana", "date", "grape", "eggplant",
				"jicama", "grape" };
		produceList.addAll(stringArray);
		produceList.display();
	  */

		// Q6 addAll method
		//produceList.addAll(stringArray);
		//System.out.println("The list contains[banana, date, grape, eggplant, jicama, grape] \n\t\t "
						//+ Arrays.toString(produceList.toArray()));

		// Q7 getPosition method
		//System.out.println("Position is 1: " + produceList.getPosition("banana"));
		//System.out.println("Position is 3: " + produceList.getPosition("grape"));
		//System.out.println("Position is -1: " + produceList.getPosition("mango"));
		//char arr [] = {'m', 'p', 'q'};
		//recMethod2 (arr, 2); 
		//countDownByInterval(13, 4);
		//countDownByInterval(12, 2);
		//countDownByInterval(5, 1);
		int[] a = {5, 2, 3, 6, 5, 1, 8};
		System.out.println(countOddsInRange(a,1,4));
		System.out.println(countOddsInRange(a,0,6));
		int[] b ={};
		
	}
	
	/**
	 * Print every other node, return nothing
	 * @param firstNode, the first node of the linked chain
	 */
	public static void printEveryOther(Node firstNode) {
		// YOUR CODE HERE
		Node<Integer> currentNode = firstNode;
		boolean toPrint = true;
		while(currentNode !=null){
			if (toPrint ==true){
				System.out.print(currentNode.data);
				if (currentNode.next !=null && currentNode.next.next !=null){
					System.out.print(", ");
				}
			}
			toPrint = !toPrint;
			currentNode = currentNode.next;
		}
		System.out.print("\n");
	}
	/**
	 * Return if a linked chain of int is all divisible by a divisor.
	 * @param Node<Integer> firstNode, the first node of the linked chain
	 * @param divisor, int the divisor
	 * @return true if all divisible, false otherwise
	 */
	public static boolean isDivisibleBy(Node<Integer> firstNode, int divisor) {
		// YOUR CODE HERE
		boolean allDivisible = true;
		Node<Integer> currentNode = firstNode;
		while(currentNode != null){
			allDivisible = currentNode.data % divisor ==0;
			if (allDivisible == false){
				break;
			}
			// else, move to the next node to check
			currentNode = currentNode.next;
		}
		return allDivisible;
	}

	public static int countEvens(Node<Integer> node){
		Node currentNode = node;
		int count =0;
		do {
			if (((int)currentNode.data) %2 ==0){
				count++;
			}
			currentNode = currentNode.next;
		} while (currentNode!=null);

		return count;
	}
	public static void recMethod2 (char a[], int k) { 
		char c1 = a[1], c2 = a[2]; 
		if (k > 0) { 
			a[k] = 'a'; 
			recMethod2 (a, k-1); 
			System.out.print(c1);
			System.out.print(c2);
		}
	}

	public static void countDownByInterval(int startingPoint, int interval){
		if (startingPoint <=0){
			System.out.println();
			return; // base case
		} else {
			System.out.print(startingPoint+ " ");
			countDownByInterval(startingPoint-interval, interval);
		}
	}

	public static int countOddsInRange(int[] numbers, int start, int end){
		return recCountOddsInRange(numbers, start, end, 0);
	}

	private static int recCountOddsInRange(int[] number, int start, int end, int count){
		if (start > end ){
			return count;
		} else {
			if (number[start] %2==1){
				count++;
			}
			return recCountOddsInRange(number, start+1, end, count);
		}
	}

	

}
