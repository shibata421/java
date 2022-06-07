package classe;

public class Data {

	int dia;
	int mes;
	int ano;
	
	Data (){
		this(1, 1, 1970);
	}
	
	Data (int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	String obterDataFormatada (){
		return dia + "/" + mes + "/" + ano;
		//Tem mais flexibilidade que o imprimir abaixo
	}
	
	void imprimirDataFormatada (){
		System.out.println(obterDataFormatada()); 
		//Esse método permite apenas retorno em terminal
	}
}
