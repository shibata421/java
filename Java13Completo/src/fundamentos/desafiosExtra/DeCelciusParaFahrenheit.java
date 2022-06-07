package fundamentos.desafiosExtra;

import java.util.Scanner;

public class DeCelciusParaFahrenheit {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma temperatura em Celcius");
		double tCelcius = sc.nextDouble();
		
		double tFahrenheit = (tCelcius * 9.0/5.0) + 32.0;
		
		System.out.println("O equivalente em Fahrenheit é " + tFahrenheit);
		
		sc.close();
	}
}
