package data;
import java.util.Scanner;

import com.main.Main;
import books.Book;

public class User {
    protected String name;
    protected String nim;
    protected String faculty;
    protected String program;
    static Scanner scanner = new Scanner(System.in);

    public User(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public String getNim() {
        return nim;
    }

    public void userMenu() {
        System.out.println("==== Student Menu ====");
        System.out.println("1. Buku yang Dipinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Mengembalikan Buku");
        System.out.println("4. Logout");
        System.out.print("Pilih opsi (1-4): ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                showBorrowedBooks();
                break;
            case "2":
                displayBooks();
                break;
            case "3":
                returnBooks(scanner);
                break;
            case "4":
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public void displayBooks() {
        System.out.println("=================================================================================");
        System.out.printf("|| %-4s || %-8s || %-20s || %-15s || %-10s || %-6s ||\n", "No.", "ID Book", "Title",
                "Author", "Category", "Stock");
        System.out.println("=================================================================================");
        int index = 1;
        for (Book book : Main.bookList) {
            System.out.printf("|| %-4d || %-8s || %-20s || %-15s || %-10s || %-6d ||\n", index, book.getId(),
                    book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock());
            index++;
        }
        System.out.println("=================================================================================");

    }

    public void showBorrowedBooks() {
        System.out.println("No books borrowed yet. \nPlease borrow a book first");
        userMenu();
    }

    public void returnBooks(Scanner scanner) {
        System.out.println("No books borrowed yet.");
    }

    public void logout() {
        System.out.println("Returning to main menu...");
    }
}
