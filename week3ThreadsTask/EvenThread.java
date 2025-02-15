package week3ThreadsTask;

public class EvenThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) { 
				// check if the number is even
				System.out.println("even: " + i);
			}
		}
	}
}
