import java.util.*;

public class BoxDriver {
	public static void main(String[] args) {

		Box<Integer> numbersBox1 = new Box<Integer>(new Integer(4));
		System.out.println("The wordBox history is "+ numbersBox1.getHistory());
		numbersBox1.replaceContents(new Integer(5));
		System.out.println("The wordBox history is "+ numbersBox1.getHistory());

		Box<String> wordBox = new Box<String>("hello");
		System.out.println("The wordBox history is "+ wordBox.getHistory());
		wordBox.replaceContents("bye");
		System.out.println("The wordBox history is "+ wordBox.getHistory());
		
		Box<String> wordBox2 = new Box<String>("bye");
		wordBox2.replaceContents("bye");
		
		System.out.println("same boxes? " + wordBox.equals(wordBox2));
		System.out.println("same boxes? " + wordBox.equals(numbersBox1));
		
		Box<Integer> numbersBox2 = new Box<Integer>(new Integer(10));
		Box<Integer> numbersBox3 = new Box<Integer>(new Integer(2));
		numbersBox3.replaceContents(5);
		numbersBox3.replaceContents(2);
		Box<Integer> numbersBox4 = new Box<Integer>(new Integer(13));
		numbersBox4.replaceContents(12);
		numbersBox4.replaceContents(5);
		Box<Integer> numbersBox5 = new Box<Integer>(new Integer(7));
		
		
		ArrayList<Box<Integer>> listOfNumberBoxes = new ArrayList<Box<Integer>>();
		listOfNumberBoxes.add(numbersBox1);
		listOfNumberBoxes.add(numbersBox2);
		listOfNumberBoxes.add(numbersBox3);
		listOfNumberBoxes.add(numbersBox4);
		listOfNumberBoxes.add(numbersBox5);
		
		System.out.println(listOfNumberBoxes);
		
	}

}
