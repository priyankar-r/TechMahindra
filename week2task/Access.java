package week2task;

import java.util.Arrays;

public class Access {
	public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addProduct(new Product("P1", "Laptop", 10, new Location(1,2,3)));
        inventoryManager.addProduct(new Product("P2", "Mouse", 50, new Location(2,3,4)));
        inventoryManager.addProduct(new Product("P3", "Keyboard", 30, new Location(3,4,5)));

        inventoryManager.placeOrder(new Order("O1", Arrays.asList("P1", "P2"), Order.Priority.EXPEDITED));
        inventoryManager.placeOrder(new Order("O2", Arrays.asList("P3"), Order.Priority.STANDARD));
        inventoryManager.placeOrder(new Order("O3", Arrays.asList("P1", "P3"), Order.Priority.EXPEDITED));

        inventoryManager.processOrders();

        inventoryManager.saveInventoryToFile("inventory.dat");

        inventoryManager.loadInventoryFromFile("inventory.dat");
    }
}
