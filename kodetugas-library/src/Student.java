import java.util.*;

class Student extends User {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(String name, String nim, String faculty, String program) {
        super(name, nim, faculty, program);
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Faculty: " + faculty);
        System.out.println("Program: " + program);
    }

    @Override
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            super.showBorrowedBooks();
        } else {
            System.out.println("=================================================================================");
            System.out.printf("|| %-4s || %-8s || %-20s || %-15s || %-10s || %-8s ||\n", "No.", "ID Book", "Title",
                    "Author", "Category", "Duration");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.printf("|| %-4d || %-8s || %-20s || %-15s || %-10s || %-8d ||\n", index, book.getId(),
                        book.getTitle(), book.getAuthor(), book.getCategory(), book.getDuration());
                index++;
            }
            System.out.println("=================================================================================");
        }
    }

    @Override
    public void returnBooks(Scanner scanner) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed yet.");
            return;
        }
        System.out.println("=================================================================================");
        System.out.printf("|| %-4s || %-8s || %-20s || %-15s || %-10s || %-6s ||\n", "No.", "ID Book", "Title",
                "Author", "Category", "Duration");
        System.out.println("=================================================================================");
        int index = 1;
        for (Book book : borrowedBooks) {
            System.out.printf("|| %-4d || %-8s || %-20s || %-15s || %-10s || %-4d ||\n", index, book.getId(),
                    book.getTitle(), book.getAuthor(), book.getCategory(), book.getDuration());
            index++;
        }
        System.out.println("=================================================================================");

        System.out.print("Enter the ID of the book you want to return (input 0 to cancel): ");
        String returnId = scanner.nextLine();

        if (returnId.equals("0")) {
            System.out.println("Cancellation.");
            return;
        }

        boolean bookFound = false;
        for (Book book : borrowedBooks) {
            if (book.getId().equals(returnId)) {
                borrowedBooks.remove(book);
                book.setStock(book.getStock() + 1);
                System.out.println("Book returned successfully.");
                bookFound = true;
                for (Book bookMain : Main.bookList) {
                    if (bookMain.getId().equals(returnId)) {
                        bookMain.setStock(book.getStock() + 1);
                        userMenu();
                    }
                }
                userMenu();
            }
        }
        
        if (!bookFound) {
            System.out.println("Book with ID " + returnId + " not found in your borrowed books.");
            userMenu();
        }
    }

    @SuppressWarnings("resource")
    @Override
    public void displayBooks() {
        super.displayBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID you want to borrow (input 99 to back): ");
        String bookId = scanner.nextLine();
        if (bookId.equals("99")) {
            return;
        }
        for (Book book : Main.bookList) {
            if (book.getId().equals(bookId)) {
                if (book.getStock() > 0) {
                    System.out.print("How many days do you want to borrow the book? (maximum 14 days): ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    if (days <= 14) {
                        borrowedBooks.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(),
                                book.getStock(), days));
                        book.setStock(book.getStock() - 1);
                        System.out.println("Book borrowed successfully.");
                        userMenu();
                    } else {
                        System.out.println("Invalid number of days.");
                    }
                } else {
                    System.out.println("Book out of stock!");
                }
            }
        }
        userMenu();
        scanner.close();
    }

    @Override
    public void logout() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Returning to main menu...");
        } else {
            System.out.println("=================================================================================");
            System.out.printf("|| %-4s || %-8s || %-20s || %-15s || %-10s || %-6s ||\n", "No.", "ID Book", "Title",
                    "Author", "Category", "Duration");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.printf("|| %-4d || %-8s || %-20s || %-15s || %-10s\n", index, book.getId(),
                        book.getTitle(), book.getAuthor(), book.getCategory());
                index++;
            }
            System.out.println("=================================================================================");
            System.out.println("Are you sure to borrow all these books?");
            System.out.print("Input Y (yes) or N (no): ");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                System.out.println("Books borrowed successfully.");
                for (Book book : borrowedBooks) {
                    book.setStock(book.getStock() - 1);
                }
            } else {
                System.out.println("Returning to main menu...");
            }
        }
    }
}
