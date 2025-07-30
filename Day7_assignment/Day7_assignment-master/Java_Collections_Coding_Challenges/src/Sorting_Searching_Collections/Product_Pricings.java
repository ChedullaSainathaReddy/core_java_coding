package Sorting_Searching_Collections;
import java.util.*;
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return name + " - ₹" + price;
    }
}
public class Product_Pricings {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Pen", 10.0));
        products.add(new Product("Notebook", 50.0));
        products.add(new Product("Bottle", 100.0));
        products.add(new Product("Bag", 500.0));
        products.sort(Comparator.comparingDouble(p -> p.price));
        System.out.println("Products sorted by price:");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("\nProducts in price range ₹30 to ₹150:");
        for (Product p : products) {
            if (p.price >= 30 && p.price <= 150) {
                System.out.println(p);
            }
        }
    }
}