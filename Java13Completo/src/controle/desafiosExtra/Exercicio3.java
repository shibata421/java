package controle.desafiosExtra;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a primeira nota: ");
		double nota1 = sc.nextDouble();
		System.out.println("Digite a segunda nota: ");
		double nota2 = sc.nextDouble();
		
		double media = (nota1 + nota2) / 2.0;
		
		if (media >= 7.0) {
			System.out.println("Aprovado");
		} else if (media >= 4.0){
			System.out.println("Recuperação");
		} else {
			System.out.println("Reprovado");
		}
		
		sc.close();
	}
}
