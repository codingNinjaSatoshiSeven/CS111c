/** An interface for the ADT list that allows only accessing head and tails info.
    Entries in a list have positions that begin with 1.

    @author Shengtao Li
    @version 1.0
*/
public interface EntryWayListInterface<T>
{
  /** Adds a new entry to the head of this list.
       Entries that are currently in the list are shifted to back by 1.
       The list's size is increased by 1.
       @param newEntry  The object to be inserted into head as a new entry. 
       @return  A boolean indicating whether the data is inserted or not.*/
   public boolean insertHead(T newEntry);

  /** Adds a new entry to the tail of this list.
       Entries that are currently in the list are unaffected.
       The list's size is increased by 1.
       @param newEntry  The object to be inserted into tail as a new entry. 
       @return  A boolean indicating whether the data is inserted or not.*/
   public boolean insertTail(T newEntry);

  /** Delete and return the Head entry.
       Entries after the head are shifted back by 1.
       The list's size is decremented by 1.
       @return the head object that is removed from the list.
       @throws  IndexOutOfBoundsException if list is empty.*/
   public T deleteHead();

  /** Delete and return the Tail entry.
       Entries before the tail are unaffected.
       The list's size is decremented by 1.
       @return the tail object that is removed from the list.
       @throws  IndexOutOfBoundsException if list is empty.*/
   public T deleteTail();

  /** Display the content of the list.
       Entries are not affected.
       list size are unaffected.*/
   public void display();

  /** Return the position of the the entry that was found. -1 if not found
       Entries are not affected.
       list size are unaffected.
       @param anEntry the object to be searched in the list to see if it's in the list
       @return the integer index of the element found in the list*/ 
   public int contains(T anEntry);

  /** Determine if the list is empty or not
       Entries are not affected.
       list size are unaffected.
       @return boolean indicating whether the list is empty or not*/ 
   public boolean isEmpty();

  /** Determine if the list is full or not
       Entries are not affected.
       list size are unaffected.
       @return boolean indicating whether the list is full or not*/  
   public boolean isFull();
  
} // end EntryWaylistInterface
