public class DoublyLinkedBag<T> implements BagInterface<T> {
	private DoubleNode<T> firstNode; // reference to first node
	private int numberOfEntries;

	public DoublyLinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/**
	 * Adds a new entry to double linked bag.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		Node newNode = new DoubleNode(newEntry);
		newNode.next = firstNode; // Make new node reference rest of chain
									// (firstNode is null if chain is empty)
		newNode.previous = null; // new nodes has no previous
		firstNode.previous = newNode;
		firstNode = newNode; // New node is at beginning of chain
		numberOfEntries++;

		return true;
	}



	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast

		int index = 0;
		DoubleNode<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
	} // end toArray

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;

		int counter = 0;
		DoubleNode<T> currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            the entry to locate
	 * @return true if the bag contains anEntry, or false otherwise
	 */
	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null;
	} // end contains

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private DoubleNode<T> getReferenceTo(T anEntry) {
		boolean found = false;
		DoubleNode currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			firstNode.previous = null;
			numberOfEntries--;
		} // end if

		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false otherwise
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		DoubleNode nodeN = getReferenceTo(anEntry);

		if (nodeN != null) {
			if (nodeN.equals(firstNode)) {
				remove();
				return true; // return here to avoid subtracting from
								// numberOfEntries twice
			}

			nodeN.previous.next = nodeN.next;

			if (nodeN.next != null)
				nodeN.next.previous = nodeN.previous; // Can only set the next
														// node's reference if
														// it exists

			numberOfEntries--;
			result = true;
		} // end if

		return result;
	} // end remove

} // end LinkedBag