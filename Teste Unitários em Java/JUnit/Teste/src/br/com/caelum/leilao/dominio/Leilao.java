package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<>();
	}

	public void propoe(Lance lance) {
		Usuario usuarioNovoLance = lance.getUsuario();
		
		if (lances.isEmpty() || podeSerAdicionado(usuarioNovoLance)) {
			lances.add(lance);
		}

	}

	public void dobraLance(Usuario usuario) {
		lances.stream()
			.filter(lance -> lance.getUsuario().equals(usuario))
			.reduce((lance1, lance2) -> lance2)
			.ifPresent(lance -> propoe(new Lance(usuario, lance.getValor() * 2)));
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	private boolean podeSerAdicionado(Usuario usuario) {
		return naoEhOMesmoUsuarioDoLanceAnterior(usuario) && 
				temMenosDe5Lances(usuario);
	}
	
	private boolean naoEhOMesmoUsuarioDoLanceAnterior(Usuario usuario) {
		int lastIndex = lances.size() - 1;

		return !usuario.equals(lances.get(lastIndex).getUsuario());
	}

	private boolean temMenosDe5Lances(Usuario usuario) {
		long count = lances.stream()
				.map(lance -> lance.getUsuario())
				.filter(u -> u.equals(usuario))
				.count();

		return count < 5;
	}

}
