import java.util.Scanner;

public class RecursionTester {

	public static void main(String[] args) {
		ListInterface<Integer> list = new AList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
		System.out.println(list.contains(1));
		System.out.println(list.contains(4));
		System.out.println(list.contains(2));
		System.out.println(list.contains(5));

		recursiveCountDown(5);
		int[] nums = { 4, 7, 1, 11, 12, 14, 5, 4 };
		printArray(nums);
		printArrayReverse(nums);

	}

	public static boolean listContains(ListInterface list, Object item) {
		return listContainsHelper(list, item, 1, list.getLength());
	}

	private static boolean listContainsHelper(ListInterface list, Object item,
			int start, int end) {
		if (start <= end) { // recursive case
			Object currentItem = list.getEntry(start);
			if (currentItem.equals(item)) {
				return true;
			} else {
				return listContainsHelper(list, item, start + 1, end);
			}

		} else { // base case: start > end
			return false;
		}
	}

	public static int charCounter(String text, char letter) {
		return charCounterHelper(text, letter, 0, text.length() - 1);

	}

	private static int charCounterHelper2(String text, char letter,
			int firstCharIndex, int lastCharIndex) {
		int charCount = 0;
		if (firstCharIndex == lastCharIndex) { // base case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				charCount = 1;
			} else {
				charCount = 0;
			}
		} else { // recursive case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				charCount = 1 + charCounterHelper2(text, letter,
						firstCharIndex + 1, lastCharIndex);
			} else {
				charCount = 0 + charCounterHelper2(text, letter,
						firstCharIndex + 1, lastCharIndex);
			}
		}
		return charCount;
	}

	private static int charCounterHelper(String text, char letter,
			int firstCharIndex, int lastCharIndex) {
		if (firstCharIndex == lastCharIndex) { // base case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				return 1;
			} else {
				return 0;
			}
		} else { // recursive case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				return 1 + charCounterHelper(text, letter, firstCharIndex + 1,
						lastCharIndex);
			} else {
				return 0 + charCounterHelper(text, letter, firstCharIndex + 1,
						lastCharIndex);
			}
		}
	}

	public static int recursiveReadInRange() {
		System.out.println("Enter a value between 1 and 10:");
		Scanner scan = new Scanner(System.in);
		int userNumber = scan.nextInt();

		if (userNumber >= 1 && userNumber <= 10) { // base case
			return userNumber;
		} else { // recursive case
			System.out.println("Bad input.");
			return recursiveReadInRange();
		}
	}

	public static int iterativeReadInRange() {
		System.out.println("Enter a value between 1 and 10:");
		Scanner scan = new Scanner(System.in);
		int userNumber = scan.nextInt();
		while (userNumber < 1 || userNumber > 10) {
			System.out.println("Bad input.");
			System.out.println("Enter a value between 1 and 10:");
			userNumber = scan.nextInt();
		}
		return userNumber;
	}

	public static void printArrayReverse(int[] numbers) {
		printArrayReverseHelper(numbers, 0, numbers.length - 1);
	}

	private static void printArrayReverseHelper(int[] numbers, int first,
			int last) {
		if (first == last) {
			System.out.println(numbers[first]);
		} else {
			System.out.println(numbers[last]);
			printArrayReverseHelper(numbers, first, last - 1);
		}
	}

	public static void printArray(int[] numbers) {
		printArrayHelper(numbers, 0, numbers.length - 1);
	}

	private static void printArrayHelper(int[] numbers, int first, int last) {
		// base case
		if (first == last) {
			System.out.println(numbers[first]);
		} else { // recursive case
			System.out.println(numbers[first]);
			printArrayHelper(numbers, first + 1, last); // moving us towards the
														// base case since first
														// is incremented
		}
	}

	// we assume this method is invoked with a non-negative number
	public static void recursiveCountDown(int n) {
		// base case
		if (n == 0) {
			System.out.println(n + "... Blast off!");
		} else {
			// recursive case- should reduce problem size and move us towards
			// the base case
			System.out.println(n); // solve a small part now
			recursiveCountDown(n - 1); // reduced problem size that i'm passing
										// to solve later
		}
	}

	public static void iterativeCountDown(int n) {
		while (n > 0) {
			System.out.println(n);
			n--;
		}
		System.out.println(n + " ... Blast off!");
	}

}
