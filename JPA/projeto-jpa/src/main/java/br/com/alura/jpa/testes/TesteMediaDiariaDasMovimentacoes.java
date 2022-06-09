package br.com.alura.jpa.testes;

import java.util.List;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.util.JPAUtil;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {		
		MovimentacaoDao dao = new MovimentacaoDao(JPAUtil.getEntityManager());
		List<MediaComData> medias = dao.getMediasDiarias();
				
		for(MediaComData resultado : medias) {
			Double media = resultado.getValor();
			Integer dia = resultado.getDia(); 
			Integer mes = resultado.getMes(); 
			System.out.println(String.format("A média do dia %d/%d é %.2f", dia, mes, media));
		}
	}
}
