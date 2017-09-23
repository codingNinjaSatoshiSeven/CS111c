/** An interface for the Book pile list that allow user to add and remove book from top.
    Entries in this list have positions that begin with 1.

    @author Shengtao Li
    @version 1.0
*/
public interface BookPileInterface<T>
{
	/** Adds a new book object to the top of this pile.
	     Entries that are currently in the list are shifted to back by 1.
	     The list's size is increased by 1.
	     @param newBook  The book object to be inserted on top.*/
	public void insertBookOnTop(T newBook);

	/** Remove the top book from the book pile.
	     Entries that are currently in the list are shifted forward by 1.
	     The list's size is decreased by 1.
	     @return object of the top book removed.
	     throws IndexOutOfBoundsException if book pile is empty.*/
	public T removeTopBook();

	/** Return (but no remove) the top book from the book pile.
	     Entries that are currently in the list are unaffected.
	     The list's size is not affected.
	     @return object of the top book removed.
	     throws IndexOutOfBoundsException if book pile is empty.*/
	public T peekBookOnTop();

	/** Determine if the book pile is empty or not
       Entries are not affected.
       list size are unaffected.
       @return boolean indicating whether the book pile is empty or not*/ 
	public boolean isEmpty();

	/** Clear all the content of the book pile
       Entries are all deleted
       list size are set to 0.*/
	public void clear();
}// end BookPileInterface