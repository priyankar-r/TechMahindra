package week3task1;

import java.util.*;

public class studentMarkProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<studentMarksheet> students = new ArrayList<>();

		// Get the number of students
		System.out.print("enter the number of students: ");
		int numStudents = sc.nextInt();
		sc.nextLine(); 

		// loop to get student details
		for (int i = 0; i < numStudents; i++) {
			System.out.println("\nenter details for student " + (i + 1) + ":");
			System.out.print("name: ");
			String name = sc.nextLine();

			// get the number of subjects
			System.out.print("enter the number of subjects: ");
			int numSubjects = sc.nextInt();
			sc.nextLine();

			// get marks for each subject
			List<Integer> marks = new ArrayList<>();
			for (int j = 0; j < numSubjects; j++) {
				System.out.print("enter marks for subject " + (j + 1) + ": ");
				marks.add(sc.nextInt());
			}
			sc.nextLine(); 

			// create a studentMarksheet object
			students.add(new studentMarksheet(name, marks));
		}

		// sort students by total marks
		Collections.sort(students, Comparator.comparingInt((studentMarksheet s) -> s.totalMarks).reversed());

		// print the sorted list
		System.out.println("sorted list of students by total marks:");
		for (studentMarksheet student : students) {
			System.out.println(student);
		}

		// close the scanner class
		sc.close();
	}
}
