import java.util.ArrayList;

public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    // Method to sell coffee with overloaded parameters
    public void sellCoffee(int size) {
        sellCoffee(size, 1, 1); // Default values for sugar and cream packets
    }

    // Overloading the sellCoffee method to provide additional variants
    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 1); // Default value for cream packets
    }

    // Overloading the sellCoffee method to provide additional variants
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Enjoy your coffee!");
        } else {
            System.out.println("Sorry, we don't have enough ingredients to make your coffee.");
            restock();
        }
    }

    // Private method to restock cafe inventory
    private void restock() {
        // For simplicity, assume restock to full capacity
        this.nCoffeeOunces = 100; // arbitrary value
        this.nSugarPackets = 50; // arbitrary value
        this.nCreams = 20; // arbitrary value
        this.nCups = 100; // arbitrary value
        System.out.println("Inventory has been restocked.");
    }
}
