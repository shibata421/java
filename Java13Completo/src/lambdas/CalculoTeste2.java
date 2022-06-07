package lambdas;

public class CalculoTeste2 {

	public static void main(String[] args) {
		
		Calculo calculo = (x, y) -> { double a = x + y; return a; }; 
		/* com chaves, pode colocar mais de uma senten�a de c�digo
		 * e precisa de return*/
		System.out.println(calculo.executar(2, 3));
		
		calculo = (x, y) -> x * y; 
		// sem chaves, s� pode uma senten�a e n�o pode colocar return
		System.out.println(calculo.executar(2, 3));
		
		System.out.println(calculo.legal());
		// interface funcional permite ter m�todos default
		
		System.out.println(Calculo.muitoLegal());
		// interface funcional tamb�m permite ter m�todo est�tico
	}
}
