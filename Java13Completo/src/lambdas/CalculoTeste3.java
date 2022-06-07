package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {

	public static void main(String[] args) {
		
		// n�o d� para fazer int -> Double
		// Double a = 1; (Isso n�o pode)
		
		BinaryOperator<Double> calculo = (x, y) -> { double a = x + y; return a; }; 
		/* com chaves, pode colocar mais de uma senten�a de c�digo
		 * e precisa de return*/
		System.out.println(calculo.apply(2.0, 3.0));
		
		calculo = (x, y) -> x * y; 
		// sem chaves, s� pode uma senten�a e n�o pode colocar return
		System.out.println(calculo.apply((double) 2, (double) 3)); 
		// Casting tamb�m � uma op��o
		
		// a interface Calculo n�o � necessaria, pois o java j� possui o BinaryOperator 
		
		BinaryOperator<Integer> calculo2 = (x, y) -> { return x + y; }; 
		System.out.println(calculo2.apply(2, 3));
		
		calculo2 = (x, y) -> x * y; 
		System.out.println(calculo2.apply(2, 3)); 
	}
}
