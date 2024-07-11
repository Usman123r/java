import java.util.*;

class Library {
    private Book[] bookArray; // Using array to store a fixed number of books
    private LinkedList<Book> bookList; // Using linked list for dynamic storage
    private Stack<Book> recentlyAdded; // Using stack to track recently added books
    private Queue<Book> borrowQueue; // Using queue to manage borrow requests
    private HashMap<String, Book> bookMap; // Using hash map for quick ISBN lookup
    private TreeMap<String, Book> sortedBooks; // Using tree map to sort books by title

    public Library(int arraySize) {
        bookArray = new Book[arraySize];
        bookList = new LinkedList<>();
        recentlyAdded = new Stack<>();
        borrowQueue = new LinkedList<>();
        bookMap = new HashMap<>();
        sortedBooks = new TreeMap<>();
    }

    public void addBook(Book book) {
        // Add to array
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = book;
                break;
            }
        }
        // Add to linked list
        bookList.add(book);
        // Add to stack
        recentlyAdded.push(book);
        // Add to hash map
        bookMap.put(book.getIsbn(), book);
        // Add to tree map
        sortedBooks.put(book.getTitle(), book);
    }

    public void removeBook(String isbn) {
        // Remove from array
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] != null && bookArray[i].getIsbn().equals(isbn)) {
                bookArray[i] = null;
                break;
            }
        }
        // Remove from linked list
        bookList.removeIf(book -> book.getIsbn().equals(isbn));
        // Remove from stack
        recentlyAdded.removeIf(book -> book.getIsbn().equals(isbn));
        // Remove from hash map
        bookMap.remove(isbn);
        // Remove from tree map
        sortedBooks.values().removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book searchByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void borrowBook(String isbn) {
        Book book = bookMap.get(isbn);
        if (book != null) {
            borrowQueue.add(book);
        }
    }

    public void listBooks() {
        System.out.println("Books in the Library:");
        for (Book book : bookArray) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    public void listSortedBooks() {
        System.out.println("Books sorted by Title:");
        for (Book book : sortedBooks.values()) {
            System.out.println(book);
        }
    }

    public void listRecentlyAdded() {
        System.out.println("Recently Added Books:");
        for (Book book : recentlyAdded) {
            System.out.println(book);
        }
    }
}

