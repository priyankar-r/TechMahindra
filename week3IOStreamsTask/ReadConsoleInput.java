package week3IOStreamsTask;

import java.util.*;

public class ReadConsoleInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter your name: ");
		String name = sc.nextLine();
		System.out.print("enter your age: ");
		int age = sc.nextInt();
		System.out.print("enter your height (in meters): ");
		double height = sc.nextDouble();
		System.out.println("\nHello, " + name + "!");
		System.out.println("You are " + age + " years old.");
		System.out.println("Your height is " + height + " meters.");
		sc.close();
	}
}
