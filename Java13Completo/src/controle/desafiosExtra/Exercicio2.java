package controle.desafiosExtra;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite um ano:");
		int ano = sc.nextInt();
		
		if (ano % 4 == 0) {
			if (ano % 100 == 0) {
				System.out.println("O ano n�o � bissexto");
			} else {
				System.out.println("O ano � bissexto");
			}
		} else {
			if (ano % 400 == 0) {
				System.out.println("O ano � bissexto");
			} else {
				System.out.println("O ano n�o � bissexto");
			}
		}
		sc.close();
	}
	
}
