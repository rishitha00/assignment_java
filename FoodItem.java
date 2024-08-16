package foodorder;

public class FoodItem {
    private String name;
    private double price;
    private int estimatedTime;  // Estimated time in minutes

    public FoodItem(String name, double price, int estimatedTime) {
        this.name = name;
        this.price = price;
        this.estimatedTime = estimatedTime;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public String toString() {
        return name + ": ₹" + price + " (Approx. " + estimatedTime + " mins)";
    }
}

