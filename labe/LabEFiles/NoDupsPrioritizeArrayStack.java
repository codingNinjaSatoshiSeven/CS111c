
public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T>
	implements NoDupsPrioritizeStackInterface<T> {
	
	public NoDupsPrioritizeArrayStack() {
		super();
	} 
	public NoDupsPrioritizeArrayStack(int initialCapacity) {
		super(initialCapacity);
	} 

	@Override
	public void push(T newEntry) {
	    boolean canAdd = true;
	    for (int i = 0; i <= topIndex; i++) {
	        if (newEntry.equals(stack[i])) {
	            canAdd = false;
	        }
	    }
	    if (canAdd) {
	        super.push(newEntry);
	    }
	}

	public void moveToTop(T entry) {
    boolean inStack = false;
    int foundIndex = 0;
    for (int i = 0; i < topIndex && inStack != true; i++) { // checks all items on stack except for top, until found
        if (entry.equals(stack[i])) {
            inStack = true;
            foundIndex = i; // entry found, save index position
        }
    }
    if (inStack) {
        for (int i = foundIndex; i < topIndex; i++) {
            stack[i] = stack[i + 1]; // moves the rest of the stack down
        }
        stack[topIndex] = entry; // entry is put on top
    }
    else if (isEmpty()) {
        super.push(entry);
    }
    else if (!entry.equals(stack[topIndex])) { // if not empty, checks top entry for duplicate
        super.push(entry);
    }
  }


	public void display() {
	    System.out.print("BOTTOM ");
	    for (int i = 0; i <= topIndex; i++) {
	        System.out.print(stack[i] + " ");
	    }
	    System.out.println("TOP");
	}
	


} 