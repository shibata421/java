package lambdas;

public class CalculoTeste2 {

	public static void main(String[] args) {
		
		Calculo calculo = (x, y) -> { double a = x + y; return a; }; 
		/* com chaves, pode colocar mais de uma sentença de código
		 * e precisa de return*/
		System.out.println(calculo.executar(2, 3));
		
		calculo = (x, y) -> x * y; 
		// sem chaves, só pode uma sentença e não pode colocar return
		System.out.println(calculo.executar(2, 3));
		
		System.out.println(calculo.legal());
		// interface funcional permite ter métodos default
		
		System.out.println(Calculo.muitoLegal());
		// interface funcional também permite ter método estático
	}
}
