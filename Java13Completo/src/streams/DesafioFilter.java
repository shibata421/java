package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

	public static void main(String[] args) {
		
		Baixo bass1 = new Baixo("Fender Jazz Bass", 7000, true);
		Baixo bass2 = new Baixo("Fake Precision Bass", 6000, false);
		Baixo bass3 = new Baixo("Tonante X", 299, false);
		Baixo bass4 = new Baixo("Tagima Millenium 6 Top", 1000, true);
		Baixo bass5 = new Baixo("Squier Jaguar", 2000, true);
		Baixo bass6 = new Baixo("Yamaha RBX 375", 1500, true);
		
		List<Baixo> baixos = Arrays.asList(bass1, bass2, bass3, bass4, bass5, bass6);
		
		Predicate<Baixo> bomPreco = bass -> bass.getPreco() < 3000;
		
		Predicate<Baixo> boaQualidade = bass -> bass.isBoaQualidade();
		
		Function<Baixo, String> compra = 
				bass -> "Parabéns! Você comprou o " 
						+ bass.getNome()
						+ " por R$"
						+ String.format("%.2f", bass.getPreco());
						
		baixos.stream()
			.filter(bomPreco)
			.filter(boaQualidade)
			.map(compra)
			.forEach(System.out::println);
	}
}
