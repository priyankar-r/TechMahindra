package week2task_2;

import java.util.*;
import java.io.*;
import java.util.logging.*;

public class LibraryManager extends LibrarySystem {
	private static final int MAX_BOOKS_ALLOWED = 3;
	private static final Logger logger = Logger.getLogger(LibraryManager.class.getName());

	public LibraryManager() {
		super();
		setupLogger();
	}

	private void setupLogger() {
		try {
			FileHandler fileHandler = new FileHandler("library_log.txt", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			logger.severe("Failed to set up logger: " + e.getMessage());
		}
	}

	@Override
	public void addBook(Book book) {
		books.add(book);
		logger.info("Added book: " + book.getTitle());
	}

	@Override
	public void addUser(User user) {
		users.add(user);
		logger.info("Added user: " + user.getName());
	}

	@Override
	public synchronized void borrowBook(String ISBN, String userID)
			throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
		Book book = findBookByISBN(ISBN);
		User user = findUserByID(userID);

		if (book == null) {
			throw new BookNotFoundException("Book with ISBN " + ISBN + " not found.");
		}
		if (user == null) {
			throw new UserNotFoundException("User with ID " + userID + " not found.");
		}
		if (user.getBorrowedBooks().size() >= MAX_BOOKS_ALLOWED) {
			throw new MaxBooksAllowedException("User " + userID + " has reached the maximum limit of borrowed books.");
		}
		if (!book.isAvailable()) {
			throw new BookNotFoundException("Book with ISBN " + ISBN + " is not available.");
		}

		book.setAvailable(false);
		user.borrowBook(book);
		logger.info("User " + userID + " borrowed book: " + book.getTitle());
	}

	@Override
	public synchronized void returnBook(String ISBN, String userID)
			throws BookNotFoundException, UserNotFoundException {
		Book book = findBookByISBN(ISBN);
		User user = findUserByID(userID);

		if (book == null) {
			throw new BookNotFoundException("Book with ISBN " + ISBN + " not found.");
		}
		if (user == null) {
			throw new UserNotFoundException("User with ID " + userID + " not found.");
		}

		book.setAvailable(true);
		user.returnBook(book);
		logger.info("User " + userID + " returned book: " + book.getTitle());
	}

	@Override
	public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
		Book book = findBookByISBN(ISBN);
		User user = findUserByID(userID);

		if (book == null) {
			throw new BookNotFoundException("Book with ISBN " + ISBN + " not found.");
		}
		if (user == null) {
			throw new UserNotFoundException("User with ID " + userID + " not found.");
		}

		logger.info("User " + userID + " reserved book: " + book.getTitle());
	}

	private Book findBookByISBN(String ISBN) {
		for (Book book : books) {
			if (book.getISBN().equals(ISBN)) {
				return book;
			}
		}
		return null;
	}

	private User findUserByID(String userID) {
		for (User user : users) {
			if (user.getUserID().equals(userID)) {
				return user;
			}
		}
		return null;
	}

	public void saveLibraryState(String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(books);
			oos.writeObject(users);
			logger.info("Library state saved to file: " + filename);
		} catch (IOException e) {
			logger.severe("Failed to save library state: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadLibraryState(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			books = (List<Book>) ois.readObject();
			users = (List<User>) ois.readObject();
			logger.info("Library state loaded from file: " + filename);
		} catch (IOException | ClassNotFoundException e) {
			logger.severe("Failed to load library state: " + e.getMessage());
		}
	}
}
