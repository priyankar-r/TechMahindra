package week1task;

import java.util.Scanner;

//final class - cannot be inherited
public class Final_Class {
	//final variable
	final double pi = 3.14;
	
	//final method - cannot be overriden
	final int area(int radius) {
		int area = (int)(Math.pow(radius,2) * pi);
		return area;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//get input from user
		int radius = sc.nextInt();
		
		//close sccanner class
		sc.close();
		
		//create object for the final class
		Final_Class finalclass = new Final_Class();
		
		//calling final method
		System.out.println("area of circle "+finalclass.area(radius));
	}
}
