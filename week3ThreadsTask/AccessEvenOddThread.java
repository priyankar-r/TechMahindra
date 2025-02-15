package week3ThreadsTask;

public class AccessEvenOddThread {
	public static void main(String[] args) {
		// create instances of the even and odd threads
		EvenThread evenThread = new EvenThread();
		OddThread oddThread = new OddThread();

		// starting the threads
		evenThread.start();
		oddThread.start();
		System.out.println("main thread is running.");
	}
}
