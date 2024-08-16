package foodorder;

import foodorder.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> orderedItems;

    public Order() {
        orderedItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        orderedItems.add(item);
    }

    public void removeFoodItem(int index) {
        if (index >= 0 && index < orderedItems.size()) {
            orderedItems.remove(index);
        }
    }

    public void displayOrder() {
        System.out.println("----- Your Order -----");
        double total = 0.0;
        int totalEstimatedTime = 0;
        for (FoodItem item : orderedItems) {
            System.out.println(item);
            total += item.getPrice();
            totalEstimatedTime += item.getEstimatedTime();
        }
        System.out.println("Total: ₹" + total);
        System.out.println("Estimated preparation time: " + totalEstimatedTime + " minutes");
    }

    public double calculateTotal() {
        double total = 0.0;
        for (FoodItem item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

    public int getOrderSize() {
        return orderedItems.size();
    }
}
