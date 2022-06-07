package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {

	public static void main(String[] args) {
		
		Supplier<List<String>> umaList = 
				() -> Arrays.asList("Ana", "Bia", "Lia", "Gui");
				// necessita dos parenteses vazios
		
		System.out.println(umaList.get());
	}
}
