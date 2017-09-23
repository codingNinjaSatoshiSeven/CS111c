import java.util.*;
public class Box<T extends Comparable<? super T>> implements Comparable<Box<T>> {
	
	private T thing;
	private int thingCount;
	private ArrayList<T> oldThings;
	
	public Box(T firstThing) {
		this.thing = firstThing;
		this.thingCount = 1;
		
		this.oldThings = new ArrayList<T>(5);
		this.oldThings.add(this.thing);
		
	}
	
	public T getContents() {
		return thing;
	}
	public int getCount() {
		return thingCount;
	}

	public ArrayList<T> getHistory(){
		return this.oldThings;
	}
	
	public void replaceContents(T newThing) {
		this.thing = newThing;
		this.oldThings.add(newThing);
		thingCount++;
	}
	
	@Override
	public String toString() {
		return thing.toString() + " (item " + thingCount + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Box<?>) {
			Box<?> otherBox = (Box<?>) other;
			
			boolean sameThing = this.thing.equals(otherBox.thing);
			boolean sameCount = this.thingCount==otherBox.thingCount;
			
			return sameThing && sameCount;
			
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Box<T> otherBox) {
		if(this.thing.compareTo(otherBox.thing)==0) {
			return Integer.compare(this.thingCount, otherBox.thingCount);
		} else {
			return this.thing.compareTo(otherBox.thing);	
		}
	
	}

}
