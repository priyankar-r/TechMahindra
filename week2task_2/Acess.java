package week2task_2;

import java.util.concurrent.*;

public class Acess {
	public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        libraryManager.addBook(new Book("Java Programming", "John Doe", "1234567890"));
        libraryManager.addBook(new Book("Python Basics", "Jane Smith", "0987654321"));
        libraryManager.addUser(new User("Alice", "U001"));
        libraryManager.addUser(new User("Bob", "U002"));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            try {
                libraryManager.borrowBook("1234567890", "U001");
            } catch (BookNotFoundException | UserNotFoundException | MaxBooksAllowedException e) {
                System.out.println(e.getMessage());
            }
        });

        executor.submit(() -> {
            try {
                libraryManager.borrowBook("0987654321", "U002");
            } catch (BookNotFoundException | UserNotFoundException | MaxBooksAllowedException e) {
                System.out.println(e.getMessage());
            }
        });

        executor.submit(() -> {
            try {
                libraryManager.returnBook("1234567890", "U001");
            } catch (BookNotFoundException | UserNotFoundException e) {
                System.out.println(e.getMessage());
            }
        });

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        libraryManager.saveLibraryState("library_state.dat");
        libraryManager.loadLibraryState("library_state.dat");
    }
}
