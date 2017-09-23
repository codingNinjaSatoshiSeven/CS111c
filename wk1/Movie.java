
import java.util.*;

public class Movie implements Comparable<Movie>{
 private String title;
 private int releaseYear;
 public static final int CURRENT_YEAR = 2016;

 public Movie(String myTitle, int myReleaseYear){
 	this.title = myTitle;
 	this.releaseYear = myReleaseYear;
 }
 
 public Movie(String myTitle){
 	this.title = myTitle;
 	this.releaseYear = CURRENT_YEAR;
 }

 public String getTitle(){
 	return this.title;
 }

 public int getReleaseYear(){
 	return this.releaseYear;
 }

 public void setTitle(String myTitle){
 	this.title = myTitle;
 }

 public void setReleaseYear(int myReleaseYear){
 	if (myReleaseYear >=0){
 		this.releaseYear = myReleaseYear;
 	} else {
 		System.out.println("Invalid release year");
 	}
 }

 @Override
 public String toString(){
 	String s ="This movie has";
 	s += " title of "+ this.title;
 	s += " , and release year of " + this.releaseYear;
 	return s;
 }

 @Override 
 public boolean equals(Object obj)
 {
 	if(obj instanceof Movie) {
 		Movie otherObject = (Movie) obj;
 		if (otherObject.getTitle().equalsIgnoreCase(this.getTitle())
 			&& otherObject.getReleaseYear() == this.getReleaseYear()
 			) {
 			return true; 
 		} else {
 			return false;
 		}
 	} else {
 	    return false;
 	}
 }

@Override
public int compareTo(Movie otherMV) 
{
	if(this.getTitle().equalsIgnoreCase(otherMV.getTitle())) {
		// if the title are the same, order by release year
		return this.releaseYear - otherMV.releaseYear;
	} else {
		// if the title are different, order by title
		return this.getTitle().compareToIgnoreCase(otherMV.getTitle());
	}
}
}