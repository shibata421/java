package classe;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		Produto p1 = new Produto("Notebook", 4356.89);
//		p1.nome = "Notebook";
//		p1.preco = 4356.89;
//		p1.desconto = 0.25;
		
		var p2 = new Produto("Caneta Preta", 12.56);
//		p2.nome = "Caneta preta";
//		p2.preco = 12.56;
//		p2.desconto = 0.29;
		
		Produto.desconto = 0.50;
		
		System.out.println(p1.nome + " " + p1.precoComDesconto());
		System.out.println(p2.nome + " " + p2.precoComDesconto());
		
		double precoFinal1 = p1.precoComDesconto(0);
		double precoFinal2 = p2.precoComDesconto();
		double mediaCarrinho = (precoFinal1 + precoFinal2) / 2;
		
		System.out.printf("Média do carrinho = R$%.2f" , mediaCarrinho);
	}
}
