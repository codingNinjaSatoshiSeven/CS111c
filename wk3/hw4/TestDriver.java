import java.util.*;
public class TestDriver
{
	public static void main(String[] args)
	{
		// Without Generics
		// my compiler wont execute the generic code , unless run with javac StudentDriver -Xlint:unchecked
		BagInterface<String> myWords = BagInterface<String>();
		//hi, hello, hi, bye, hi, bye, hello, howdy
		myWords.add("hi");
		myWords.add("hello");
		myWords.add("hi");
		myWords.add("bye");
		myWords.add("hi");
		myWords.add("bye");
		myWords.add("hello");
		myWords.add("howdy");



		BagInterface<String> tempBag = BagInterface<String>();
		while (!myWords.isEmpty()){
			String temp = myWords.remove();
			if (!tempBag.contains(temp)){
				tempBag.add(temp);
			}
		}

		while (!tempBag.isEmpty()){
			myWords.add(tempBag.remove());
		}

		System.out.println(myWords.getCurrentSize());
		//hi, hello, bye, howdy
		//4

		//a, f, v, q, e, a, o, g, y, h, e, q, u
		//a, e, a, o, e, u
		while (!letters.isEmpty()){
			String temp = letters.remove();
			if (temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u")){
				vowels.add(temp);
			}
		}

		System.out.println("There are " + vowels.getCurrentSize() + " vowels in the bag");
		System.out.println("a- "+ vowels.getFrequencyOf("a"));
		System.out.println("e- "+ vowels.getFrequencyOf("e"));
		System.out.println("i- "+ vowels.getFrequencyOf("i"));
		System.out.println("o- "+ vowels.getFrequencyOf("o"));
		System.out.println("u- "+ vowels.getFrequencyOf("u"));



		while (!letters.isEmpty()){
			String temp = letters.remove(1);
			int vowelCount= {0,0,0,0,0};
			if (temp.equals("a") ){
				vowels.add(temp);
				vowel[0]++;
			} else if (temp.equals("e")){
				vowels.add(temp);
				vowel[1]++;
			} else if (temp.equals("i")){
				vowels.add(temp);
				vowel[2]++;
			} else if (temp.equals("o")){
				vowels.add(temp);
				vowel[3]++;
			} else if (temp.equals("u")){
				vowels.add(temp);
				vowel[4]++;
			}
		}

		System.out.println("There are " + vowels.getLength() + " vowels in the bag");
		System.out.println("a- "+ vowel[0]);
		System.out.println("e- "+ vowel[1]);
		System.out.println("i- "+ vowel[2]);
		System.out.println("o- "+ vowel[3]);
		System.out.println("u- "+ vowel[4]);


		for (int i =0; i< myList.getLength(); i++){
			if (myList.getEntry(i).equals(givenItem)){
				return i;
				break;
			}
		}


		for (int i=1; i<studentList.getLength()+1; i++){
			System.out.println("Student is "+ studentList.getEntry(i).getFirstName() + studentList.getEntry(i).getLastName());
		}
		Student start, end;
		if (studentList.getLength()>0){
			// non-empty list
			start = studentList.getEntry(1); // first element;
			end = studentList.getEntry(studentList.getLength()); // last element
			studentList.replace(1, end);
			studentList.replace(studentList.getLength(), start);

		} 
		// if empty list, no need to swap
	}
}