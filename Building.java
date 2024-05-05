/**
 * Represents a building with a name, address, and number of floors.
 */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * Constructs a Building object with default values.
     * Default name is "<Name Unknown>", default address is "<Address Unknown>", default number of floors is 1.
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Constructs a Building object with a specified address and default name and number of floors.
     * @param address The address of the building.
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /**
     * Constructs a Building object with a specified name, address, and default number of floors.
     * @param name The name of the building.
     * @param address The address of the building.
     */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /**
     * Constructs a Building object with specified name, address, and number of floors.
     * @param name The name of the building.
     * @param address The address of the building.
     * @param nFloors The number of floors in the building.
     * @throws RuntimeException if nFloors is less than 1.
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Retrieves the name of the building.
     * @return The name of the building.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the address of the building.
     * @return The address of the building.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Retrieves the number of floors in the building.
     * @return The number of floors in the building.
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Enters the building, setting the active floor to the ground floor.
     * @return The Building object representing the current building.
     * @throws RuntimeException if already inside the building.
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Exits the building, setting the active floor to -1.
     * @return null to indicate outside the building.
     * @throws RuntimeException if not inside the building.
     * @throws RuntimeException if fallen out of a window from a floor higher than ground floor.
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Moves up one floor.
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Moves down one floor.
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Displays the available options in the building.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Generates a string representation of the building.
     * @return A string describing the building.
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * Navigates to the specified floor.
     * @param floorNum The floor number to navigate to.
     * @throws RuntimeException if not inside the building.
     * @throws RuntimeException if floorNum is invalid or not adjacent to the current floor.
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("You can only move to adjacent floors.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Main method to test the Building class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }
}
