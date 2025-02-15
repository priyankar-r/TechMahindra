package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class ColorList {
	public static void main(String[] args) {
		// create an ArrayList to store colors
		ArrayList<String> colors = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("how many colors would you like to add? ");
		int noOfColors = sc.nextInt();
		sc.nextLine();
		// loop to get the colors from the user
		for (int i = 0; i < noOfColors; i++) {
			System.out.print("enter color " + (i + 1) + ": ");
			String color = sc.nextLine();
			colors.add(color);
		}
		// print the collection of colors
		System.out.println("\n color collection:");
		for (String color : colors) {
			System.out.println(color);
		}
		// close the scanner class
		sc.close();
	}
}
