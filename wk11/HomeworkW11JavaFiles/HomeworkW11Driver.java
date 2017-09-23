import java.util.*;

public class HomeworkW11Driver {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<>();

		fillEmployees(employeeList);
		
		HashMap<String, Employee> employeeHash = getEmployeeHash(employeeList);
		System.out.println("The hash should have 61 entries:" + employeeHash.size());

		
		ArrayList<String> employeeIDList = new ArrayList<>(Arrays.asList(new String[] {"AZ14", "AD64", "AF67", "ARHC", "ALH1", "AC48", "AGB1", "AS1G", "BDC1", "BD31", "BMJ7", "DM78", "BT67", "BB53", "CN6S", "CB41", "CGG3", "ER39", "FW36", "F613", "HM01", "HW32", "JR63", "KT13", "KA74", "LK71", "LW13", "PTC8", "PR94", "PW17", "SC89", "TM44", "XP90", "ZP91", "XB44"}));

		ArrayList<Employee> bonusList = getEmployeeBonusList(employeeHash, employeeIDList);
		System.out.println("The list should have 16 entries: " + bonusList.size());
		System.out.println(bonusList);
		/*
		Student s1 = new Student("S", "L", true, 4.0);
		Student s2 = new Student("S", "L", true, 4.0);
		Student s3 = new Student("S", "L", true, 3.0);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		*/
	}
	
	public static HashMap<String, Employee> getEmployeeHash(ArrayList<Employee> employeeList) {
		HashMap<String, Employee> myHash =  new HashMap<String, Employee>();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee temp = employeeList.get(i);
			myHash.put(temp.getId(), temp);
		}
		return myHash;
	}
	public static ArrayList<Employee> getEmployeeBonusList(HashMap<String, Employee> employeeMap, ArrayList<String> employeeIDs) {
		ArrayList<Employee> myArray = new ArrayList<Employee>();
		for (int i = 0; i < employeeIDs.size(); i++) {
			String employeeID = employeeIDs.get(i);
			Employee currentEmployee = employeeMap.get(employeeID);
			if (currentEmployee !=null && currentEmployee.isBonus() == true){
				myArray.add(currentEmployee);
			}
		}
		return myArray;
	}
	public static void fillEmployees(ArrayList<Employee> empList) {
		empList.add(new Employee("Adam", "Zapel", "AZ14", true));
		empList.add(new Employee("Al", "Dente", "AD62", false));
		empList.add(new Employee("Al", "Fresco", "AF67", true));
		empList.add(new Employee("Al K. ", "Seltzer","ASG1",  false));
		empList.add(new Employee("Alf A.", "Romeo", "ARHC", true));
		empList.add(new Employee("Amanda", "Lynn", "ALH1", false));
		empList.add(new Employee("Anita", "Job", "AJ71", true));
		empList.add(new Employee("Anna", "Conda", "AC4G", true));
		empList.add(new Employee("Anna", "Graham", "AGB1", false));
		empList.add(new Employee("Anna", "Prentice", "APL2", true));
		empList.add(new Employee("Anna", "Sasin", "AS1G", true));
		empList.add(new Employee("Anne", "Teak", "ATH9", false));
		empList.add(new Employee("B.A.", "Ware", "BW90", true));
		empList.add(new Employee("Barb", "Dwyer", "BDC1", true));
		empList.add(new Employee("Barb E.", "Dahl", "BD31", false));
		empList.add(new Employee("Barbara", "Seville", "BS20", true));
		empList.add(new Employee("Barry", "Cade", "BCG5", true));
		empList.add(new Employee("Bea", "Minor", "BMJ7", false));
		empList.add(new Employee("Dee", "Major", "DM78", true));
		empList.add(new Employee("Beau", "Tye", "BT65", true));
		empList.add(new Employee("Bill", "Board", "BB53", false));
		empList.add(new Employee("Cara", "Van", "CV62", true));
		empList.add(new Employee("Chris P.", "Bacon", "CPA1", true));
		empList.add(new Employee("Constance", "Noring", "CN6T", true));
		empList.add(new Employee("Crystal", "Ball", "CB41", true));
		empList.add(new Employee("Crystal", "Glass", "CGG4", false));
		empList.add(new Employee("Earl Lee", "Riser", "ER39", true));
		empList.add(new Employee("Easton", "West", "EW12", false));
		empList.add(new Employee("Ferris", "Wheeler", "FW36", false));
		empList.add(new Employee("Flint", "Sparks", "F613", true));
		empList.add(new Employee("Franklin", "Stein", "FS13", true));
		empList.add(new Employee("Gene", "Poole", "GP19", false));
		empList.add(new Employee("Heidi", "Clare", "HC84", true));
		empList.add(new Employee("Helen", "Back", "HBB5", true));
		empList.add(new Employee("Helen", "Wiells", "HW03", true));
		empList.add(new Employee("Holly", "McRell", "HM00", true));
		empList.add(new Employee("Holly", "Wood", "HW32", true));
		empList.add(new Employee("Jack", "Pott", "JP87", true));
		empList.add(new Employee("Joe", "Kerr", "JK87", true));
		empList.add(new Employee("Joy", "Rider", "JR64", true));
		empList.add(new Employee("Justin", "Case", "JCT1", true));
		empList.add(new Employee("Justin", "Time", "JT13", true));
		empList.add(new Employee("Kandi", "Apple", "KA74", true));
		empList.add(new Employee("Laura", "Norder", "LNB4", false));
		empList.add(new Employee("Leigh", "King", "LK71", true));
		empList.add(new Employee("Luke", "Warm", "LW13", true));
		empList.add(new Employee("Marsha", "Mellow", "MM44", false));
		empList.add(new Employee("Marshall", "Law", "MLQ3", true));
		empList.add(new Employee("Marty", "Graw", "MG63", true));
		empList.add(new Employee("Olive", "Branch", "OB63", false));
		empList.add(new Employee("Paige", "Turner", "PTC8", true));
		empList.add(new Employee("Pepe", "Roni", "PR94", true));
		empList.add(new Employee("Price", "Wright", "PW17", true));
		empList.add(new Employee("Rocky", "Beach", "RB12", true));
		empList.add(new Employee("Sandy", "Beach", "SB12", true));
		empList.add(new Employee("Sal A.", "Mander", "SM62", true));
		empList.add(new Employee("Stanley", "Cupp", "SC89", false));
		empList.add(new Employee("Tom", "Morrow", "TM43", true));
		empList.add(new Employee("Warren", "Peace", "WP90", true));
		empList.add(new Employee("Will", "Power", "WP91", false));
		empList.add(new Employee("X.", "Benedict", "XB43", true));

		
	}

}
