package week3ExceptionHandlingTask;

public class PositiveNumberException extends Exception {
	public PositiveNumberException(String message) {
        super(message); // call the constructor of the parent class (Exception)
    }
}
