import java.util.*;

public class HomeworkW07Driver {

	public static void main(String[] args) {


		// Q1 and Q2
		String s = "stressed";
		System.out.print(s + " backwards is desserts");
		printBackwards1(s);
		System.out.println();
		
		System.out.print(s + " backwards is still desserts");
		printBackwards2(s);
		System.out.println();
		
		s = "";
		System.out.print("the empty string backwards is empty " );
		printBackwards1(s);
		System.out.println();
		System.out.print("the empty string backwards is still empty " );
		printBackwards2(s);
		System.out.println();
		
		// Q3
		String p = "anna";
		System.out.println(p + " is a palindrome? true!" + isPalindrome(p));
		p = "ana";
		System.out.println(p + " is a palindrome? true!" + isPalindrome(p));
		p = "a";
		System.out.println(p + " is a palindrome? true!" + isPalindrome(p));
		p = "amanaplanacanalpanama";
		System.out.println(p + " is a palindrome? true!" + isPalindrome(p));
		p = "ababb";
		System.out.println(p + " is a palindrome? false!" + isPalindrome(p));
		p = "ab";
		System.out.println(p + " is a palindrome? false!" + isPalindrome(p));
		p = "abca";
		System.out.println(p + " is a palindrome? false!" + isPalindrome(p));
		
		// Q4
		System.out.println();
		int starting = 10, days = 5;
		double rate = 0.5;
		System.out.println("Population will be 73: " + populationSize(starting, rate, days));
		starting = 2;
		days = 4;
		rate = 1.0;
		System.out.println("Population will be 32: " + populationSize(starting, rate, days));
		starting = 100;
		days = 0;
		rate = 33;
		System.out.println("Population will be 100: " + populationSize(starting, rate, days));
		System.out.println();
		

		
		// Note: you need to use a revised ArrayBag and LinkedBag classes to test these methods
		// Q7
		ArrayBag<Integer> numbersArrayBag = new ArrayBag<Integer>();
		numbersArrayBag.add(1);
		numbersArrayBag.add(2);
		numbersArrayBag.add(1);
		numbersArrayBag.add(4);
		numbersArrayBag.add(3);
		System.out.println("The bag contains[1, 2, 1, 4, 3] \n\t\t"	+ Arrays.toString(numbersArrayBag.toArray()));
		System.out.println("Should be 2: " + numbersArrayBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersArrayBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersArrayBag.getFrequencyOf(5));
		

		// Q8
		LinkedBag<Integer> numbersLinkedBag = new LinkedBag<Integer>();
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(2);
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(4);
		numbersLinkedBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 2: " + numbersLinkedBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersLinkedBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(5));		
		

		// Q9
		// this is a private method- so you'll have to test it internally!
		
		// Q10- try it with both AList and LList!
		ListInterface<Integer> numbersList = new AList<Integer>(); // swap this out for an LList- your code should still work!
		numbersList.add(4);
		numbersList.add(1);
		numbersList.add(3);
		numbersList.add(2);
		numbersList.add(0);
		numbersList.add(9);
		
		System.out.println("Sum is 19: " + sumList(numbersList));
		
		//Extra Credit- try it with both ArrayBag and LinkedBag!
		BagInterface<Integer> numbersBag = new ArrayBag<Integer>(); // swap this out for LinekdBag- your code should still work!
		numbersBag.add(2);
		numbersBag.add(-1);
		numbersBag.add(3);
		numbersBag.add(5);
		numbersBag.add(-2);
		numbersBag.add(-4);
		numbersBag.add(1);
		System.out.println("The bag contains[2, -1, 3, 5, -2, -4, 1] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 4 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [2, -1, 3, 5, -2, -4, 1] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		
	}
	
	public static void printBackwards1(String s) {
		System.out.println();
		printBackwards1(s, s.length()-1);
		
	}

	private static void printBackwards1(String s, int position){
		if (position <0){
			return;
		}
		System.out.print(s.charAt(position));
		printBackwards1(s, position-1);

	}

	public static void printBackwards2(String s) {
		System.out.println();
		printBackwards2(s, 0);
	}

	private static void printBackwards2(String s, int position){
		if (position > s.length()-1){
			return;
		}
		printBackwards2(s, position+1);
		System.out.print(s.charAt(position));
	}

	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length()-1);
	}

	private static boolean isPalindrome (String s, int start, int end){
		if (start > end){
			return true;
		} else if (s.charAt(start) != s.charAt(end)) {
			return false;
		} else {
			return isPalindrome(s, start+1, end-1);
		}
	}
	
	public static int sumList(ListInterface<Integer> list) {

		return sumList(list, 1, 0);
	}

	private static int sumList(ListInterface<Integer> list, int position, int sum){
		if (position > list.getLength()) {
			return sum;
		} else {
			return list.getEntry(position) + sumList(list, position+1, sum);
		}
	}

	
	public static int countPositives(BagInterface<Integer> bag) {
		int position = bag.getCurrentSize();
		int value = bag.remove();
		return countPositives(bag, position, 0, value);
	}
	
	private static int countPositives(BagInterface<Integer> bag, int position, int count, int previousToAdd){
		int value;
		if (position ==0){
			value = bag.remove();
			bag.add(previousToAdd);
			bag.add(value);
			count+= value>0 ? 1:0;
			return count;
		} else {
			value = bag.remove();
			bag.add(previousToAdd);
			count += value >0 ? 1: 0;
			return countPositives(bag, position-1, count, value);
		}
	}
	public static int populationSize(int startingPopulation, double increaseRate, int numberOfDays) {
		if (numberOfDays ==0){
			return startingPopulation;
		} else {
			return  (int) Math.floor((1+increaseRate) * populationSize(startingPopulation, increaseRate, numberOfDays-1));
		}
	}
	
	
}