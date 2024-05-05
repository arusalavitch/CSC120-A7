import java.util.ArrayList;
/**
 * Represents a house, a type of building where people reside.
 * Extends the Building class.
 */
public class House extends Building {

    private ArrayList<String> residents;
    private boolean hasDiningRoom;
    private boolean hasElevator;

    /**
     * Constructs a new House object with default values.
     * Initializes residents list, dining room availability, and elevator availability.
     */
    public House() {
        super();
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house has been created.");
    }

    /**
     * Constructs a new House object with the specified name and address.
     * Initializes residents list, dining room availability, and elevator availability.
     * @param name The name of the house.
     * @param address The address of the house.
     */
    public House(String name, String address) {
        super(name, address);
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + ".");
    }

    /**
     * Constructs a new House object with the specified name, address, and number of floors.
     * Initializes residents list, dining room availability, and elevator availability.
     * @param name The name of the house.
     * @param address The address of the house.
     * @param nFloors The number of floors in the house.
     */
    public House(String name, String address, int nFloors) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors.");
    }

    /**
     * Constructs a new House object with the specified name, address, number of floors, and dining room availability.
     * Initializes residents list and elevator availability.
     * @param name The name of the house.
     * @param address The address of the house.
     * @param nFloors The number of floors in the house.
     * @param hasDiningRoom Indicates whether the house has a dining room.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors and a dining room.");
    }

    /**
     * Constructs a new House object with the specified name, address, number of floors, dining room availability, and elevator availability.
     * Initializes residents list.
     * @param name The name of the house.
     * @param address The address of the house.
     * @param nFloors The number of floors in the house.
     * @param hasDiningRoom Indicates whether the house has a dining room.
     * @param hasElevator Indicates whether the house has an elevator.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors, a dining room, and an elevator.");
    }

    /**
     * Adds a resident to the house.
     * @param name The name of the resident to be added.
     */
    public void moveIn(String name) {
        residents.add(name);
        System.out.println(name + " has moved into the house.");
    }

    /**
     * Removes a resident from the house.
     * @param name The name of the resident to be removed.
     */
    public void moveOut(String name) {
        if (residents.remove(name)) {
            System.out.println(name + " has moved out of the house.");
        } else {
            System.out.println(name + " was not found in the house.");
        }
    }

    /**
     * Checks if a person is a resident of the house.
     * @param person The name of the person to check.
     * @return True if the person is a resident, false otherwise.
     */
    public boolean isResident(String person) {
        return residents.contains(person);
    }

    /**
     * Displays house-specific options.
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ moveIn(String name)");
        System.out.println("+ moveOut(String name)");
        System.out.println("+ isResident(String name)");
    }

    /**
     * Overrides the goToFloor method in the Building class.
     * Throws a RuntimeException if attempting to move to a non-adjacent floor without an elevator.
     * @param floorNum The floor number to move to.
     */
    @Override
    public void goToFloor(int floorNum) {
        if (!hasElevator() && Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("You can only move to adjacent floors without an elevator.");
        }
        super.goToFloor(floorNum);
    }

    /**
     * Checks if the house has an elevator.
     * @return True if the house has an elevator, false otherwise.
     */
    public boolean hasElevator() {
        return this.hasElevator;
    }
}
