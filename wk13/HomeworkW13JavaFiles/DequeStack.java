public class DequeStack<T> implements StackInterface<T>{
  private DequeInterface<T> deque; // front of the deque is the top of my stack
  private int capacity;
  private int currentSize;

  public DequeStack() {
    deque = new LinkedDeque<T>();
    this.capacity = 10;
    this.currentSize = 0;
  }

  public void push(T newEntry){
    if(currentSize<capacity) {
      deque.addToFront(newEntry);
      currentSize++;
    } else {
      deque.removeBack();
      deque.addToFront(newEntry);
    }

  }
  
  public T pop(){
    T top = null;
    if(!isEmpty()) {
      top = deque.removeFront();
      currentSize--;
    }
    return top;
  }
  
  public T peek(){
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