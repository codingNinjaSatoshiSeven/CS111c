public class MovieDriver {

	public static void main(String[] args) {

		// YOUR CODE HERE
		Movie[] myMovies = new Movie[5];
		myMovies[0] = new Movie("The Lion King", 1994);
		myMovies[1] = new Movie("Avatar", 2009);
		myMovies[2] = new Movie("Deadpool");
		myMovies[3] = new Movie("Zootopia");
		myMovies[4] = new Movie("Kung Fu Panda", 2008);

		for (int i=0; i<myMovies.length; i++){
			System.out.println(myMovies[i]);
		}

	}

}