package data;

import java.util.ArrayList;
import books.Book;
import com.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.iMenu;

public class Student extends User implements iMenu {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(String name, String nim, String faculty, String program) {
        super(name, nim, faculty, program);
    }

    public void displayInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Information");
        alert.setHeaderText(null);
        alert.setContentText(
            "Name: " + name + "\n" +
            "NIM: " + nim + "\n" +
            "Faculty: " + faculty + "\n" +
            "Program: " + program
        );
        alert.showAndWait();
    }

    @Override
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "Information", "No books borrowed yet.");
        } else {
            VBox vbox = new VBox();
            vbox.setPadding(new javafx.geometry.Insets(10));
            for (Book book : borrowedBooks) {
                Label titleLabel = new Label("Title: " + book.getTitle());
                Label authorLabel = new Label("Author: " + book.getAuthor());
                Label categoryLabel = new Label("Category: " + book.getCategory());
                Label durationLabel = new Label("Duration: " + book.getDuration());
                VBox bookInfoBox = new VBox(titleLabel, authorLabel, categoryLabel, durationLabel);
                bookInfoBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
                vbox.getChildren().add(bookInfoBox);
            }
            Scene scene = new Scene(vbox, 400, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void returnBooks() {
        if (borrowedBooks.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "Information", "No books borrowed yet.");
            return;
        }
        
        VBox vbox = new VBox();
        vbox.setPadding(new javafx.geometry.Insets(10));
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book book = borrowedBooks.get(i);
            Label bookLabel = new Label((i + 1) + ". " + book.getTitle());
            Button returnButton = new Button("Return");
            int index = i;
            returnButton.setOnAction(e -> {
                borrowedBooks.remove(index);
                book.setStock(book.getStock() + 1);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Book returned successfully.");
                Main.bookList.add(book);
                Stage stage = (Stage) returnButton.getScene().getWindow();
                stage.close();
                returnBooks();
            });
            VBox bookBox = new VBox(bookLabel, returnButton);
            vbox.getChildren().add(bookBox);
        }
        
        Scene scene = new Scene(vbox, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    // @Override
    public void displayBooks() {
        VBox vbox = new VBox();
        vbox.setPadding(new javafx.geometry.Insets(10));
        for (Book book : Main.bookList) {
            Label titleLabel = new Label("Title: " + book.getTitle());
            Label authorLabel = new Label("Author: " + book.getAuthor());
            Label categoryLabel = new Label("Category: " + book.getCategory());
            Label stockLabel = new Label("Stock: " + book.getStock());
            Button borrowButton = new Button("Borrow");
            borrowButton.setOnAction(e -> {
                if (book.getStock() > 0) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Borrow Book");
                    dialog.setHeaderText(null);
                    dialog.setContentText("How many days do you want to borrow the book? (maximum 14 days):");
                    dialog.showAndWait().ifPresent(daysStr -> {
                        try {
                            int days = Integer.parseInt(daysStr);
                            if (days <= 14) {
                                borrowedBooks.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock(), days));
                                book.setStock(book.getStock() - 1);
                                showAlert(Alert.AlertType.INFORMATION, "Success", "Book borrowed successfully.");
                            } else {
                                showAlert(Alert.AlertType.ERROR, "Error", "Invalid number of days.");
                            }
                        } catch (NumberFormatException ex) {
                            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a valid number.");
                        }
                    });
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Book out of stock!");
                }
            });
            VBox bookInfoBox = new VBox(titleLabel, authorLabel, categoryLabel, stockLabel, borrowButton);
            bookInfoBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
            vbox.getChildren().add(bookInfoBox);
        }
        Scene scene = new Scene(vbox, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void menu() {
        userMenu();
    }

    @Override
    public void logout() {
        showAlert(Alert.AlertType.INFORMATION, "Logout", "Returning to main menu...");
        new Main().start(new Stage());
    }

    private void userMenu() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new javafx.geometry.Insets(10));

        Button borrowedBooksButton = new Button("Show Borrowed Books");
        borrowedBooksButton.setOnAction(e -> showBorrowedBooks());

        Button borrowBookButton = new Button("Borrow Book");
        borrowBookButton.setOnAction(e -> displayBooks());

        Button returnBookButton = new Button("Return Book");
        returnBookButton.setOnAction(e -> returnBooks());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> logout());

        vbox.getChildren().addAll(borrowedBooksButton, borrowBookButton, returnBookButton, logoutButton);

        Scene scene = new Scene(vbox, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    protected void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
