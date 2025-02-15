package week3ExceptionHandlingTask;

public class OddNumberChecker {
	public static void main(String[] args) {
        try {
            int number = 7; 
            checkIfEven(number);
            System.out.println("the number is even: " + number);

        } catch (OddNumberException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            // this block will always execute
            System.out.println("finally block executed.");
        }
    }

    // check if a number is even
    public static void checkIfEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            // throw an exception if the number is odd
            throw new OddNumberException("the number is odd: " + number);
        }
    }
}
