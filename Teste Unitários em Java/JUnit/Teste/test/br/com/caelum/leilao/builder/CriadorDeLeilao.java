package br.com.caelum.leilao.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class CriadorDeLeilao {

	private String descricao;
	private List<Lance> lances;

	public CriadorDeLeilao() {
		this.lances = new ArrayList<>();
	}
	
	public CriadorDeLeilao para(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		lances.add(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		Leilao leilao = new Leilao(descricao);
		lances.forEach(lance -> leilao.propoe(lance));
		
		return leilao;
	}	
}
