package arrays;

import java.util.Scanner;

public class DesafioArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Quantas notas você quer informar? ");
		int n = sc.nextInt();
		
		double[] notas = new double[n];
		
		for (int i = 0; i < notas.length; i++) {
			System.out.printf("Digite a %dª nota: ", (i + 1));
			notas[i] = sc.nextDouble();
		}
		
		double soma = 0;
		for (double nota: notas) {
			soma += nota;
		}
		
		double media = soma/notas.length;
		
		System.out.println("A média do aluno é: " + media);

		sc.close();
		
	}
}
