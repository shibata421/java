package fundamentos.desafiosExtra;

import java.util.Scanner;

public class AreaTriangulo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a base");
		double base = sc.nextDouble();

		System.out.println("Digite a altura");
		double altura = sc.nextDouble();
		
		double area = base * altura / 2.0;
		
		System.out.printf("O valor da área do triângulo é %.2f", area);
		
		sc.close();
	}
}
