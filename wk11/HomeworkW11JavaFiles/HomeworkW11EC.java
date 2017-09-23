import java.util.*;

public class HomeworkW11EC {

	private static Hashtable<String, ABCounts> hashTable;
	private static int numberOfUserChoices, numberCorrect, numberIncorrect;
	private static Random generator;

	public static void main(String[] args) {
		hashTable = new Hashtable<String, ABCounts>();
		numberOfUserChoices = 0;
		numberCorrect = 0;
		numberIncorrect = 0;
		generator = new Random();

		Scanner scan = new Scanner(System.in);
		boolean keepPlaying = true;
		String previousGuesses = "";

		while (keepPlaying) {
			System.out.println("Think of either A or B, and I will guess your choice.(Type QUIT to exit.)");
			String userResponse = scan.nextLine().toUpperCase();
			numberOfUserChoices++;
			if (!userResponse.equals("QUIT")) {
				char myGuess = makeComputerGuess(previousGuesses,hashTable);
				
				System.out.print("I guess that you chose " + myGuess + "; am I right? ");
				userResponse = scan.nextLine();
				previousGuesses += myGuess;
				if (previousGuesses.length() >4){
					previousGuesses = previousGuesses.substring(1);
				}
				if (userResponse.toLowerCase().charAt(0) == 'y') {
					numberCorrect++; // program guess is right
					addUserChoice(myGuess, previousGuesses, hashTable); // user choice is same as program guess
				} else {
					numberIncorrect++; // program guess is wrong
					// user choice is opposite program guess
					if (myGuess == 'A')
						addUserChoice('B', previousGuesses, hashTable);
					else
						addUserChoice('A', previousGuesses, hashTable);
				} 
				System.out.println("my guess is "+myGuess);

				System.out.println("Score: " + numberCorrect + " correct. " + numberIncorrect + " incorrect.\n");

			} else {
				keepPlaying = false;
			}
		} 
		System.out.println("Bye!");
	}

	public static char makeComputerGuess(String previousGuesses, Hashtable<String, ABCounts> hashTable) {

		if (numberOfUserChoices < 5) {
			return makeRandomGuess();
		} else {
			// YOUR CODE HERE
			// use the hashtable to make a smart guess (when possible)
			ABCounts count = hashTable.get(previousGuesses);
			int aCount = count.getACount();
			int bCount = count.getBCount();
			if (aCount>=bCount){
				return 'A';
			} else {
				return 'B';
			}
		} 
	} 

	public static void addUserChoice(char choice, String previousGuesses, Hashtable<String, ABCounts> hashTable) {
		// YOUR CODE HERE
		// update your hashtable based on whatever the user just guessed
		if (previousGuesses.length()==4){
			if (hashTable.get(previousGuesses) ==null){
				ABCounts count = new ABCounts();
				hashTable.put(previousGuesses, count);
			} else {
				ABCounts count = hashTable.get(previousGuesses);
				count.updateCount(choice);
				hashTable.put(previousGuesses, count);
			}
			
		}

	} 
	private static char makeRandomGuess() {
		int randomInteger = generator.nextInt();
		if (randomInteger % 2 == 0)
			return 'A';
		else
			return 'B';
	}	

}
