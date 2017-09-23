import java.util.Arrays;

/**
 * A class that implements the ADT list by using a resizable array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class AList<T extends Comparable<? super T>> implements ListInterface<T>, Comparable<AList <T>> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		//this(DEFAULT_CAPACITY);
		T[] tempList = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	} // end default constructor

	public AList(int initialCapacity) {
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			// Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	} // end constructor

	public void add(T newEntry) {
		add(numberOfEntries + 1, newEntry);
	} // end add

	// Precondition: The array list has room for another entry.
	public void add(int newPosition, T newEntry) {
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) { // checks that it's a valid position
			if (newPosition <= numberOfEntries) // if we're not adding to the end of the list, we need to make room
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity(); // Ensure enough room for next add
		} else
			throw new IndexOutOfBoundsException(
					"Given position of add's new entry is out of bounds.");
	} // end add

	/** return the 1st occurance of matching entry position
	    Entries currently in the list are unaffected
	    The bags size is unaffected
	    @param entry, the entry to be searched to find position
	    @return position of the entry, or -1 if not found */
	public int getPosition(T entry){
		int position = -1;
		for (int i=0; i<numberOfEntries; i++){
			if (entry.equals(list[i])){
				position = i;
			}
		}
		return position;
	}


	public T remove(int givenPosition) {
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) { // make sure it's a valid position
			assert !isEmpty(); // we know this because of the check on the valid position
			T result = list[givenPosition]; // Get entry to be removed

			// Move subsequent entries towards entry to be removed,
			// unless it is last in list
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);

			numberOfEntries--;
			return result;
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	} // end remove

	public void clear() {
		checkInitialization();

		// Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfEntries; index++)
			// Loop is part of Q4
			list[index] = null;

		numberOfEntries = 0;
	} // end clear

	public T replace(int givenPosition, T newEntry) {
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) {
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return list[givenPosition];
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray() {
		checkInitialization();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		} // end for

		return result;
	} // end toArray

	public boolean contains(T anEntry) {
		checkInitialization();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} // end while

		return found;
	} // end contains

	public int getLength() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/** Move the last element in the list to the beginning
	    Other Entries currently in the list are shifted backward 1 unit
	    The list's size is not affected.
	    @return true if there are element to be moved to beginning, false otherwise. */
	public boolean moveToBeginning(){
		if(numberOfEntries > 1) {
			T entry = remove(numberOfEntries);
			add(1, entry);
			return true;
		} else {
			return false;
		}
	}

	// would need to use javadoc-style comments to indicate
	// what is meant by true and false
	/** Move the 1st element in the list to the end
	    Other Entries currently in the list are shifted forward 1 unit.
	    The list's size is not affected.
	    @return true if there are element to be moved to end, false otherwise. */
	public boolean moveToEnd() {
		if(numberOfEntries > 1) {
			T entry = remove(1);
			add(entry);
			return true;
		} else {
			return false;
		}
	}

	// compare if 2 AList are equal
	// if they have different size, not equal
	// if they have the same size, but not every element are equal, then not equal
	// if they have the same size, and every element are equal, then equal 
	@Override
	public boolean equals(Object other){
		if(other instanceof AList) {
			AList<T> otherList = (AList<T>) other;
			
			if (numberOfEntries != otherList.getLength()){
				return false;
			} else {
				boolean flag = true;
				for (int i=0; i<numberOfEntries; i++){
					if (!otherList.contains(this.getEntry(i+1))){
						flag = false;
						break;
					}
				}
				return flag;
			}	
		} else {
			return false;
		}
	}

	// If the 2 AList have different size, size is compared
	// if the 2 AList have same size, every element is compared
	// which AList has more greater element is considered greater
	@Override
	public int compareTo(AList<T> otherList){
		
		T[] myArray = this.toArray();
		T[] otherArray = otherList.toArray();
		if (myArray.length != otherArray.length){
			if (myArray.length > otherArray.length){
				return 1;
			} else {
				return -1;
			}
		} else {
			int myCount = 0, otherCount=0;
			for (int i=0; i<myArray.length; i++){
				if (myArray[i].compareTo(otherArray[i]) >0){
					myCount++;
				} else if (myArray[i].compareTo(otherArray[i]) <0){
					otherCount++;
				}
			}
	
			if (myCount> otherCount){
				return 1;
			} else if (myCount< otherCount){
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	public boolean swap(int firstPosition, int secondPosition) {
		if(firstPosition >= 1 && firstPosition <= numberOfEntries &&
				secondPosition >= 1 && secondPosition <= numberOfEntries) {
			T temp = list[firstPosition];
			list[firstPosition] = list[secondPosition];
			list[secondPosition] = temp;
			return true;
		} else {
			throw new IndexOutOfBoundsException(
					"Illegal position given to swap operation.");
		}
	}
	
	public AList<T> getAllLessThen(Comparable entry) {
		AList<T> lessThanList = new AList<T>();
		for(int i=1; i<numberOfEntries; i++) {
			T currentItem = list[i];
			if(entry.compareTo(currentItem) > 0) { // meaning that entry is bigger than currentItem
				lessThanList.add(currentItem);
			}
		}
		return lessThanList;
	}
	
	// Doubles the capacity of the array list if it is full.
	// Precondition: checkInitialization has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} // end if
	} // end ensureCapacity

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	// numberOfEntries is list's length before addition;
	// checkInitialization has been called.
	private void makeRoom(int newPosition) {
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

		int newIndex = newPosition;
		int lastIndex = numberOfEntries;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
	} // end makeRoom

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	// numberOfEntries is list's length before removal;
	// checkInitialization has been called.
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;

		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	} // end removeGap

	// Throws an exception if this object is not initialized.
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException(
					"AList object is not initialized properly.");
	} // end checkInitialization

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a list "
					+ "whose capacity exceeds " + "allowed maximum.");
	} // end checkCapacity
} // end AList

