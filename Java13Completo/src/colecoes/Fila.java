package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<String>();
		
		// Offer e Add adicionam elementos na fila
		// Diferença é como o comportamento quando a fila está cheia
		fila.add("Ana"); // retorna false
		fila.offer("Bia"); // Offer lança uma exceção
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		//Peel e element obtem o próximo elemento da lista sem remover (diferença é igual ao de cima)
		System.out.println(fila.peek()); // retorna null
		System.out.println(fila.peek());
		System.out.println(fila.element()); //lança uma exceção
		System.out.println(fila.element());
		
		//Pool e remove obtem o próximo elemento removem da fila
		//Diferença é igual aos de cima
		System.out.println(fila.poll()); //retorna null
		System.out.println(fila.remove());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());		
		System.out.println(fila.remove()); //lança uma exceção
		
//		fila.size();
//		fila.clear();
//		fila.isEmpty();
		//fila.contains();
		
	}
	
}
