package week3ExceptionHandlingTask;

public class EmptyFileException extends Exception{
	public EmptyFileException(String message) {
        super(message); // call the constructor of the parent class (Exception)
    }
}
