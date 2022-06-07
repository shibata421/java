package controle;

import javax.swing.JOptionPane;

public class DesafioDiaSemana {

	public static void main(String[] args) {

		String dia = JOptionPane.showInputDialog("Digite o dia da semana:");
		int numeroDoDia;

		if (dia.toUpperCase().equals("DOMINGO")) {
			numeroDoDia = 1;
		} else if (dia.toUpperCase().equals("SEGUNDA")) {
			numeroDoDia = 2;
		} else if (dia.toUpperCase().replace('C', '�').equals("TER�A")) {
			numeroDoDia = 3;
		} else if (dia.toUpperCase().equals("QUARTA")) {
			numeroDoDia = 4;
		} else if (dia.toUpperCase().equals("QUINTA")) {
			numeroDoDia = 5;
		} else if (dia.toUpperCase().equals("SEXTA")) {
			numeroDoDia = 6;
		} else if (dia.toUpperCase().replace('A', '�').equals("S�BADO")) {
			numeroDoDia = 7;
		} else {
			numeroDoDia = -1;
		}
		
		System.out.println("O n�mero equivalente ao dia da semana digitado � " + numeroDoDia);;
	}
}
