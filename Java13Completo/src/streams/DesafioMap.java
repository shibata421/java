package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1 , 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println("Resolu��o com m�todos de refer�ncia");
		nums.stream()
		.map(Integer::toBinaryString)
		.map(DesafioMap::inverterString)
		.map(DesafioMap::reverterDeBinario)
		.forEach(System.out::println);


		System.out.println("\nResolu��o com fun��es lambda");
		nums.stream()
			.map(Integer::toBinaryString)
			.map(DesafioMap.inverterString)
			.map(DesafioMap.reverterDeBinario)
			.forEach(System.out::println);

	}
	
	static String inverterString (String sequenciaOriginal) {
		StringBuilder aux = new StringBuilder();
		aux.append(sequenciaOriginal);
		aux = aux.reverse();
		
		return aux.toString();
		// https://www.geeksforgeeks.org/reverse-a-string-in-java/
	}
	
	static int reverterDeBinario (String numero) {
		return Integer.parseInt(numero, 2);
		// https://www.javatpoint.com/java-binary-to-decimal
	}
	
	static UnaryOperator<String> inverterString = 
			sequenciaOriginal ->  new StringBuilder(sequenciaOriginal).reverse().toString();

	static Function<String, Integer> reverterDeBinario = 
			binario -> Integer.parseInt(binario, 2);

}
