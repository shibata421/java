package lambdas;

@FunctionalInterface
public interface Calculo {

	double executar(double a, double b); 
	// interface funcional s� pode ter uma �nica fun��o abstrata
	
	default String legal() {
		return "legal";
	}
	
	static String muitoLegal() {
		return "muito legal";
	}
}
