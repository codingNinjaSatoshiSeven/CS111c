/**
    A class of bags whose entries are stored in a fixed-size array.
    INITIAL, INCOMPLETE DEFINITION; no security checks
    @author Frank M. Carrano
 @version 4.0
*/
public final class ArrayBag<T> implements BagInterface<T>
{
	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;

	/** Creates an empty bag whose capacity is 25. */
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given capacity.
       @param capacity  The integer capacity desired. */
	public ArrayBag(int capacity)
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[desiredCapacity]; // Unchecked cast
      bag = tempBag;
      numberOfEntries = 0;
	} // end constructor

	public ArrayBag(int desiredCapacity)
	{
		if (desiredCapacity <= MAX_CAPACITY)
		{
		   // The cast is safe because the new array contains null entries
		   @SuppressWarnings("unchecked")
		   T[] tempBag = (T[])new Object[capacity]; // Unchecked cast
		   bag = tempBag;
		   numberOfEntries = 0;
		   initialized = true;
		}
		else
		    throw new IllegalStateException("Attempt to create a bag " +
		                                      "whose capacity exceeds " +
		                                      "allowed maximum.");
	} // end constructor

	/** Adds a new entry to this bag.
    @param newEntry  the object to be added as a new entry.
    @return  true if the addition is successful, or false if not. */
	public boolean add(T newEntry) 
	{
		boolean result = true;
		if (isArrayFull())
		{
			result = false;
		}
		else
		{  // Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		
		return result;
	} // end add
   
	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = bag[index];
		} // end for
			
		return result;
	} // end toArray
	
   	// Returns true if the array bag is full, or false if not.
	// Returns true if this bag is full, or false if not.
	public boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		// To be defined
	} // end add
	
	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry)
	{
		// To be defined
	} // end add
   
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove()
	{
		// To be defined
	} // end remove
   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
   public boolean remove(T anEntry)
	{
		// To be defined
	} // end remove
	
	/** Removes all entries from this bag. */
	public void clear()
	{
		// To be defined
	} // end clear

	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
	{
		// To be defined
	} // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry)
	{
		// To be defined
	} // end contains
} // end ArrayBag

