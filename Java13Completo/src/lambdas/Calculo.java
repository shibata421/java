package lambdas;

@FunctionalInterface
public interface Calculo {

	double executar(double a, double b); 
	// interface funcional só pode ter uma única função abstrata
	
	default String legal() {
		return "legal";
	}
	
	static String muitoLegal() {
		return "muito legal";
	}
}
