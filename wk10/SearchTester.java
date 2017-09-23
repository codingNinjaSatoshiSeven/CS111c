import java.util.Arrays;
import java.util.Random;


public class SearchTester {

	public static void main(String[] args) {

		Random generator = new Random();
		int[] numbers = new int[1000];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(100);
		}
		
		int randomTarget = generator.nextInt(100);
		
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int location = linearSearch(numbers, randomTarget);
		location = linearSearchOnSorted(numbers, randomTarget);
		location = binarySearch(numbers, randomTarget);
		
		if(location==-1) {
			System.out.println(randomTarget + " is not in the array.");
		} else {
			System.out.println(randomTarget + " is located at position " + location + ".");
		}
		
	}
	
	public static int binarySearch(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false;
		int first = 0, last = numbers.length-1; // indicate my indices where I'm searching
		int comparisonCount = 0;
		
		while(first <= last && !found) {
			comparisonCount++;
			int mid = (first + last) / 2;
			
			if(numbers[mid] == target) {
				targetLocation = mid;
				found = true;
			} else if(numbers[mid] < target) {
				first = mid+1;
			} else { // numbers[mid] > target
				last = mid-1;
			}
		}
		System.out.println("In binary search, comparison count is \t\t\t\t" + comparisonCount);
		return targetLocation;
	}
	
	
	
	
	
	
	// finds the first location of a target
	public static int linearSearch(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false; // include if we want to stop when we find the target
		// without this variable, we will return the LAST location of the target
		
		int comparisonCount = 0;
		
		for(int i=0; (i<numbers.length && !found); i++) {
			comparisonCount++;
			if(numbers[i] == target) {
				found = true;
				targetLocation = i;
			}
		}
		System.out.println("In linear search, comparison count is \t\t\t\t" + comparisonCount);
		return targetLocation;
		
	}
	
	public static int linearSearchOnSorted(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false;
		boolean gonePastTarget = false;
		int comparisonCount = 0;
		
		for(int i=0; (i<numbers.length && !found && !gonePastTarget); i++) {
			comparisonCount++;
			if(numbers[i] == target) {
				found = true;
				targetLocation = i;
			} else if(numbers[i] > target) {
				gonePastTarget = true;
			}
		}
		System.out.println("In linear search optimized for sorting, comparison count is \t" + comparisonCount);
		return targetLocation;
	}

}
