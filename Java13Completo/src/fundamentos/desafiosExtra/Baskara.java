package fundamentos.desafiosExtra;

import java.util.Scanner;

public class Baskara {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o valor de a");
		double a = sc.nextDouble();

		System.out.println("Digite o valor de b");
		double b = sc.nextDouble();

		System.out.println("Digite o valor de c");
		double c = sc.nextDouble();
		
		double delta = Math.pow(b, 2) - 4 * a * c;
		double x1 = (-b + Math.sqrt(delta))/(2 * a);
		double x2 = (-b - Math.sqrt(delta))/(2 * a);
		
		System.out.printf("%.1fx^2 + (%.1f)x + (%.1f) = 0\n", a, b, c);
		System.out.printf("x1 = %.1f, x2 = %.1f", x1, x2);
		
		sc.close();
	}
}
