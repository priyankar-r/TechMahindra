package week1task;

public class ElectricCar extends Car {
	// create a private variable batteryrange of car
	private int batteryRange;

	// create a constructor for electriccar
	public ElectricCar(String make, String model, int year, int batteryRange) {
		// call parent class constructor
		super(make, model, year);
		this.batteryRange = batteryRange;
	}

	// create a getter and setter method for batteryrange
	public int getBatteryRange() {
		return batteryRange;
	}

	public void setBatteryRange(int batteryRange) {
		this.batteryRange = batteryRange;
	}

	// chargebattery method prints battery is charging
	public void chargeBattery() {
		System.out.println("The battery is charging");
	}
	
	//overriding startengine method
	@Override
	public void startEngine() {
		System.out.println("Electric car engine starts");
	}
}
