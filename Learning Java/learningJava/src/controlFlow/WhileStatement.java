package controlFlow;

import java.util.Scanner;

public class WhileStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isOsRepeat = true;
		
		while(isOsRepeat) {
			System.out.println("Playing current song");
			System.out.print("Continue on repeat? ");
			String userInput = sc.next();
			
			if(userInput.equals("no")) {
				isOsRepeat = false;
			}
		}
		
		System.out.println("Playing next song");
		sc.close();
	}
}
