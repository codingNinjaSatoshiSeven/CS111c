import java.util.Arrays;

public class Homework04Driver {

	public static void main(String[] args) {

			
		// setting up an ArrayBag to test
		
		System.out.println("TESTING BAG");
		ArrayBag<Integer> numbersBag = new ArrayBag<Integer>();
		/*
		numbersBag.add(8);
		numbersBag.add(9);
		numbersBag.add(6);
		numbersBag.add(3);
		numbersBag.add(8);
		numbersBag.add(6);
		numbersBag.add(1);
		*/
		System.out.println(numbersBag.getSomeEntry());
		/*
		System.out.println(counterGreaterThan( numbersBag, 3));
		System.out.println(Arrays.toString(numbersBag.toArray()));
		*/
		/*
		AList<String> list = new AList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(containsExactlyOnce( list, "a")); // false
		System.out.println(containsExactlyOnce( list, "b")); // true
		System.out.println(containsExactlyOnce( list, "d")); // false
		*/
		/*
		// Q3 replace method
		// NOTE: The description does not specify that you must replace the last
		// element in the array, so your output might be different- that's okay
		System.out.println("\n***Q3***");
		numbersBag.replace(6);
		System.out.println("The bag contains[1, 2, 1, 4, 6] \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		numbersBag.replace(8);
		System.out.println("The bag contains[1, 2, 1, 4, 8] \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q4 removeEvery method
		// NOTE: bags are unordered, so the order of your array might be
		// different- that's okay as long as the contents match what is listed below
		System.out.println("\n***Q4***");
		numbersBag.add(1);
		numbersBag.removeEvery(1);
		System.out.println("The bag contains[8, 2, 4] (any order) \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		numbersBag.removeEvery(3);
		System.out.println("The bag contains[8, 2, 4] (any order) \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q5: union
		System.out.println("\n***Q5***");
		ResizableArrayBag<Integer> firstResizableBag = new ResizableArrayBag<Integer>();
		firstResizableBag.add(8);
		firstResizableBag.add(2);
		firstResizableBag.add(4);
		firstResizableBag.add(5);
		firstResizableBag.add(6);
		firstResizableBag.add(2);
		ResizableArrayBag<Integer> secondResizableBag = new ResizableArrayBag<Integer>();
		secondResizableBag.add(3);
		secondResizableBag.add(1);
		secondResizableBag.add(2);
		BagInterface<Integer> unionBag = firstResizableBag
				.union(secondResizableBag);
		System.out.println("Bag1 contains   [8, 2, 4, 5, 6, 2] \n\t\t"
				+ Arrays.toString(firstResizableBag.toArray()));
		System.out.println("Bag2 contains   [3, 1, 2] \n\t\t"
				+ Arrays.toString(secondResizableBag.toArray()));
		System.out.println("Union Bag contains [8, 2, 4, 5, 6, 2, 3, 1, 2] (any order) \n\t\t   "
						+ Arrays.toString(unionBag.toArray()));

		// Q6: intersection
		System.out.println("\n***Q6***");
		firstResizableBag.add(2);
		secondResizableBag.add(2);
		secondResizableBag.add(4);
		BagInterface<Integer> intersectionBag = firstResizableBag.intersection(secondResizableBag);
		System.out.println("Bag1 contains   [8, 2, 4, 5, 6, 2, 2] \n\t\t"
				+ Arrays.toString(firstResizableBag.toArray()));
		System.out.println("Bag2 contains   [3, 1, 2, 2, 4] \n\t\t"
				+ Arrays.toString(secondResizableBag.toArray()));
		System.out.println("Intersection Bag contains [2, 4, 2] (any order) \n\t\t   "
				+ Arrays.toString(intersectionBag.toArray()));

		// setting up AList to test
		System.out.println("\nTESTING LIST");
		AList<String> produceList = new AList<String>();
		produceList.add("banana");
		produceList.add("date");
		produceList.add("grape");
		produceList.add("eggplant");
		produceList.add("jicama");
		produceList.add("grape");

		// Q7: getPosition
		// Note: this driver assumes you return -1 if an element is not in the list;
		// it would also be valid to throw an exception
		System.out.println("\n***Q7***");
		System.out.println("Position is 1: " + produceList.getPosition("banana"));
		System.out.println("Position is 3: " + produceList.getPosition("grape"));
		System.out.println("Position is -1: " + produceList.getPosition("mango"));

		//Q8: moveToBeginning
      	System.out.println("\n***Q8***");
		System.out.println("List contains [banana, date, grape, eggplant, jicama, grape] \n\t\t   "
						+ Arrays.toString(produceList.toArray()));
		produceList.moveToBeginning();
		System.out.println("List contains [grape, banana, date, grape, eggplant, jicama] \n\t\t   "
				+ Arrays.toString(produceList.toArray()));
		produceList.clear();
		produceList.moveToBeginning();
		System.out.println("List contains [] \n\t\t   "
				+ Arrays.toString(produceList.toArray()));
		
		// Q9: equals
		System.out.println("\n***Q9***");
		produceList.add("banana");
		produceList.add("potato");
		produceList.add("jicama");
		produceList.add("grape");
		AList<String> foodList = new AList<String>();
		foodList.add("banana");
		foodList.add("potato");
		foodList.add("jicama");
		System.out.println("Result is false: " + produceList.equals(foodList));
		foodList.add("grape");
		System.out.println("Result is true: " + produceList.equals(foodList));
		foodList.add("squash");
		System.out.println("Result is false: " + produceList.equals(foodList));
		foodList.replace(1, "jicama");
		foodList.replace(3, "banana");
		System.out.println("Result is false: " + produceList.equals(foodList));
		System.out.println("The list contains[banana, potato, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("The second list contains[jicama, potato, banana, grape, squash] \n\t\t\t"
						+ Arrays.toString(foodList.toArray()));

		
		
		System.out.println("\nTESTING EXTRA CREDIT");
		AList<Integer> numberListA = new AList<Integer>();
		numberListA.add(1);
		numberListA.add(5);
		numberListA.add(6);
		numberListA.add(8);
		numberListA.add(10);
		AList<Integer> numberListB = new AList<Integer>();
		numberListB.add(2);
		numberListB.add(4);
		numberListB.add(3);
		numberListB.add(9);
		numberListB.add(7);		
		System.out.println("List B is smaller, result should be positive: " + numberListA.compareTo(numberListB));
		numberListA.remove(1);
		System.out.println("List A is smaller, result should be negative: " + numberListA.compareTo(numberListB));
		
		numberListA.clear();
		numberListA.add(1);
		numberListA.add(3);
		numberListA.add(5);
		numberListA.add(7);
		numberListA.add(10);
		numberListB.clear();
		numberListB.add(2);
		numberListB.add(4);
		numberListB.add(3);
		numberListB.add(9);
		numberListB.add(7);		
		System.out.println("List A is smaller, result should be negative: " + numberListA.compareTo(numberListB));
		numberListB.remove(1);
		System.out.println("List B is smaller, result should be positive: " + numberListA.compareTo(numberListB));
		
		numberListA.clear();
		numberListA.add(1);
		numberListA.add(2);
		numberListA.add(3);
		numberListA.add(10);
		numberListA.add(9);
		numberListB.clear();
		numberListB.add(2);
		numberListB.add(4);
		numberListB.add(3);
		numberListB.add(9);
		numberListB.add(7);		
		System.out.println("Neither List A nor List B is smaller, result should be zero: " + numberListA.compareTo(numberListB));
		*/

	}

	public static int counterGreaterThan(BagInterface<Integer> bag, int number){
		int count =0, index = 0, size = bag.getCurrentSize();
		int[] temp = new int[size];
		while (!bag.isEmpty()){
			int num = bag.remove();
			if (num > number){
				count++;
			}
			temp[index]=num;
			index++;
		}
		index = size-1;
		while (index >=0){
			int num = temp[index];
			bag.add(num);
			index--;
		}
		return count;
	}

	public static boolean containsExactlyOnce(ListInterface<String> list, String entry){
		int index = 1, size = list.getLength(), count =0;
		while (index <=size){
			if (list.getEntry(index).equals(entry)){
				count++;
			}
			if (count >=2){
				break;
			}
			index++;
		}
		return count ==1 ? true: false;
	}

}
