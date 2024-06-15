package Methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Items.item;
import Containers.SmallContainer;
import Containers.BigContainer;

public class Calculation {
    private ArrayList<item> Items;
    private Map<String, Integer> itemQuantities;
    private Random random;

    private int smallContainers;
    private int bigContainers;

    public Calculation() {
        Items = new ArrayList<>();
        itemQuantities = new HashMap<>();
        random = new Random();
    }

    public void addItem(item item) {
        Items.add(item);
        itemQuantities.put(item.getName(), itemQuantities.getOrDefault(item.getName(), 0) + 1);
    }

    public double getTotalVolume() {
        double totalVolume = 0;
        for (item item : Items) {
            totalVolume += item.calculateVolume();
        }
        return Math.round(totalVolume * 1000.0) / 1000.0;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (item item : Items) {
            totalWeight += item.getWeight();
        }
        return Math.round(totalWeight * 1000.0) / 1000.0;
    }

    public double calculateShippingPrice() {
        double totalWeight = getTotalWeight();
        double totalVolume = getTotalVolume();

        double smallContainerVolume = new SmallContainer().calculateVolume();
        double bigContainerVolume = new BigContainer().calculateVolume();
        double smallContainerPrice = totalWeight <= 500 ? 1000 : 1200;
        double bigContainerPrice = 1800;

        smallContainers = 0;
        bigContainers = 0;

        while (totalVolume > 0) {
            if (totalVolume <= smallContainerVolume) {
                smallContainers++;
                totalVolume -= smallContainerVolume;
            } else {
                bigContainers++;
                totalVolume -= bigContainerVolume;
            }
        }

        return (smallContainers * smallContainerPrice) + (bigContainers * bigContainerPrice);
    }

    public void displayOrderInfo() {
        double price = calculateShippingPrice();
        System.out.println("Shipping Company");
        System.out.println("Order Summary:");
        itemQuantities.forEach((name, quantity) -> System.out.println(name + ": " + quantity));

        System.out.println("Total Volume: " + getTotalVolume() + " cubic meters");
        System.out.println("Total Weight: " + getTotalWeight() + " kg");
        System.out.println("Containers needed: " + bigContainers + " big, " + smallContainers + " small");
        System.out.println("Shipping Price: " + price + " Euro");
        System.out.println("Reference Number: DE-" + (random.nextInt(100) + 1));
        System.out.println("Estimated delivery: " + (random.nextInt(5) + 3) + " days");
    }
}
