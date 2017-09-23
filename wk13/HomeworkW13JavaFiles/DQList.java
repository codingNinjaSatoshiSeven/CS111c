public class DQList<T> implements DequeInterface<T>{
  private ListInterface list;

  public DQList() {
    list = new LList<T>();
  }

  public void addToFront(T newEntry){
    list.add(1, newEntry);
  }

  public void addToBack(T newEntry){
    list.add(newEntry); 
  }

  public T removeFront(){
    return (T)list.remove(1);
  }

  public T removeBack(){
    return (T)list.remove(list.getLength());
  }

  public T getFront(){
    return (T)list.getEntry(1);
  }

  public T getBack(){
    return (T)list.getEntry(list.getLength());
  }

  public boolean isEmpty(){
    return list.isEmpty();
  }

  public void clear(){
    list.clear();
  }

  public void display(){
    ((LList<T>)list).display();
  }
}

