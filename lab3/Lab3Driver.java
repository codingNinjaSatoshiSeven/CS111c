import java.util.Arrays;

public class Lab3Driver {

	public static void main(String[] args) {

		// setting up Nodes to test
		System.out.println("TESTING NODES");
		EntryWayList<Integer> myList = new EntryWayList<Integer>();
    myList.insertHead(1);
    myList.insertHead(2);
    myList.display();
    myList.deleteHead();
    myList.deleteHead();
    myList.insertTail(2);
    myList.insertTail(1);
    myList.display();
    //myList.deleteTail();
		//myList.deleteTail();
    System.out.println(myList.contains(1));
    System.out.println(myList.contains(3));
		
  }
}
