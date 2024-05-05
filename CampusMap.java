import java.util.ArrayList;

/**
 * Represents a campus map containing a list of buildings.
 */
public class CampusMap {

    ArrayList<Building> buildings;

    /**
     * Constructs a new CampusMap object with an empty list of buildings.
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map.
     * @param b The Building to add.
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map.
     * @param b The Building to remove.
     * @return The removed Building.
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Generates a string representation of the campus map.
     * @return A string representation of the campus map.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Main method to test the CampusMap class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Nielson Library", "7 Neilson Drive, Northampton, MA 01063", 5));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 3, 100, 100, 100, 100));
       
    }
}