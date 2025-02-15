package week3ThreadsTask;

public class BasicThreadExample {
	public static void main(String[] args) {
        // create an instance of the custom thread class
        HelloThread helloThread = new HelloThread();

        // starting the thread
        helloThread.start();
        System.out.println("main thread is running.");
    }
}
