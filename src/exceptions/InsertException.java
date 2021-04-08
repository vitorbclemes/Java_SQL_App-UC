package exceptions;
@SuppressWarnings("serial")

public class InsertException extends Exception{
	
	public InsertException() {}
	
	public InsertException(String mensagem) {
		super(mensagem);
	}
}
