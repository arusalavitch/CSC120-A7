import java.util.ArrayList;

public class Library extends Building {
    private ArrayList<String> bookTitles;
    private ArrayList<Boolean> bookAvailable;

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.bookTitles = new ArrayList<>();
        this.bookAvailable = new ArrayList<>();
        System.out.println("You have built a library: 📖");
    }

    // Method to add a book to the library
    public void addTitle(String title) {
        bookTitles.add(title);
        bookAvailable.add(true); // Set the book as available
    }

    // Method to remove a book from the library
    public String removeTitle(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookAvailable.remove(index);
            return bookTitles.remove(index);
        } else {
            return null; // Title not found
        }
    }

    // Overriding the showOptions() method to include library-specific options
    @Override
    public void showOptions() {
        super.showOptions(); // Call superclass method to show common options
        System.out.println(" + addTitle(String title)");
        System.out.println(" + removeTitle(String title)");
        System.out.println(" + checkOut(String title)");
        System.out.println(" + returnBook(String title)");
        System.out.println(" + containsTitle(String title)");
        System.out.println(" + isAvailable(String title)");
        System.out.println(" + printCollection()");
    }
}
