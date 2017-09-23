import java.util.*;
public class StudentDriver
{
	public static void main(String[] args)
	{
		// Without Generics
		// my compiler wont execute the generic code , unless run with javac StudentDriver -Xlint:unchecked
		Student student1 = new Student("John", "Doe", 123);
		Student student2 = new Student("Jane", "Doe", 124);
		Student student3 = new Student("Bob", "Doe", 235);

		ArrayList students = new ArrayList();
		students.add(student1);
		students.add(student2);
		students.add(student3);

		for (int i=0; i< students.size();i++){
			if (students.get(i) instanceof Student){
				Student student = (Student) students.get(i);
				System.out.println("The student id is "+ student.getStudentID());
			}
		}
		

		// With Generics
		
		Student gstudent1 = new Student("John", "Doe", 123);
		Student gstudent2 = new Student("Jane", "Doe", 124);
		Student gstudent3 = new Student("Bob", "Doe", 235);

		ArrayList<Student> gstudents = new ArrayList<Student>();
		gstudents.add(gstudent1);
		gstudents.add(gstudent2);
		gstudents.add(gstudent3);

		for (int i=0; i< gstudents.size();i++){
			System.out.println("The student id is "+ gstudents.get(i).getStudentID());
		}
		
	}
}