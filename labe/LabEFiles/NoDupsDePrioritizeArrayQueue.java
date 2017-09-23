import java.util.Arrays;

public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T> 
	implements NoDupsDePrioritizeQueueInterface<T> {


	public NoDupsDePrioritizeArrayQueue() {
		super();
	} 
	public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
		super(initialCapacity);
	} 

	@Override
	public void enqueue(T newEntry) {
		boolean canAdd = true;
		if (super.isEmpty()){ // if empty, just enqueue
			super.enqueue(newEntry);
		} else {
			if (!newEntry.equals(queue[backIndex])){ // if the newentry doesn't equal to the entry at backIndex
		    for (int i = frontIndex; i != backIndex; i = (i + 1)
							% queue.length) { // try to find if the newEntry match any other entry in the queue
		        if (newEntry.equals(queue[i])) {
		            canAdd = false;
		            break;
		        }
		    }
		    if (canAdd) { // if not matching, enqueue it
		        super.enqueue(newEntry);
		    }
			} 
	    // if newEntry matches entry at backIndex, don't do anything.
		}
    
	} 
	
	public void moveToBack(T entry) {
		T element = null;
		boolean inQueue = false;
    int foundIndex = 0;
    if (super.isEmpty()){ // if queue is empty, just enqueue it
			super.enqueue(entry);
		} else { // queue not empty
			if (entry.equals(queue[backIndex])) { // if entry matches the entry at backIndex,
			// don't need to move back, already in the back
				foundIndex = backIndex;
				return;
			}
			// if still not returned at this point, meaning if entry doesn't match entry at backIndex
			// then we search for the rest of the queue for this entry
	    for (int i = frontIndex; i != backIndex; i = (i + 1)
						% queue.length) { 
	        if (entry.equals(queue[i])) { // if found, record foundIndex
	            inQueue = true;
	            foundIndex = i; 
	            break;
	        }
	    }
	    if (inQueue) { // if found match
				queue[foundIndex] = null; // remove the found element
				for (int i= foundIndex; i != backIndex; i = (i + 1)
						% queue.length) { // shift each element over by 1 spot
					queue[i] = queue[i+1];
				}
				backIndex--;
				super.enqueue(entry);
	    } else { // if not found match
	    	super.enqueue(entry);
	    }
		}
    

	}

	public void display() {
		System.out.print("FRONT ");
		if (frontIndex < backIndex){
			for (int i=frontIndex; i<=backIndex; i++){
				System.out.print(queue[i] + " ");
			}
		} else {
			for (int i=frontIndex; i!=backIndex; i = (i + 1)
						% queue.length){
				System.out.print(queue[i] + " ");
			}
			System.out.print(queue[backIndex] + " ");
		}
		System.out.println("BACK");
    
	} 


}