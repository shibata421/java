package br.com.shibata;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdernaStringsExercicio {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(comparing(String::length));
		palavras.sort((s1, s2) -> s1.compareTo(s2));
		palavras.sort(String::compareTo);
		palavras.sort(String.CASE_INSENSITIVE_ORDER);

		palavras.forEach(System.out::println);
	}
}
