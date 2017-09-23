import java.util.*;

public class NumericInput {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		System.out.println("How many numbers?");
		int numberNumbers = Integer.parseInt(scan.nextLine());
		
		for(int i=0; i<numberNumbers; i++) {
			int userNumber = Integer.parseInt(scan.nextLine());		
			numberList.add(userNumber);
		}
		
		int total = 0;
		for(Integer i : numberList) {
			total += i;
		}
		double average = (total * 1.0) / ( (double) numberList.size() );
		
		System.out.println("The average is " + average);

	}

}
