package fundamentos.desafiosExtra;

import java.util.Scanner;

public class CalculadoraDeIMC {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a altura");
		double altura = sc.nextDouble();

		System.out.println("Digite o peso");
		double peso = sc.nextDouble();
		
		double imc = peso/Math.pow(altura, 2);
		
		System.out.printf("O seu IMC é %.2f", imc);
		
		sc.close();
	}
}
