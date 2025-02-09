package week2task_2;

import java.io.*;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;

	public Book(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", ISBN='" + ISBN + '\''
				+ ", isAvailable=" + isAvailable + '}';
	}

}
