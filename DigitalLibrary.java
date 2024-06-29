package Project;

import java.util.*;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}


class User {
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Email: " + email;
    }
}

public class DigitalLibrary {
    private Map<Integer, Book> books;
    private Map<Integer, User> users;
    private int nextBookId = 1;
    private int nextUserId = 1;

    public DigitalLibrary() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    // To add a new book to the library
    public void addBook(String title, String author) {
        int bookId = nextBookId++;
        Book newBook = new Book(bookId, title, author);
        books.put(bookId, newBook);
        System.out.println("Book added successfully: " + newBook);
    }

    // To remove a book from the library
    public void removeBook(int bookId) {
        Book removedBook = books.remove(bookId);
        if (removedBook != null) {
            System.out.println("Book removed successfully: " + removedBook);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    // To display all books in the library
    public void displayAllBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // To register a new user
    public void registerUser(String name, String email) {
        int userId = nextUserId++;
        User newUser = new User(userId, name, email);
        users.put(userId, newUser);
        System.out.println("User registered successfully: " + newUser);
    }

    // To display all registered users
    public void displayAllUsers() {
        System.out.println("Registered Users:");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        DigitalLibrary library = new DigitalLibrary();

        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");

        library.displayAllBooks();

        library.registerUser("Alice", "alice@example.com");
        library.registerUser("Bob", "bob@example.com");

        library.displayAllUsers();
    }
}
