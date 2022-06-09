package br.com.alura;

import java.util.Arrays;
import java.util.List;

public class TestaListaDeAula {

	public static void main(String[] args) {

        Aula a1 = new Aula("Revistando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

        List<Aula> aulas = Arrays.asList(a1, a2, a3);

        System.out.println(aulas);
	}
}
