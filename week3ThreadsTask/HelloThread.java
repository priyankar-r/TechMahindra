package week3ThreadsTask;

public class HelloThread extends Thread{
	 @Override
	    public void run() {
	        //executed when the thread starts
	        System.out.println("Hello, Java!");
	    }
}
