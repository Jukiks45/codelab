package com.main;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import data.Admin;
import data.Student;
import data.User;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();
    static Admin admin = new Admin();

    public static void main(String[] args) {
        initializeData();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showMainMenu(primaryStage);
    }

    private void showMainMenu(Stage stage) {
        Label label = new Label("===== Library System =====");
        Button studentLoginButton = new Button("Login as Student");
        Button adminLoginButton = new Button("Login as Admin");
        Button exitButton = new Button("Exit");

        studentLoginButton.setOnAction(e -> enterNim(stage));
        adminLoginButton.setOnAction(e -> showAdminLogin(stage));
        exitButton.setOnAction(e -> System.exit(0));

        VBox vbox = new VBox(10, label, studentLoginButton, adminLoginButton, exitButton);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);

        VBox.setMargin(label, new Insets(0, 0, 20, 0));
        VBox.setMargin(studentLoginButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(adminLoginButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(exitButton, new Insets(20, 0, 0, 0));

        Scene scene = new Scene(vbox, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void enterNim(Stage stage) {
        Label nimLabel = new Label("Enter your NIM (input 99 to back): ");
        TextField nimField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        submitButton.setOnAction(e -> {
            String nim = nimField.getText();
            if (nim.equals("99")) {
                showMainMenu(stage);
            } else if (checkNim(nim)) {
                User user = getUser(nim);
                if (user != null) {
                    Student student = new Student("John Doe", "123456", "Engineering", "Computer Science");
                    student.menu();
                }
            } else {
                showError(stage, "Invalid NIM. Please try again.");
            }
        });

        backButton.setOnAction(e -> showMainMenu(stage));

        VBox vbox = new VBox(10, nimLabel, nimField, submitButton, backButton);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);

        VBox.setMargin(nimLabel, new Insets(0, 0, 20, 0));
        VBox.setMargin(nimField, new Insets(0, 0, 10, 0));
        VBox.setMargin(submitButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(backButton, new Insets(20, 0, 0, 0));

        Scene scene = new Scene(vbox, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void showAdminLogin(Stage stage) {
        Label usernameLabel = new Label("Enter your username (admin): ");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Enter your password (admin123): ");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            try {
                if (admin.isAdmin(username, password)) {
                    admin.adminMenu(stage);
                }
            } catch (IllegalAdminAccess ex) {
                showError(stage, ex.getMessage());
            }
        });

        backButton.setOnAction(e -> showMainMenu(stage));

        VBox vbox = new VBox(10, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, backButton);
        vbox.setPadding(new Insets(15)); 
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10); 

        VBox.setMargin(usernameLabel, new Insets(0, 0, 5, 0));
        VBox.setMargin(usernameField, new Insets(0, 0, 10, 0));
        VBox.setMargin(passwordLabel, new Insets(0, 0, 5, 0));
        VBox.setMargin(passwordField, new Insets(0, 0, 10, 0));
        VBox.setMargin(loginButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(backButton, new Insets(10, 0, 0, 0));

        Scene scene = new Scene(vbox, 350, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
