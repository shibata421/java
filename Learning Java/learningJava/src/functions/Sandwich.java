package functions;

import java.util.Scanner;

public class Sandwich {

	public static void announceDeveloperTeaTime() {
		System.out.println("Waiting for developer tea time...");
		System.out.println("Type in a random word and press Enter to start developer tea time");
		Scanner input = new Scanner(System.in);
		input.next();
		System.out.println("It's developer tea time!");
		input.close();
				
	}
	
	public static void main(String[] args) {
		announceDeveloperTeaTime();
	}
}
