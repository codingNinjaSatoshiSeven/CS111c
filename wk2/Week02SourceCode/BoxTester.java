import java.util.*;

public class BoxTester {

	public static void main(String[] args) {

		BoxR numbersBoxNotReally = new BoxR(new Integer(4));
		numbersBoxNotReally.replaceContents(new Integer(5));
		
		//numbersBoxNotReally.replaceContents(new String("hello"));
		
		Integer currentContents = (Integer) numbersBoxNotReally.getContents();
		
		Box<Integer> numbersBox1 = new Box<Integer>(new Integer(4));
		numbersBox1.replaceContents(new Integer(5));

		Box<String> wordBox = new Box<String>("hello");
		wordBox.replaceContents("bye");
		
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
		
		Collections.sort(listOfNumberBoxes);
		
		System.out.println(listOfNumberBoxes);
		
		
		
	}

}
