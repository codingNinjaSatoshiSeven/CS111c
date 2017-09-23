public class MovieDocumentaryDriver {

	public static void main(String[] args) {

		// YOUR CODE HERE
		Movie[] myMovies = new Movie[5];
		myMovies[0] = new Movie("The Lion King", 1994);
		myMovies[1] = new Documentary("The Iron Lady", 2011, "History");
		myMovies[2] = new Documentary("Hoop Dreams", 1994, "Sports");
		myMovies[3] = new Movie("Deadpool");


		for (int i=0; i<myMovies.length; i++){
			if (myMovies[i] instanceof Documentary) {
				Documentary myDocumentary = (Documentary)myMovies[i];
				System.out.println(myDocumentary.getTopic());
			}
		}

	}

}