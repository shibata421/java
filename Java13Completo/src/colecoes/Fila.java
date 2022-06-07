package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<String>();
		
		// Offer e Add adicionam elementos na fila
		// Diferen�a � como o comportamento quando a fila est� cheia
		fila.add("Ana"); // retorna false
		fila.offer("Bia"); // Offer lan�a uma exce��o
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		//Peel e element obtem o pr�ximo elemento da lista sem remover (diferen�a � igual ao de cima)
		System.out.println(fila.peek()); // retorna null
		System.out.println(fila.peek());
		System.out.println(fila.element()); //lan�a uma exce��o
		System.out.println(fila.element());
		
		//Pool e remove obtem o pr�ximo elemento removem da fila
		//Diferen�a � igual aos de cima
		System.out.println(fila.poll()); //retorna null
		System.out.println(fila.remove());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());		
		System.out.println(fila.remove()); //lan�a uma exce��o
		
//		fila.size();
//		fila.clear();
//		fila.isEmpty();
		//fila.contains();
		
	}
	
}
