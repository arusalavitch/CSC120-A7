import java.util.ArrayList;

public class House extends Building {
    private ArrayList<String> residents;
    private boolean hasDiningRoom;

    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        System.out.println("You have built a house: 🏠");
    }

    // Getter methods for house attributes
    public boolean hasDiningRoom() {
        return hasDiningRoom;
    }

    public int nResidents() {
        return residents.size();
    }

    // Method to add resident to the house
    public void moveIn(String name) {
        residents.add(name);
    }

    // Method to remove resident from the house
    public String moveOut(String name) {
        residents.remove(name);
        return name;
    }

    // Method to check if a person is a resident of the house
    public boolean isResident(String person) {
        return residents.contains(person);
    }

    // Overriding the showOptions() method to include house-specific options
    @Override
    public void showOptions() {
        super.showOptions(); // Call superclass method to show common options
        System.out.println(" + moveIn(String name)");
        System.out.println(" + moveOut(String name)");
        System.out.println(" + isResident(String person)");
    }

    // Overloading the enter() method to provide an additional parameter
    public Building enter(boolean ringDoorbell) {
        if (ringDoorbell) {
            System.out.println("Someone rang the doorbell at " + this.name);
            System.out.println("Please wait for someone to open the door...");
            // Logic to handle doorbell ringing
        }
        return super.enter(); // Call superclass method
    }
}
