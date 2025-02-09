package week2task_2;

import java.util.*;
import java.io.*;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String userID;
	private List<Book> borrowedBooks;

	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
		this.borrowedBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userID;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", userID='" + userID + '\'' + ", borrowedBooks=" + borrowedBooks+ '}';
	}

}
