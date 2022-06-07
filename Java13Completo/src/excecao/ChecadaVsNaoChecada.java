package excecao;

public class ChecadaVsNaoChecada {

	public static void main(String[] args) {
		
		try {
			geraErro1(); // Exce��o de runtime n�o � obrigado a ser tratado
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			geraErro2(); // Essa exce��o precisa ser tratada
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim");
	}
	
	// Exce��o n�o checada ou n�o verificada
	public static void geraErro1() {
		throw new RuntimeException("Ocorre um erro bem legal #01");
	}
	
	// Exce��o checada ou verificada (precisa declarar que vai lan�ar exce��o)
	public static void geraErro2() throws Exception {		
		throw new Exception("Ocorre um erro bem legal #02");
	}
}
