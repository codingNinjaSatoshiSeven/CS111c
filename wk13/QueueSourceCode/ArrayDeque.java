
public class ArrayDeque<T> implements DequeInterface<T> {

	private T[] deque; // circular array of queue entries and one unused location
	private int frontIndex;
	private int backIndex;

	private static final int DEFAULT_INITIAL_CAPACITY = 50;

	public ArrayDeque() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ArrayDeque(int initialCapacity) {
		deque = (T[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	}

	public void addToBack(T newEntry) { // same as ArrayQueue enqueue
		if (isArrayFull())
			doubleArray();

		backIndex = (backIndex + 1) % deque.length;
		deque[backIndex] = newEntry;
	}

	public void addToFront(T newEntry) {
		if( isArrayFull()) 
			doubleArray();
		
		frontIndex = (frontIndex - 1 + deque.length) % deque.length;
		deque[frontIndex] = newEntry;
	}

	public T getFront() { // same as ArrayQueue
		T front = null;

		if (!isEmpty())
			front = deque[frontIndex];

		return front;
	}

	public T getBack() {
		T back = null;
		
		if(!isEmpty()) 
			back = deque[backIndex];
		
		return back;
	}

	public T removeFront() { // same as ArrayQueue dequeue
		T front = null;

		if (!isEmpty()) {
			front = deque[frontIndex];
			deque[frontIndex] = null;
			frontIndex = (frontIndex + 1) % deque.length;
		}

		return front;
	}

	public T removeBack() {
		T back = null;
		
		if(!isEmpty()) {
			back = deque[backIndex];
			deque[backIndex] = null;
			backIndex = (backIndex - 1 + deque.length) % deque.length;
			
		}
		
		return back;
	}

	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % deque.length);
	}

	public void clear() {
		if (!isEmpty()) { // deallocates only the used portion
			for (int index = frontIndex; index != backIndex; index = (index + 1) % deque.length) {
				deque[index] = null;
			}
			deque[backIndex] = null;
		}
		frontIndex = 0;
		backIndex = deque.length - 1;
	}

	private boolean isArrayFull() {
		return frontIndex == ((backIndex + 2) % deque.length);
	}

	private void doubleArray() {
		T[] oldQueue = deque;
		int oldSize = oldQueue.length;

		deque = (T[]) new Object[2 * oldSize];

		for (int index = 0; index < oldSize - 1; index++) {
			deque[index] = oldQueue[frontIndex];
			frontIndex = (frontIndex + 1) % oldSize;
		}

		frontIndex = 0;
		backIndex = oldSize - 2;
	}

}
