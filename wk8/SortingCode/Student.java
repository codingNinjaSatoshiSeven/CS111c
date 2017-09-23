public class Student implements java.io.Serializable, Comparable { 
	private String name;
	private String id;
	private double tuition;

	public Student(String name, String id, double tuition) {
		this.name = name;
		this.id = id;
		this.tuition = tuition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTuition() {
		return tuition;
	}
	public void setTuition(double tuition) {
		if(tuition >= 0) {
			this.tuition = tuition;
		}
	}
	@Override
	public String toString() {
		String s = "Name: " + name + " (" + id + ")";
		return s;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Student) {
			Student otherStudent = (Student) obj;
			return id.compareTo(otherStudent.id);
		} else {
			return -1;
		}
	}
	
}
