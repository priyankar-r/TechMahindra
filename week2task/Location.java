package week2task;

import java.io.Serializable;
public class Location implements Serializable{
	private static final long serialVersionUID = 1L;
	private int aisle;
	private int shelf;
	private int bin;

	public Location(int aisle, int shelf, int bin) {
		this.aisle = aisle;
		this.shelf = shelf;
		this.bin = bin;
	}

	public int getAisle() {
		return aisle;
	}

	public int getShelf() {
		return shelf;
	}

	public int getBin() {
		return bin;
	}

	@Override
	public String toString() {
		return "Aisle" + aisle + ", Shelf" + shelf + ", Bin" + bin;
	}
}