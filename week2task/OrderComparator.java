package week2task;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {
	@Override
	public int compare(Order o1, Order o2) {
		return o2.getPriority().compareTo(o1.getPriority());
	}

}
