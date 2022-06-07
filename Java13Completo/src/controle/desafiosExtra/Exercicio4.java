package controle.desafiosExtra;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um n�mero maior que 1: ");
		int numero = sc.nextInt();
		int contador = 0;
		
		for (int i = 2; i <= numero; i++) {
			if (numero % i == 0) {
				contador++;
			}
		}
		
		if (contador == 1) {
			System.out.println("O n�mero � primo");
		} else {
			System.out.println("O n�mero n�o � primo");
		}

		sc.close();
	}
}
