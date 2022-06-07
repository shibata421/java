package controle.desafiosExtra;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int numero = sc.nextInt();
		
		if (numero >= 0 && numero <= 10) {
			System.out.println("O número está dentro do intervalo [0, 10]");
		} else {
			System.out.println("O número está fora do intervalo [0, 10]");
		}
		
		if (numero % 2 == 0)  {
			System.out.println("O número é par");
		} else {
			System.out.println("O número é impar");
		}
		
		sc.close();
		
	}

}
