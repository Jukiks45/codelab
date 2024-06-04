package data;
import java.util.*;

import controller.MainController;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import exception.custom.IllegalAdminAccess;
import util.iMenu;

public class Admin extends User implements iMenu {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin123";

    public Admin() {
        super("Admin", "", "", "");
    }

    public void loginAdmin(String username, String password) throws IllegalAdminAccess {
        if (isAdmin(username, password)) {
            // Simulasikan admin menu tanpa scanner
            System.out.println("Admin login successful.");
        } else {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }

    public void loginAdmin(Scanner scanner) {
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin123): ");
        String password = scanner.nextLine();

        try {
            if (isAdmin(username, password)) {
                adminMenu(scanner);
            }
        } catch (IllegalAdminAccess e) {
            System.out.println(e.getMessage());
        }
    }

    public void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambahkan Student");
            System.out.println("2. Tambahkan Buku");
            System.out.println("3. Tampilkan Student yang Terdaftar");
            System.out.println("4. Tampilkan Buku yang Tersedia");
            System.out.println("5. Logout");
            System.out.print("Pilih opsi (1-5): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    addBook(scanner);
                    break;
                case "3":
                    displayRegisteredStudents();
                    break;
                case "4":
                    displayBooks();
                    break;
                case "5":
                    System.out.println("Keluar dari akun admin.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            adminMenu(scanner);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menampilkan menu: " + e.getMessage());
        }
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Enter student NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("Student NIM must be 15 digits long.");
            }
        } while (nim.length() != 15);
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();
        MainController.userList.add(new Student(name, nim, faculty, program));
        System.out.println("Student successfully registered.");
    }

    public void addBook(Scanner scanner) {
        System.out.println("Select book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.print("Choose category (1-3): ");
        int categoryOption = scanner.nextInt();
        scanner.nextLine();
        String category = "";
        switch (categoryOption) {
            case 1:
                category = "Story";
                break;
            case 2:
                category = "History";
                break;
            case 3:
                category = "Text";
                break;
            default:
                System.out.println("Invalid category.");
                return;
        }
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String bookId = generateId();
        switch (categoryOption) {
            case 1:
                MainController.bookList.add(new StoryBook(bookId, title, author, category, stock, 0));
                break;
            case 2:
                MainController.bookList.add(new HistoryBook(bookId, title, author, category, stock, 0));
                break;
            case 3:
                System.out.print("Enter duration: ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                MainController.bookList.add(new TextBook(bookId, title, author, category, stock, duration));
                break;
        }
        System.out.println("Book successfully added to the library.");
    }

    public void displayRegisteredStudents() {
        System.out.println("List of Registered Students:");
        for (User user : MainController.userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("Name: " + student.name);
                System.out.println("Faculty: " + student.faculty);
                System.out.println("NIM: " + student.nim);
                System.out.println("Program: " + student.program);
                System.out.println();
            }
        }
    }

    @Override
    public void displayBooks() {
        super.displayBooks();
    }

    public boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }

    public String generateId() {
        String uuid = java.util.UUID.randomUUID().toString();
        String id = uuid.substring(0, 14);
        return id;
    }
}
