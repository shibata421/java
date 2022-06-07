package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {

	public static void main(String[] args) {
		
		// não dá para fazer int -> Double
		// Double a = 1; (Isso não pode)
		
		BinaryOperator<Double> calculo = (x, y) -> { double a = x + y; return a; }; 
		/* com chaves, pode colocar mais de uma sentença de código
		 * e precisa de return*/
		System.out.println(calculo.apply(2.0, 3.0));
		
		calculo = (x, y) -> x * y; 
		// sem chaves, só pode uma sentença e não pode colocar return
		System.out.println(calculo.apply((double) 2, (double) 3)); 
		// Casting também é uma opção
		
		// a interface Calculo não é necessaria, pois o java já possui o BinaryOperator 
		
		BinaryOperator<Integer> calculo2 = (x, y) -> { return x + y; }; 
		System.out.println(calculo2.apply(2, 3));
		
		calculo2 = (x, y) -> x * y; 
		System.out.println(calculo2.apply(2, 3)); 
	}
}
