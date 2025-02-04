package week1task;

import java.util.Scanner;

public class Car {
	// create private variables make, model and year
	private String make;
	private String model;
	private int year;

	// create a constructor to assign input to the private variable
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	// create getter and setter method for make, model and year
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// startengine method prints the engine starts
	public void startEngine() {
		System.out.println("The engine starts!");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// get inputs from user
		String make = sc.nextLine();
		String model = sc.nextLine();
		int year = sc.nextInt();

		// close the scanner class
		sc.close();

		// create car class object
		Car car = new Car(make, model, year);

		// call startengine method
		car.startEngine();
	}
}
