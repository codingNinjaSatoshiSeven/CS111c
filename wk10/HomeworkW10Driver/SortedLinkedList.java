import java.util.ArrayList;

/**
 * A class that implements the ADT sorted list by using a chain of nodes.
 * Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class SortedLinkedList<T extends Comparable<? super T>> implements
		SortedListInterface<T> {
	
	
	
	public void merge (SortedListInterface <T> sList)
	{
		int sListLength = sList.getLength();
	//	assert (!isFull()) && ((length + sListLength) <= MAX_SIZE));

		if (isEmpty())
		{
			int count = 1;	
			int length = sList.getLength();
			for (Node p = firstNode; p.next != null; p = p.next)
			{
				while (count <= length)
				{
					p.data = sList.getEntry(count);
					count++;
				}
			}
		if (sList.isEmpty())
			return;
		else
		{
			Node temp = new Node(null);
			if (sList.getEntry(1).compareTo(firstNode.data) < 0)
			{
				temp = firstNode;
				firstNode.data = sList.getEntry(1);
				firstNode.next = temp;
			}
			 count = 2;
			for (Node p = firstNode.next; p.next != null; p = p.next)
			{
				if (count <= sList.getLength())
				{
					if ((p.data.compareTo(sList.getEntry(count)) > 0))
					{
						temp = p;
						p.data = sList.getEntry(count);
						p.next = temp;
						count++;
					}	
					else
					{
						temp = p.next;
						p.next.data = sList.getEntry(count);
						p.next.next = temp;
						count++;
					}
				if (count > sList.getLength())
				{
					return;
				}
				}
			}
		}
		}
	}

	
	
	
	
	
	private Node firstNode; // reference to first node of chain
	private int length; // number of entries in sorted list

	public SortedLinkedList() {
		firstNode = null;
		length = 0;
	} // end default constructor

	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		Node nodeBefore = getNodeBefore(newEntry);

		if (isEmpty() || (nodeBefore == null)) // add at beginning
		{
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else // add after nodeBefore
		{
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		} // end if

		length++;
		return true;
	} // end add
/*
	public void merge(SortedListInterface<T> sList) {
		if (!sList.isEmpty()) {
			if (!isEmpty()) {
				Node currentNode = firstNode;
				Node previousNode = firstNode;

				int startPos = 1;

				// handle the case of the first element of sList being smaller
				// than firstNode
				T firstElement = sList.getEntry(1);
				if (firstElement.compareTo(firstNode.data) < 0) {
					Node newNode = new Node(firstElement);
					newNode.next = firstNode;
					firstNode = newNode;
					startPos = 2;
				}

				for (int i = startPos; i <= sList.getLength(); i++) {
					T sortedListElement = sList.getEntry(i);
					while (currentNode != null
							&& currentNode.data.compareTo(sortedListElement) < 0) {
						previousNode = currentNode;
						currentNode = currentNode.next;
					}
					Node newNode = new Node(sortedListElement);
					previousNode.next = newNode;
					previousNode = newNode;
					newNode.next = currentNode;
				}
			} else {
				assert (firstNode == null && length == 0); // isEmpty is true
				firstNode = new Node(sList.getEntry(1));
				length++;
				Node currentNode = firstNode;
				for (int i = 2; i <= sList.getLength(); i++) {
					Node newNode = new Node(sList.getEntry(i));
					length++;
					currentNode.next = newNode;
					currentNode = currentNode.next;
				}
			}
		} 
	}
*/
	private Node getNodeBefore(T anEntry) {
		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null)
				&& (anEntry.compareTo(currentNode.getData()) > 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		} // end while

		return nodeBefore;
	} // end getNodeBefore

	public boolean remove(T anEntry) {
		boolean found = false;

		if (length > 0) {
			Node nodeToRemove;
			Node nodeBefore = getNodeBefore(anEntry);

			if (nodeBefore == null)
				nodeToRemove = firstNode;
			else
				nodeToRemove = nodeBefore.getNextNode();

			if ((nodeToRemove != null)
					&& anEntry.equals(nodeToRemove.getData())) {
				found = true;

				if (nodeBefore == null)
					firstNode = nodeToRemove.getNextNode();
				else {
					Node nodeAfter = nodeToRemove.getNextNode();
					nodeBefore.setNextNode(nodeAfter);
				} // end if

				length--;
			} // end if
		} // end if

		return found;
	} // end remove

	public int getPosition(T anEntry) {
		int position = 1;
		Node currentNode = firstNode;

		while ((currentNode != null)
				&& (anEntry.compareTo(currentNode.getData()) > 0)) {
			currentNode = currentNode.getNextNode();
			position++;
		} // end while

		if ((currentNode == null)
				|| anEntry.compareTo(currentNode.getData()) != 0)
			position = -position;

		return position;
	} // end getPosition

	// list operations
	public T remove(int givenPosition) {
		T result = null; // return value

		if ((givenPosition >= 1) && (givenPosition <= length)) {
			assert !isEmpty();

			if (givenPosition == 1) // case 1: remove first entry
			{
				result = firstNode.getData(); // save entry to be removed
				firstNode = firstNode.getNextNode();
			} else // case 2: givenPosition > 1
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // disconnect the node to be
													// removed
				result = nodeToRemove.getData(); // save entry to be removed
			} // end if

			length--;
		} // end if

		return result; // return removed entry, or
						// null if operation fails
	} // end remove

	public final void clear() {
		firstNode = null;
		length = 0;
	} // end clear

	public T getEntry(int givenPosition) {
		T result = null; // result to return

		if ((givenPosition >= 1) && (givenPosition <= length)) {
			assert !isEmpty();
			result = getNodeAt(givenPosition).getData();
		} // end if

		return result;
	} // end getEntry

	
	public int getLength() {
		return length;
	} // end getLength

	public boolean isEmpty() {
		boolean result;

		if (length == 0) // or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	} // end isEmpty

	public boolean isFull() {
		return false;
	} // end isFull

	public void display() {
		// iterative
		Node currentNode = firstNode;
		while (currentNode != null) {
			System.out.print(currentNode.getData()+ " ");
			currentNode = currentNode.getNextNode();
		} // end while
		System.out.println();
	} // end display

	public boolean contains(T anEntry){
		Node currentNode = firstNode;
		while (currentNode!= null ){
			if (currentNode.data.equals(anEntry)){
				return true;
			} else if (currentNode.data.compareTo(anEntry) >0){
				return false; 
			} else {
				currentNode = currentNode.next; 
			}
		}
		return false;
	}

	private Node getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
		Node currentNode = firstNode;

		// traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

	private class Node {
		private T data; // entry in list
		private Node next; // link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end SortedLinkedList
