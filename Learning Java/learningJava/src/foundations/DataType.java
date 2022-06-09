package foundations;

import java.util.Scanner;

public class DataType {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Write the student's GPA: ");
		double gpa = sc.nextDouble();
		
		int studentAge = 15;
		boolean hasPerfectAttendance = true;
		String studentFirstName = "Kayla";
		String studentLastName = "Hammon";
		char studentFirstInitial = studentFirstName.charAt(0);
		char studentLastInitial = studentLastName.charAt(0);
		
		System.out.println("The student age is " + studentAge);
		System.out.println("The student GPA is " + gpa);
		System.out.println("The student has perfect attendance? " + hasPerfectAttendance);
		System.out.println("The student is " + studentFirstName + " " + studentLastName);
		System.out.println("The student First Initial is " + studentFirstInitial);
		System.out.println("The student Last Initial is " + studentLastInitial);
		
		sc.close();
	}
}
