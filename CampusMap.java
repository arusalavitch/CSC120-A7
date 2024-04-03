import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Nielson Library", "7 Neilson Drive, Northampton, MA 01063", 5));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 3, 100, 100, 100, 100));
        myMap.addBuilding(new House("Duckett House", "41, Elm Street, Northampton, MA, 01063-6322", 4, true));
        myMap.addBuilding(new Building("Field House", "106 Lower College Ln, Northampton, MA 01063", 1));
        myMap.addBuilding(new House("Dawes House", "8 Bedford Terrace, Northampton, MA 01063", 2, true));
        myMap.addBuilding(new Building("Design and Thinking Initiative", "25a Henshaw Ave, Northampton, MA 01063", 2));
        myMap.addBuilding(new Cafe("Compass Cafe", "1st Floor 7 Neilson Drive, Northampton, MA 01063", 1, 100, 100, 100, 100));
        myMap.addBuilding(new Building("Lyman Plant House and Conservatory", "16 College Ln, Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Ainsworth Gym and Olin Fitness Center", "102 Lower College Ln, Northampton, MA 01063", 6));
        myMap.addBuilding(new House("Chase House", "42, Elm Street, Northampton, MA, 01063-6322", 4, true));
        System.out.println(myMap);
    }
    
}
