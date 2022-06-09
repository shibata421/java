package br.com.alura.rh;

public class ValidacaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidacaoException() {
	}
	
	public ValidacaoException(String msg) {
		super(msg);
	}	
}
