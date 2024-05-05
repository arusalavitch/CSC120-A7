
/**
 * Represents a cafe, a type of building where coffee and other beverages are served.
 * Extends the Building class.
 */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a new Cafe object with the specified name, address, number of floors, and inventory.
     * Initializes the inventory of coffee, sugar packets, cream packets, and cups.
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     * @param nFloors The number of floors in the cafe.
     * @param nCoffeeOunces The initial amount of coffee in ounces.
     * @param nSugarPackets The initial number of sugar packets.
     * @param nCreams The initial number of cream packets.
     * @param nCups The initial number of cups.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells coffee of a specified size with the specified number of sugar packets and cream packets.
     * @param size The size of the coffee.
     * @param nSugarPackets The number of sugar packets to add.
     * @param nCreams The number of cream packets to add.
     */
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

    /**
     * Overloaded method for selling coffee of a specified size with the default number of sugar and cream packets.
     * @param size The size of the coffee.
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 1, 1); // Default values for sugar and cream packets
    }

    /**
     * Overloaded method for selling coffee of a specified size with the specified number of sugar packets and default number of cream packets.
     * @param size The size of the coffee.
     * @param nSugarPackets The number of sugar packets to add.
     */
    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 1); // Default value for cream packets
    }

    /**
     * Restocks the inventory with the specified quantities of coffee, sugar packets, cream packets, and cups.
     * @param nCoffeeOunces The amount of coffee in ounces to restock.
     * @param nSugarPackets The number of sugar packets to restock.
     * @param nCreams The number of cream packets to restock.
     * @param nCups The number of cups to restock.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("Inventory has been restocked.");
    }

    /**
     * Overloaded method to restock the inventory with default quantities.
     */
    public void restock() {
        restock(100, 50, 20, 100); // Default values for restocking inventory
    }

    /**
     * Overloaded method to restock the inventory with the specified quantity of cups and default quantities for other inventory items.
     * @param nCups The number of cups to restock.
     */
    public void restock(int nCups) {
        restock(100, 50, 20, nCups); // Default values for other inventory items
    }

    /**
     * Overrides the showOptions method in the Building class.
     * Displays additional options specific to the Cafe class.
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ sellCoffee(int size)");
        System.out.println("+ sellCoffee(int size, int nSugarPackets)");
        System.out.println("+ sellCoffee(int size, int nSugarPackets, int nCreams)");
        System.out.println("+ restock()");
        System.out.println("+ restock(int nCups)");
    }
}
