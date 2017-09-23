
public class Student {
	
	private String firstName, lastName;
	private boolean tuitionPaid;
	private double gpa;

	public Student(String firstName, String lastName, boolean tuitionPaid, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tuitionPaid = tuitionPaid;
		this.gpa = gpa;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isTuitionPaid() {
		return tuitionPaid;
	}
	public void setTuitionPaid(boolean tuitionPaid) {
		this.tuitionPaid = tuitionPaid;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		if(gpa >= 0 && gpa <= 4) {
			this.gpa = gpa;
		}
	}

	public int hashCode(){
		String studentInfo = this.firstName + this.lastName + this.gpa;
		int asciiSum=0;
		for (int i=0; i<studentInfo.length(); i++){
			asciiSum += (int) studentInfo.charAt(i);
		}
		return asciiSum % 100;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + 
				"\n\tTuition Paid: " +  tuitionPaid +
				"\n\tGPA: " + gpa;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Student) {
			Student other = (Student) obj;
			return this.firstName.equals(other.firstName)
			&& this.lastName.equals(other.lastName)
			&& this.gpa == other.gpa
			&& this.tuitionPaid == other.tuitionPaid;	
		} else {
			return false;
		}
	}
	
	

}
