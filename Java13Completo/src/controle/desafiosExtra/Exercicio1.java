package controle.desafiosExtra;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um n�mero: ");
		int numero = sc.nextInt();
		
		if (numero >= 0 && numero <= 10) {
			System.out.println("O n�mero est� dentro do intervalo [0, 10]");
		} else {
			System.out.println("O n�mero est� fora do intervalo [0, 10]");
		}
		
		if (numero % 2 == 0)  {
			System.out.println("O n�mero � par");
		} else {
			System.out.println("O n�mero � impar");
		}
		
		sc.close();
		
	}

}
