package classe;

public class DataTeste {

	public static void main(String[] args) {
		
		Data d1 = new Data();
		Data d2 = new Data(31, 12, 2020);
		
//		d1.dia = 7;
//		d1.mes = 11;
//		d1.ano = 2021;
		System.out.println(d1.obterDataFormatada());
		
//		d2.dia = 31;
//		d2.mes = 12;
//		d2.ano = 2020;
		System.out.println(d2.obterDataFormatada());
		
//		d1.imprimirDataFormatada();
//		d2.imprimirDataFormatada();
	}
	
}
