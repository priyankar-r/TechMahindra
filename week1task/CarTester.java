package week1task;

public class CarTester {
	public static void main(String[] args) {
		// create an array of carobject with values
		Car[] cars = { new Car("Toyota", "Camry", 2022), new ElectricCar("kia", "syros", 2026, 300),
				new Car("Honda", "Civic", 2021), new ElectricCar("Nissan", "Leaf", 2022, 300) };
		
		//loop to call startengine method
		for (int i = 0; i < cars.length; i++) {
			cars[i].startEngine();
		}

	}
}
