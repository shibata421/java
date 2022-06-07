package controle;

import java.util.Scanner;

public class DesafioWhile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double nota = 0;
		double total = 0;
		int contador = 0;
		double media;
		
		while (nota != -1) {
			System.out.print("Digite a nota do aluno: ");
			nota = sc.nextDouble();
			if (nota >= 0 && nota <= 10) {
				total += nota;
				contador++;
			} else if (nota == -1){
				
			} else {
				System.out.println("Nota inválida");
			}
		}
		
		media = total / contador;
		System.out.printf("A média da turma é %.1f", media);
		sc.close();
	}
}
