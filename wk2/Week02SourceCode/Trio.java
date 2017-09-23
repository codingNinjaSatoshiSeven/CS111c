
import java.util.*;
public class Trio<T extends Comparable<? super T>> implements Comparable<Trio <T>>{
	private T item1, item2, item3;

	public Trio(T item1, T item2, T item3){
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	//getters
	public T getItem1(){
		return this.item1;
	}
	public T getItem2(){
		return this.item2;
	}
	public T getItem3(){
		return this.item3;
	}

	//setters
	public void setItem1(T item1){
		this.item1 = item1;
	}
	public void setItem2(T item2){
		this.item2 = item2;
	}
	public void setItem3(T item3){
		this.item3 = item3;
	}

	@Override
	public String toString(){
		String s = "The trio contains item: \n";
		s += "item 1: " + this.item1 + "\n";
		s += "item 2: " + this.item2 + "\n";
		s += "item 3: " + this.item3 + "\n";
		return s;
	}

	public boolean contains(T targetItem){
		return 
		this.item1.equals(targetItem)
		|| this.item2.equals(targetItem)
		|| this.item3.equals(targetItem);
	}

	public boolean sameItems(){
		return this.item1.equals(this.item2) 
		&& this.item2.equals(this.item3) 
		&& this.item3.equals(this.item1);
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof Trio) {
			Trio<?> otherTrio = (Trio<?>) other;
			
			return allEquals(otherTrio);		
		} else {
			return false;
		}
		
	}


	@Override
	public int compareTo(Trio<T> otherTrio){
		T mySmallest = findSmallest(this);
		T otherSmallest = findSmallest(otherTrio);
	
		return mySmallest.compareTo(otherSmallest);	
	}

	/* private helper methods */
	private boolean allEquals(Trio<?> otherTrio){
		if( (this.getItem1().equals(otherTrio.getItem1()) &&this.getItem2().equals(otherTrio.getItem2()) && this.getItem3().equals(otherTrio.getItem3()))
			||(this.getItem1().equals(otherTrio.getItem1()) &&this.getItem2().equals(otherTrio.getItem3()) && this.getItem3().equals(otherTrio.getItem2()))
			||(this.getItem1().equals(otherTrio.getItem2()) &&this.getItem2().equals(otherTrio.getItem3()) && this.getItem3().equals(otherTrio.getItem1()))
			||(this.getItem1().equals(otherTrio.getItem2()) &&this.getItem2().equals(otherTrio.getItem1()) && this.getItem3().equals(otherTrio.getItem3()))
			||(this.getItem1().equals(otherTrio.getItem3()) &&this.getItem2().equals(otherTrio.getItem2()) && this.getItem3().equals(otherTrio.getItem1()))
			||(this.getItem1().equals(otherTrio.getItem3()) &&this.getItem2().equals(otherTrio.getItem1()) && this.getItem3().equals(otherTrio.getItem2()))
		  ){
			return true;
		} else {
			return false;
		}
	}

	private T findSmallest(Trio<T> myTrio){
		T smallest = myTrio.item1;
		smallest = smallest.compareTo(myTrio.item2) > 0 ? myTrio.item2 : smallest;	
		smallest = smallest.compareTo(myTrio.item3) > 0 ? myTrio.item3 : smallest;
		
		return smallest;
	}
}