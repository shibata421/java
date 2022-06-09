package controlFlow;

import java.util.Scanner;

public class IfStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Write a number between 1 and 10: ");
		double yourNumber = sc.nextDouble();
		
		if(yourNumber < 5) {
			System.out.println("is less than five");
		} else {
			System.out.println("is not less than five");
		}
		
		sc.close();
	}
}
