package fundamentos;

import java.util.Scanner;

public class DesafioConversao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o primeiro salário");
		String salario1String = sc.nextLine();
		System.out.println("Digite o segundo salário");
		String salario2String = sc.nextLine();
		System.out.println("Digite o terceiro salário");
		String salario3String = sc.nextLine();
		
		Double salario1 = Double.parseDouble(salario1String.replace(',', '.'));
		Double salario2 = Double.parseDouble(salario2String.replace(',', '.'));
		Double salario3 = Double.parseDouble(salario3String.replace(',', '.'));
		
		Double media = (salario1 + salario2 + salario3) / 3.0;
		
		System.out.println("A média dos últimos salários é " + media);
		
		sc.close();
		
		
	}
}
