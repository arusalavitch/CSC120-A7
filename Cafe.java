public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    // Constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    // Method to sell coffee with overloaded parameters
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

    // Overloaded method for selling coffee with default parameters
    public void sellCoffee(int size) {
        sellCoffee(size, 1, 1); // Default values for sugar and cream packets
    }

    // Overloaded method for selling coffee with fewer parameters
    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 1); // Default value for cream packets
    }

    // Method to restock the inventory with overloaded parameters
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("Inventory has been restocked.");
    }

    // Overloaded method to restock the inventory with default parameters
    public void restock() {
        restock(100, 50, 20, 100); // Default values for restocking inventory
    }

    // Overloaded method to restock the inventory with custom quantities
    public void restock(int nCups) {
        restock(100, 50, 20, nCups); // Default values for other inventory items
    }
}
