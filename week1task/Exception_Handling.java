package week1task;

import java.util.Scanner;

public class Exception_Handling {
	
	    public static void processInput() {
	        Scanner sc = new Scanner(System.in);
	        
	        try {
	            System.out.print("Enter a number ");
	            double num = Double.parseDouble(sc.nextLine()); 
	            
	            if (num == 0) {
	                throw new ArithmeticException("division by 0 is invalid");
	            }
	            
	            double reciprocal = 1 / num;
	            System.out.println("reciprocal: " + reciprocal);
	            } 
	        catch (NumberFormatException e) {
	            System.out.println("error: invalid input, not a numerical value");
	            } 
	        catch (ArithmeticException e) {
	            System.out.println("error: " + e.getMessage());
	            } 
	        finally {
	            sc.close();
	            }
	        }

	    public static void main(String[] args) {
	        processInput();
	        }
}
