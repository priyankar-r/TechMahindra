package week2task;

import java.io.*;
import java.util.logging.*;
import java.util.*;
import java.util.concurrent.*;

public class InventoryManager {
	private Map<String,Product> products;
	private PriorityQueue<Order> orderQueue;
	private ExecutorService executorService;
	private static final Logger logger = Logger.getLogger(InventoryManager.class.getName());

	public InventoryManager() {
		products = new ConcurrentHashMap<>();
		orderQueue = new PriorityQueue<>(new OrderComparator());
		executorService = Executors.newFixedThreadPool(5); 
		setupLogger();
	}

	private void setupLogger() {
		try {
			FileHandler fileHandler = new FileHandler("inventory_log.txt", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			logger.severe("Failed in setting up logger: " + e.getMessage());
		}
	}

	public synchronized void addProduct(Product product) {
		products.put(product.getProductID(), product);
		logger.info("Added products: " + product.getProductID());
	}

	public void placeOrder(Order order) {
		orderQueue.add(order);
		logger.info("Order placed: " + order.getOrderID());
	}

	public void processOrders() {
		while (!orderQueue.isEmpty()) {
			Order order = orderQueue.poll();
			executorService.submit(() -> {
				try {
					fulfillOrder(order);
				} catch (OutOfStockException | InvalidLocationException e) {
					logger.warning("Order " + order.getOrderID() + " failed: " + e.getMessage());
				}
			});
		}
		executorService.shutdown();
	}

	private void fulfillOrder(Order order) throws OutOfStockException, InvalidLocationException {
		for (String productID : order.getProductIDs()) {
			Product product = products.get(productID);
			if (product == null) {
				throw new InvalidLocationException("Product " + productID + " not found.");
			}
			if (product.getQuantity() <= 0) {
				throw new OutOfStockException("Product " + productID + " is out of stock.");
			}
			product.setQuantity(product.getQuantity() - 1);
			logger.info(
					"Order " + order.getOrderID() + ": Picked product " + productID + " from " + product.getLocation());
		}
		logger.info("Order " + order.getOrderID() + " fulfilled successfully.");
	}

	public void saveInventoryToFile(String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(products);
			logger.info("Inventory saved to file: " + filename);
		} 
		catch (IOException e) {
			logger.severe("Failed to save inventory: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadInventoryFromFile(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			products = (ConcurrentHashMap<String, Product>) ois.readObject();
			logger.info("Inventory loaded from file: " + filename);
		} 
		catch (IOException | ClassNotFoundException e) {
			logger.severe("Failed to load inventory: " + e.getMessage());
		}
	}
}
