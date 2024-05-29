package com.main;
import java.util.*;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import data.Admin;
import data.Student;
import data.User;
import exception.custom.IllegalAdminAccess;

public class Main {
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();
    static Admin admin = new Admin();

    public static void main(String[] args) throws IllegalAdminAccess {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("===== Library System =====");
                System.out.println("1. Login as Student");
                System.out.println("2. Login as Admin");
                System.out.println("3. Exit");
                System.out.print("Choose option (1-3): ");
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        enterNim(scanner);
                        break;
                    case "2":
                        admin.loginAdmin(scanner);
                        break;
                    case "3":
                        System.out.println("Thank you. Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct type of data.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void enterNim(Scanner scanner) {
        try {
            System.out.print("Enter your NIM (input 99 to back): ");
            String nim = scanner.nextLine();
            if (nim.equals("99")) {
                return;
            } else if (checkNim(nim)) {
                User user = getUser(nim);
                user.userMenu();
            } else {
                System.out.println("Invalid NIM. Please try again.");
                enterNim(scanner);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while entering NIM: " + e.getMessage());
        }
    }

    public static boolean checkNim(String nim) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String nim) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getNim().equals(nim)) {
                return user;
            }
        }
        return null;
    }

    public static void initializeData() {
        bookList.add(new HistoryBook("388c-e681-9152", "title1", "author1", "Sejarah", 8, 7));
        bookList.add(new StoryBook("ed90-be30-5cdb", "title2", "author2", "Cerita", 11, 14));
        bookList.add(new TextBook("d95e-0c4a-9523", "title3", "author3", "Novel", 3, 30));

        userList.add(new Student("Taufiq Ramadhan", "202210370311288", "Teknik", "Informatika"));
        userList.add(new Student("Who", "200510370318521", "Teknik", "Informatika"));
        userList.add(new Student("Sutrisno Adit Pratama", "202210370311203", "Teknik", "Informatika"));
    }
}
