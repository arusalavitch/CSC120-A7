import java.util.ArrayList;

public class House extends Building {
    private ArrayList<String> residents;
    private boolean hasDiningRoom;
    private boolean hasElevator;

    // Default constructor
    public House() {
        super();
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house has been created.");
    }

    // Overloaded constructor 1: Providing name and address only
    public House(String name, String address) {
        super(name, address);
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + ".");
    }

    // Overloaded constructor 2: Providing name, address, and number of floors
    public House(String name, String address, int nFloors) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        hasDiningRoom = false;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors.");
    }

    // Overloaded constructor 3: Providing name, address, number of floors, and dining room availability
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        hasElevator = false;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors and a dining room.");
    }

    // Overloaded constructor 4: Providing name, address, number of floors, dining room availability, and elevator availability
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);
        residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("A new house named " + name + " has been created at " + address + " with " + nFloors + " floors, a dining room, and an elevator.");
    }

    // Method to add resident to the house
    public void moveIn(String name) {
        residents.add(name);
        System.out.println(name + " has moved into the house.");
    }

    // Method to remove resident from the house
    public void moveOut(String name) {
        if (residents.remove(name)) {
            System.out.println(name + " has moved out of the house.");
        } else {
            System.out.println(name + " was not found in the house.");
        }
    }

    // Method to check if a person is a resident of the house
    public boolean isResident(String person) {
        return residents.contains(person);
    }

    // Method to display house options
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ moveIn(String name)");
        System.out.println("+ moveOut(String name)");
        System.out.println("+ isResident(String name)");
    }
}
