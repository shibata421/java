package lambdas;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Produto iPad = new Produto("iPad", 3235.89, 0.13);
		
		Function<Produto, Double> precoReal = 
				produto -> (produto.preco * (1 - produto.desconto));
		
		UnaryOperator<Double> impostoMunicipal = 
				precoInicial -> precoInicial >= 2500 ? 
				precoInicial * (1 + 0.085) : precoInicial;
		
		UnaryOperator<Double> frete = 
				precoComImposto -> precoComImposto >= 3000 ? 
				(precoComImposto + 100) : (precoComImposto + 50);
		
		Function<Double, String> arredondar = 
				precoComFrete -> String.format("%.2f", precoComFrete);
		
		Consumer<String> formatarPreco = 
				precoEmString -> 
				System.out.println("O preço final é R$" + precoEmString.replace(".", ","));
		
		String precoDoProduto = precoReal
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.apply(iPad);
		
		formatarPreco.accept(precoDoProduto);
		
		
		
		
		
	}
}
