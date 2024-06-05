package data;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import javafx.scene.control.Alert;
// import javafx.scene.control.ButtonType;
import com.main.Main;
import exception.custom.IllegalAdminAccess;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.iMenu;

public class Admin extends User implements iMenu {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public Admin() {
        super("Admin", "", "", "");
    }

    public boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }

    @Override
    public void menu() {
        // This can remain empty if not used directly
    }

    public void adminMenu(Stage stage) {
        Label label = new Label("===== Admin Menu =====");
        Button addStudentButton = new Button("Tambahkan Student");
        Button addBookButton = new Button("Tambahkan Buku");
        Button showStudentsButton = new Button("Tampilkan Student yang Terdaftar");
        Button showBooksButton = new Button("Tampilkan Buku yang Tersedia");
        Button logoutButton = new Button("Logout");

        addStudentButton.setOnAction(e -> showAddStudentForm(stage));
        addBookButton.setOnAction(e -> showAddBookForm(stage));
        showStudentsButton.setOnAction(e -> displayRegisteredStudents(stage));
        showBooksButton.setOnAction(e -> displayBooks(stage));
        logoutButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Keluar dari akun admin.");
            alert.showAndWait();
            new Main().start(stage);
        });

        VBox vbox = new VBox(10, label, addStudentButton, addBookButton, showStudentsButton, showBooksButton,
                logoutButton);
        vbox.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void showAddStudentForm(Stage stage) {
        Label nameLabel = new Label("Enter student name: ");
        TextField nameField = new TextField();
        Label nimLabel = new Label("Enter student NIM: ");
        TextField nimField = new TextField();
        Label facultyLabel = new Label("Enter student faculty: ");
        TextField facultyField = new TextField();
        Label programLabel = new Label("Enter student program: ");
        TextField programField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String nim = nimField.getText();
            String faculty = facultyField.getText();
            String program = programField.getText();
            addStudent(name, nim, faculty, program, stage);
        });

        backButton.setOnAction(e -> adminMenu(stage));

        VBox vbox = new VBox(10, nameLabel, nameField, nimLabel, nimField, facultyLabel, facultyField, programLabel,
                programField, submitButton, backButton);
        vbox.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void showAddBookForm(Stage stage) {
        Label categoryLabel = new Label("Select book category:");
        Button storyButton = new Button("Story Book");
        Button historyButton = new Button("History Book");
        Button textButton = new Button("Text Book");
        Button backButton = new Button("Back");

        storyButton.setOnAction(e -> showAddBookDetails(stage, "Story"));
        historyButton.setOnAction(e -> showAddBookDetails(stage, "History"));
        textButton.setOnAction(e -> showAddTextBookDetails(stage));
        backButton.setOnAction(e -> adminMenu(stage));

        VBox vbox = new VBox(10, categoryLabel, storyButton, historyButton, textButton, backButton);
        vbox.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void showAddBookDetails(Stage stage, String category) {
        Label titleLabel = new Label("Enter book title: ");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Enter author: ");
        TextField authorField = new TextField();
        Label stockLabel = new Label("Enter the stock: ");
        TextField stockField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        submitButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            int stock = Integer.parseInt(stockField.getText());
            addBook(category, title, author, stock, 0, stage);
        });

        backButton.setOnAction(e -> showAddBookForm(stage));

        VBox vbox = new VBox(10, titleLabel, titleField, authorLabel, authorField, stockLabel, stockField, submitButton,
                backButton);
        vbox.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void showAddTextBookDetails(Stage stage) {
        Label titleLabel = new Label("Enter book title: ");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Enter author: ");
        TextField authorField = new TextField();
        Label stockLabel = new Label("Enter the stock: ");
        TextField stockField = new TextField();
        // Label durationLabel = new Label("Enter duration: ");
        // TextField durationField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        submitButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            int stock = Integer.parseInt(stockField.getText());
            // int duration = Integer.parseInt(durationField.getText());
            addBook("Text", title, author, stock, 0, stage);
        });

        backButton.setOnAction(e -> showAddBookForm(stage));

        // VBox vbox = new VBox(10, titleLabel, titleField, authorLabel, authorField, stockLabel, stockField,
        //         durationLabel, durationField, submitButton, backButton);
        VBox vbox = new VBox(10, titleLabel, titleField, authorLabel, authorField, stockLabel, stockField, submitButton, backButton);
        vbox.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void addBook(String category, String title, String author, int stock, int duration, Stage stage) {
        Book book;
        switch (category) {
            case "Story":
                book = new StoryBook(generateId(), title, author, category, stock, 0);
                break;
            case "History":
                book = new HistoryBook(generateId(), title, author, category, stock, 0);
                break;
            case "Text":
                book = new TextBook(generateId(), title, author, category, stock, 0);
                break;
            default:
                // Kategori buku tidak valid
                return;
        }
        Main.bookList.add(book);
        // Tampilkan pesan berhasil
        showAlert(AlertType.INFORMATION, "Success", "Book added successfully.");
    }
    
    public void addStudent(String name, String nim, String faculty, String program, Stage stage) {
        Student student = new Student(name, nim, faculty, program);
        Main.userList.add(student);
        // Tampilkan pesan berhasil
        showAlert(AlertType.INFORMATION, "Success", "Student added successfully.");
    }

    public void displayRegisteredStudents(Stage stage) {
        VBox vbox = new VBox();
        vbox.setPadding(new javafx.geometry.Insets(10));
        for (User user : Main.userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                Label nameLabel = new Label("Name: " + student.name);
                Label facultyLabel = new Label("Faculty: " + student.faculty);
                Label nimLabel = new Label("NIM: " + student.nim);
                Label programLabel = new Label("Program: " + student.program);
                VBox studentInfoBox = new VBox(nameLabel, facultyLabel, nimLabel, programLabel);
                studentInfoBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
                vbox.getChildren().add(studentInfoBox);
            }
        }
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> adminMenu(stage));
        vbox.getChildren().add(backButton); // Tambahkan tombol "Back"
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void displayBooks(Stage stage) {
        VBox vbox = new VBox();
        vbox.setPadding(new javafx.geometry.Insets(10));
        for (Book book : Main.bookList) {
            Label idLabel = new Label("ID: " + book.getId());
            Label titleLabel = new Label("Title: " + book.getTitle());
            Label authorLabel = new Label("Author: " + book.getAuthor());
            Label categoryLabel = new Label("Category: " + book.getCategory());
            Label stockLabel = new Label("Stock: " + book.getStock());
            VBox bookInfoBox = new VBox(idLabel, titleLabel, authorLabel, categoryLabel, stockLabel);
            bookInfoBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
            vbox.getChildren().add(bookInfoBox);
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> adminMenu(stage));
        vbox.getChildren().add(backButton);
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public String generateId() {
        String uuid = java.util.UUID.randomUUID().toString();
        String id = uuid.substring(0, 14);
        return id;
    }
    
    protected void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
