package exception;

public class NegativeNumberException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private double value;
	
	public NegativeNumberException(double value) {
		this.value = value;
	}
	
	@Override
	public String getMessage() {
		return "No se pueden agregar valores negativos: " + value;
	}
}
