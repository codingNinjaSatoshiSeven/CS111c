public class DequeQueue<T> implements QueueInterface<T>{
  private DequeInterface<T> deque; // front of the deque is the top of my stack
  private int capacity;
  private int currentSize;

  public DequeQueue() {
    deque = new LinkedDeque<T>();
    this.capacity = 10;
    this.currentSize = 0;
  }

  public void enqueue(T newEntry){
    if (currentSize<capacity){
      deque.addToBack(newEntry);
      currentSize++;
    } else {
      deque.removeFront();
      deque.addToBack(newEntry);
    }

  }
  
  public T dequeue(){
    T top = null;
    if(!isEmpty()) {
      top = deque.removeFront();
      currentSize--;
    }
    return top;
  }
  
  public T getFront(){
    return deque.getFront();
  }
  
  public boolean isEmpty(){
    return deque.isEmpty();
  }
  
  public void clear(){
    deque.clear();
    currentSize = 0;
  }

  public void display(){
    LinkedDeque<T> temp = (LinkedDeque<T>)deque;
    temp.print();
  }
}