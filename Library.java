import java.util.ArrayList;

public class Library extends Building {
    private ArrayList<String> bookTitles;
    private ArrayList<Boolean> bookAvailable;

    // Default constructor
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        bookTitles = new ArrayList<>();
        bookAvailable = new ArrayList<>();
        System.out.println("You have built a library: 📖");
    }

    // Method to add a book to the library
    public void addTitle(String title) {
        bookTitles.add(title);
        bookAvailable.add(true); // Set the book as available
    }

    // Overloaded method 1: Adding a book with a specified author
    public void addTitle(String title, String author) {
        addTitle(title + " by " + author);
    }

    // Overloaded method 2: Adding a book with a specified category
    public void addTitle(String title, String category, int year) {
        addTitle(title + " (" + category + ", " + year + ")");
    }

    // Method to remove a book from the library
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

    // Overloaded method 1: Removing a book by specifying the index
    public void removeTitle(int index) {
        if (index >= 0 && index < bookTitles.size()) {
            String removedTitle = bookTitles.remove(index);
            bookAvailable.remove(index);
            System.out.println(removedTitle + " has been removed from the library.");
        } else {
            System.out.println("Invalid index. No book removed.");
        }
    }

    // Overloaded method 2: Removing a book by specifying the author
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

    // Method to check out a book from the library
    public void checkOut(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookAvailable.set(index, false); // Set book as unavailable
            System.out.println("You have checked out '" + title + "'.");
        } else {
            System.out.println("The book '" + title + "' is not in the library's collection.");
        }
    }

    // Method to return a book to the library
    public void returnBook(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            bookAvailable.set(index, true); // Set book as available
            System.out.println("You have returned '" + title + "' to the library.");
        } else {
            System.out.println("The book '" + title + "' is not in the library's collection.");
        }
    }

    // Method to print the entire collection
    public void printCollection() {
        System.out.println("Library Collection:");
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println((i + 1) + ". " + bookTitles.get(i) + " - Available: " + bookAvailable.get(i));
        }
    }
}
