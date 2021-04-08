package exceptions;
@SuppressWarnings("serial")

public class UpdateException extends Exception{
	
	public UpdateException() {}
	
	public UpdateException(String mensagem) {
		super(mensagem);
	}
}
