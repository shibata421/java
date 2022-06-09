package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdernaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		Function<String, Integer> funcao = new Function<>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
//		Function<String, Integer> funcao2 = String::length;
//		Function<String, Integer> funcao3 = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
		
	}
}