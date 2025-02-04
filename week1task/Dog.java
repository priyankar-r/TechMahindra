package week1task;

public class Dog extends Animal {
	
	//overriding the abstract from animal class
	@Override
	void makeSound() {
		System.out.println("the dog is barking woof woof..");
	}
	
	public static void main(String[] args) {
		//create object for dog class
		Animal dog = new Dog();
		
		//calling makesound method
		dog.makeSound();
	}
}
