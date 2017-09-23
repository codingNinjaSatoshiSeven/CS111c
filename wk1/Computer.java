
import java.util.*;

public class Computer {
 private String brand, name, memory;
 public static final String NOT_PROVIDED = "NOT PROVIDED";

 public Computer() { // default constructor 
 	this.brand = NOT_PROVIDED;
 	this.name = NOT_PROVIDED;
 	this.memory = NOT_PROVIDED;
 } 

 public Computer(String brandName, String name, String memory) {
 	this.brand = brandName;
 	this.name = name;
 	this.memory = memory;
 } 

 //getters
 public String getBrand(){
 	return this.brand;
 }

 public String getName(){
 	return this.name;
 }

 public String getMemory(){
 	return this.memory;
 }

 // setters
 public void setBrand(String brandName){
 	this.brand = brandName;
 }

 public void setName(String name){
 	this.name = name;
 }

 public void setMemory(String mem){
 	memory = mem;
 }

 // toString method
 @Override
 public String toString(){
 	String s = "This computer is ";
 	s += this.brand + " brand, ";
 	s += this.name +" name, ";
 	s += this.memory + " memory.";
 	return s;
 }

 // equals method
 @Override 
 public boolean equals(Object obj)
 {
 	if(obj instanceof Computer) {
 		Computer otherObject = (Computer) obj;
 		// compare whether ALL variables are the same
 		if (otherObject.getBrand().equals(this.getBrand())
 			&& otherObject.getName() == this.getName()
 			&& otherObject.getMemory().equals(this.getMemory())
 			) {
 			return true; 
 		} else {
 			return false;
 		}
 	} else {
 	    return false;
 	}
 }
 
}