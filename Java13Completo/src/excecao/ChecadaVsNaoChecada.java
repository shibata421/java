package excecao;

public class ChecadaVsNaoChecada {

	public static void main(String[] args) {
		
		try {
			geraErro1(); // Exceção de runtime não é obrigado a ser tratado
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			geraErro2(); // Essa exceção precisa ser tratada
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim");
	}
	
	// Exceção não checada ou não verificada
	public static void geraErro1() {
		throw new RuntimeException("Ocorre um erro bem legal #01");
	}
	
	// Exceção checada ou verificada (precisa declarar que vai lançar exceção)
	public static void geraErro2() throws Exception {		
		throw new Exception("Ocorre um erro bem legal #02");
	}
}
