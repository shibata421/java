package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O Pequeno Príncipe");
		livros.push("Don Quixote");
		livros.push("O Hobbit");
		
		livros.peek();
		livros.element();
		
		livros.poll();
		livros.remove();
		livros.pop(); //tb joga exceção 
		
//		livros.size();
//		livros.clear();
//		livros.contains(o);
//		
//		livros.isEmpty();
		
		
		
		
	}
}
