/* Jessica Masters
   CS 111C Solution to Lab B: Interfaces
*/

public interface EntryWayListInterface<T> {
	/**
	 * Places a new object at beginning of list
	 * 
	 * @param newEntry the item to be added to the list
	 * @return true if the item was successfully added to the list; false otherwise
	 */
	boolean insertHead(T newEntry);

	/**
	 * Places a new object at the end of the list
	 * 
	 * @param newEntry the item to be added to the list
	 * @return true if the item was successfully added to the list; false otherwise
	 */
	boolean insertTail(T newEntry);

	/**
	 * Deletes the object at the beginning of the list
	 * 
	 * @return the object that has been deleted or null if the list is empty
	 */
	T deleteHead();

	/**
	 * Delete the object at the end of the list
	 * 
	 * @return the object that has been deleted or null if the list is empty
	 */
	T deleteTail();

	/**
	 * Displays the contents of the list on the console, in order, one per line
	 */
	void display();

	/**
	 * Searches the list for the given object and return its position in the
	 * list, or -1 if it's not found
	 * 
	 * @param anEntry the object to search for in the list
	 * @return the position of the entry that was found or -1 if the object is not in the list not found
	 */
	int contains(T anEntry);

	/**
	 * Checks to see if list is empty
	 * 
	 * @return true if list is empty, false if list contains one or more
	 *         objects
	 */
	boolean isEmpty();

	/**
	 * Check if list is full
	 * 
	 * @return true if list is full, false if list has space for more objects
	 */
	boolean isFull();
}
