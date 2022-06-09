package br.com.caelum.leilao.servico;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private OptionalDouble average;
	private List<Lance> lances;

	public void avalia(Leilao leilao) {
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão sem lances");
		}
		lances = leilao.getLances();
		
		for(Lance lance : lances) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			} 
			if(lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
		
		average = lances.stream()
			.mapToDouble(Lance::getValor)
			.average();
		
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public double getMedia() {
		return average.orElse(0.0);
	}
	
	public List<Double> get3MaioresLances() {
		return lances.stream()
			.map(Lance::getValor)
			.sorted(Collections.reverseOrder())
			.limit(3)
			.collect(Collectors.toUnmodifiableList());
	}
}
