public class Documentary extends Movie {
 private String topic;

 public Documentary(String myTitle, int myReleaseYear, String myTopic){
 	super(myTitle, myReleaseYear);
 	this.topic = myTopic;
 }

 public Documentary(String myTitle, String myTopic){
 	super(myTitle);
 	this.topic = myTopic;
 }

 public String getTopic(){
 	return this.topic;
 }

 public void setTopic(String myTopic){
 	this.topic = myTopic;
 }

 @Override
 public String toString(){
 	String s= super.toString();
 	s +=  " and topic of "+ this.topic;
 	return s;
 }
}