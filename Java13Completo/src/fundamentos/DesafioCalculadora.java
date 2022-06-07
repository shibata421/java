package fundamentos;

import javax.swing.JOptionPane;

public class DesafioCalculadora {

	public static void main(String[] args) {
		// Ler num1
		// Ler num 2
		// + - * / %

		String pane = JOptionPane.showInputDialog("digite um número");
		double num1 = Double.parseDouble(pane);

		pane = JOptionPane.showInputDialog("digite outro número");
		double num2 = Double.parseDouble(pane);

		pane = JOptionPane.showInputDialog("digite a operação ( +, - ,* , /, %)");
		char operacao = pane.charAt(0);

		boolean ehSoma = (operacao == '+');
		boolean ehSubtracao = (operacao == '-');
		boolean ehMultiplicacao = (operacao == '*');
		boolean ehDivisao = (operacao == '/');
		boolean ehMod = (operacao == '%');

		double resultado = ehSoma ? (num1 + num2) : 
			ehSubtracao ? (num1 - num2) : 
				ehMultiplicacao ? (num1 * num2)	: 
					ehDivisao ? (num1 / num2) : 
						ehMod ? (num1 % num2) : null;
		System.out.println(resultado);

	}
}
