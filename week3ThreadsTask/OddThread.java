package week3ThreadsTask;

public class OddThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0) { // check if the number is odd
				System.out.println("odd: " + i);
			}
		}
	}
}
