package controller;

import data.Admin;
import data.User;
import data.Student;
import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import exception.custom.IllegalAdminAccess;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import javafx.geometry.Insets;

import java.util.Optional;
import java.util.ArrayList;

public class MainController {

    @FXML
    private Button studentLoginButton;

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button exitButton;

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static Admin admin = new Admin();

    @FXML
    public void initialize() {
        initializeData();

        AdminController adminController = new AdminController();

        // Konversi ObservableList<User> ke ObservableList<Student>
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        for (User user : userList) {
            if (user instanceof Student) {
                studentList.add((Student) user);
            }
        }

        adminController.setBookList(FXCollections.observableArrayList(bookList));
        adminController.setUserList(studentList);
        
        studentLoginButton.setOnAction(e -> handleStudentLogin());
        adminLoginButton.setOnAction(e -> handleAdminLogin());
        exitButton.setOnAction(e -> handleExit());
    }

    private void handleStudentLogin() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Student Login");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter your NIM (input 99 to back):");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(nim -> {
            if (nim.equals("99")) {
                return;
            } else if (checkNim(nim)) {
                User user = getUser(nim);
                user.userMenu();
            } else {
                showError("Invalid NIM. Please try again.");
            }
        });
    }

    private void handleAdminLogin() {
        // Membuat dialog kustom untuk login admin
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Admin Login");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Membuat grid pane untuk memasukkan username dan password
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Mengambil hasil input
        Platform.runLater(() -> username.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(credentials -> {
            String inputUsername = credentials.getKey();
            String inputPassword = credentials.getValue();
            try {
                // Logika login admin
                admin.loginAdmin(inputUsername, inputPassword);
            } catch (IllegalAdminAccess e) {
                showError("Admin access error: " + e.getMessage());
            }
        });
    }

    private void handleExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    private boolean checkNim(String nim) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    private User getUser(String nim) {
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

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
