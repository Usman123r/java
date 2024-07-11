public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(10);
        
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Book book2 = new Book("1984", "George Orwell", "1234567891");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "1234567892");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.listBooks();
        library.listSortedBooks();
        library.listRecentlyAdded();

        System.out.println("Search by ISBN 1234567891: " + library.searchByIsbn("1234567891"));
        System.out.println("Search by Title '1984': " + library.searchByTitle("1984"));

        library.borrowBook("1234567891");
        library.removeBook("1234567891");

        library.listBooks();
    }
}
