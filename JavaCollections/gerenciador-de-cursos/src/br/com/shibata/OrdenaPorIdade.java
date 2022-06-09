package br.com.shibata;

import java.util.Comparator;

public class OrdenaPorIdade implements Comparator<Funcionario> {
	
	private static final OrdenaPorIdade instance = new OrdenaPorIdade();
	private OrdenaPorIdade() {}
	
	public static OrdenaPorIdade getInstance() {
		return instance;
	}
	
	@Override
	public int compare(Funcionario f1, Funcionario f2) {
		return Integer.compare(f1.getIdade(), f2.getIdade());
	}
}
