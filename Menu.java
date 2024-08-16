package foodorder;

import foodorder.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<FoodItem> starters;
    private List<FoodItem> mainCourse;
    private List<FoodItem> desserts;
    private List<FoodItem> beverages;

    public Menu() {
        starters = new ArrayList<>();
        mainCourse = new ArrayList<>();
        desserts = new ArrayList<>();
        beverages = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Starters
        starters.add(new FoodItem("Samosa", 30, 15));
        starters.add(new FoodItem("Paneer Tikka", 150, 20));
        starters.add(new FoodItem("Chicken 65", 180, 25));
        
        // Main Course
        mainCourse.add(new FoodItem("Butter Chicken", 250, 30));
        mainCourse.add(new FoodItem("Paneer Butter Masala", 220, 25));
        mainCourse.add(new FoodItem("Dal Makhani", 180, 20));
        mainCourse.add(new FoodItem("Biryani", 200, 35));
        
        // Desserts
        desserts.add(new FoodItem("Gulab Jamun", 80, 10));
        desserts.add(new FoodItem("Rasmalai", 100, 15));
        
        // Beverages
        beverages.add(new FoodItem("Masala Chai", 30, 5));
        beverages.add(new FoodItem("Lassi", 50, 10));
    }

    public void displayMenu() {
        System.out.println("----- Menu -----");

        System.out.println("\nStarters:");
        for (int i = 0; i < starters.size(); i++) {
            System.out.println((i + 1) + ". " + starters.get(i));
        }

        System.out.println("\nMain Course:");
        for (int i = 0; i < mainCourse.size(); i++) {
            System.out.println((i + 1 + starters.size()) + ". " + mainCourse.get(i));
        }

        System.out.println("\nDesserts:");
        for (int i = 0; i < desserts.size(); i++) {
            System.out.println((i + 1 + starters.size() + mainCourse.size()) + ". " + desserts.get(i));
        }

        System.out.println("\nBeverages:");
        for (int i = 0; i < beverages.size(); i++) {
            System.out.println((i + 1 + starters.size() + mainCourse.size() + desserts.size()) + ". " + beverages.get(i));
        }
    }

    public FoodItem getFoodItem(int index) {
        int totalItems = starters.size() + mainCourse.size() + desserts.size() + beverages.size();
        if (index >= 0 && index < totalItems) {
            if (index < starters.size()) {
                return starters.get(index);
            } else if (index < starters.size() + mainCourse.size()) {
                return mainCourse.get(index - starters.size());
            } else if (index < starters.size() + mainCourse.size() + desserts.size()) {
                return desserts.get(index - starters.size() - mainCourse.size());
            } else {
                return beverages.get(index - starters.size() - mainCourse.size() - desserts.size());
            }
        }
        return null;
    }
}

