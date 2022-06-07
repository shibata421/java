package fundamentos.desafiosExtra;

import java.util.Scanner;

public class DeFahrenheitParaCelcius {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma temperatura em Fahrenheit");
		double tFahrenheit = sc.nextDouble();
		
		double tCelcius = (5.0 / 9.0)*(tFahrenheit - 32.0);
		
		System.out.println("O equivalente em  Celcius é " + tCelcius);
		
		sc.close();
	}
}
