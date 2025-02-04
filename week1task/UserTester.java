package week1task;

public class UserTester {
	public static void main(String[] args) {
		User user1 = new User("Jonh", 32, "1123456789");
		User user2 = new User("Mike", 45, "9876543210");
		SecondUser second_user1 = new SecondUser("Rico", 29, "5568629393");
		SecondUser second_user2 = new SecondUser("Alexi", 21, "8034523408");
		System.out.println(user1);
		System.out.println(second_user1);
		System.out.println(user1.equals(user2));
		System.out.println(second_user1.equals(second_user2));
		System.out.println(user1.hashCode());
		System.out.println(second_user1.hashCode());

	}

}
