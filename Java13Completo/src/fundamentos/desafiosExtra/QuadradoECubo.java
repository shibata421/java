package fundamentos.desafiosExtra;

import java.util.Scanner;

public class QuadradoECubo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um valor");
		double valor = sc.nextDouble();

		double quadrado = Math.pow(valor, 2);
		double cubo = Math.pow(valor, 3);
		
		System.out.printf("O valor ao quadrado é %.2f e o valor aor cubo é %.2f", quadrado, cubo);
		
		sc.close();
	}
}
