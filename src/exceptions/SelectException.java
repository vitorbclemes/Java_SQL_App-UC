package exceptions;
@SuppressWarnings("serial")

public class SelectException extends Exception{
    
	
	public SelectException() {}
	
	public SelectException(String mensagem) {
		super(mensagem);
	}
}
