package br.com.caelum.matematica;

public class AnoBissexto {

	public boolean ehBissexto(int ano) {
		if(ano % 4 != 0) {
			return false;
		} else if (ano % 100 == 0) {
			if(ano % 400 != 0) {
				return false;				
			} 
		}
		return true;
	}
}
