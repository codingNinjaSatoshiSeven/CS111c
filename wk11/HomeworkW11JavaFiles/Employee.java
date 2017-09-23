
public class Employee {
	
	private String firstName, lastName, id;
	private boolean bonus; // whether the Employee is eligible for a bonus

	public Employee(String firstName, String lastName, String id, boolean bonus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.bonus = bonus;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isBonus() {
		return bonus;
	}
	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Employee: " + lastName + ", " + firstName + " (ID: " + id + ")" +
				(bonus ? " (Eligible for Bonus)" : "");
	}
	
	

}
