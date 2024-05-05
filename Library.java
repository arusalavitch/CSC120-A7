import java.util.ArrayList;
/**
 * Represents a library, a type of building where books are stored and made available for borrowing.
 * Extends the Building class.
 */
public class Library extends Building {

    private ArrayList<String> bookTitles;
    private ArrayList<Boolean> bookAvailable;

    /**
     * Constructs a new Library object with the specified name, address, and number of floors.
     * Initializes the bookTitles and bookAvailable ArrayLists.
     * @param name The name of the library.
     * @param address The address of the library.
     * @param nFloors The number of floors in the library.
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        bookTitles = new ArrayList<>();
        bookAvailable = new ArrayList<>();
        System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book title to the library's collection.
     * The book is initially marked as available.
     * @param title The title of the book to be added.
     */
    public void addTitle(String title) {
        bookTitles.add(title);
        bookAvailable.add(true); // Set the book as available
    }

    /**
     * Adds a book title with a specified author to the library's collection.
     * The book is initially marked as available.
     * @param title The title of the book to be added.
     * @param author The author of the book.
     */
    public void addTitle(String title, String author) {
        addTitle(title + " by " + author);
    }

    /**
     * Adds a book title with a specified category and year to the library's collection.
     * The book is initially marked as available.
     * @param title The title of the book to be added.
     * @param category The category of the book.
     * @param year The year of publication of the book.
     */
    public void addTitle(String title, String category, int year) {
        addTitle(title + " (" + category + ", " + year + ")");
    }

    /**
     * Removes a book from the library's collection based on its title.
     * @param title The title of the book to be removed.
     */
    public void removeTitle(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookTitles.remove(index);
            bookAvailable.remove(index);
            System.out.println(title + " has been removed from the library.");
        } else {
            System.out.println("The book '" + title + "' is not in the library's collection.");
        }
    }

    /**
     * Removes a book from the library's collection based on its index.
     * @param index The index of the book to be removed.
     */
    public void removeTitle(int index) {
        if (index >= 0 && index < bookTitles.size()) {
            String removedTitle = bookTitles.remove(index);
            bookAvailable.remove(index);
            System.out.println(removedTitle + " has been removed from the library.");
        } else {
            System.out.println("Invalid index. No book removed.");
        }
    }

    /**
     * Removes a book from the library's collection based on its author.
     * @param author The author of the book to be removed.
     */
    public void removeTitleByAuthor(String author) {
        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookTitles.get(i).contains(author)) {
                String removedTitle = bookTitles.remove(i);
                bookAvailable.remove(i);
                System.out.println(removedTitle + " has been removed from the library.");
                return;
            }
        }
        System.out.println("No books by " + author + " found in the library's collection.");
    }

    /**
     * Checks out a book from the library based on its title.
     * Marks the book as unavailable.
     * @param title The title of the book to be checked out.
     */
    public void checkOut(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookAvailable.set(index, false); // Set book as unavailable
            System.out.println("You have checked out '" + title + "'.");
        } else {
            System.out.println("The book '" + title + "' is not in the library's collection.");
        }
    }

    /**
     * Returns a book to the library based on its title.
     * Marks the book as available.
     * @param title The title of the book to be returned.
     */
    public void returnBook(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookAvailable.set(index, true); // Set book as available
            System.out.println("You have returned '" + title + "' to the library.");
        } else {
            System.out.println("The book '" + title + "' is not in the library's collection.");
        }
    }

    /**
     * Prints the entire collection of books in the library along with their availability status.
     */
    public void printCollection() {
        System.out.println("Library Collection:");
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println((i + 1) + ". " + bookTitles.get(i) + " - Available: " + bookAvailable.get(i));
        }
    }

    /**
     * Overrides the showOptions method in the Building class.
     * Displays additional options specific to the Library class.
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ addTitle(String title)");
        System.out.println("+ addTitle(String title, String author)");
        System.out.println("+ addTitle(String title, String category, int year)");
        System.out.println("+ removeTitle(String title)");
        System.out.println("+ removeTitle(int index)");
        System.out.println("+ removeTitleByAuthor(String author)");
        System.out.println("+ checkOut(String title)");
        System.out.println("+ returnBook(String title)");
        System.out.println("+ printCollection()");
    }
}