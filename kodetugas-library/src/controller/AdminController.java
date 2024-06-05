package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
// import data.Admin;
import data.Student;
import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
// import data.User;

public class AdminController {

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField studentNimField;

    @FXML
    private TextField studentFacultyField;

    @FXML
    private TextField studentProgramField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TextField bookAuthorField;

    @FXML
    private TextField bookCategoryField;

    @FXML
    private TextField bookStockField;

    @FXML
    private TextField bookDurationField;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, String> studentNameColumn;

    @FXML
    private TableColumn<Student, String> studentNimColumn;

    @FXML
    private TableColumn<Student, String> studentFacultyColumn;

    @FXML
    private TableColumn<Student, String> studentProgramColumn;

    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Book, String> bookTitleColumn;

    @FXML
    private TableColumn<Book, String> bookAuthorColumn;

    @FXML
    private TableColumn<Book, String> bookCategoryColumn;

    @FXML
    private TableColumn<Book, Integer> bookStockColumn;

    @FXML
    private TableColumn<Book, Integer> bookDurationColumn;

    @FXML
    private Button logoutButton;

    @FXML
    private Pane studentTablePane;

    @FXML
    private Pane bookTablePane;

    private ObservableList<Student> studentData;
    private ObservableList<Book> bookData;

    public void setBookList(ObservableList<Book> bookList) {
        this.bookData = bookList;
    }

    public void setUserList(ObservableList<Student> studentList) {
        this.studentData = studentList;
    }

    @FXML
    public void initialize() {

        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentNimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        studentFacultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        studentProgramColumn.setCellValueFactory(new PropertyValueFactory<>("program"));

        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        bookStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        bookDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        studentTableView.setItems(studentData);
        bookTableView.setItems(bookData);

        studentTablePane.setVisible(false);
        bookTablePane.setVisible(false);

        // System.out.println("Student Data:");
        // for (Student student : studentData) {
        //     System.out.println(student.getName() + " - " + student.getNim());
        // }
    
        // System.out.println("\nBook Data:");
        // for (Book book : bookData) {
        //     System.out.println(book.getTitle() + " - " + book.getAuthor());
        // }
    }

    public void addStudent(ActionEvent event) {
        String name = studentNameField.getText();
        String nim = studentNimField.getText();
        String faculty = studentFacultyField.getText();
        String program = studentProgramField.getText();

        if (nim.length() != 15) {
            showAlert("Error", "Student NIM must be 15 digits long.");
            return;
        }

        Student newStudent = new Student(name, nim, faculty, program);
        studentData.add(newStudent);
        clearStudentFields();
        showAlert("Success", "Student successfully registered.");
    }

    public void addBook(ActionEvent event) {
        String title = bookTitleField.getText();
        String author = bookAuthorField.getText();
        String category = bookCategoryField.getText();
        int stock;
        int duration;
        try {
            stock = Integer.parseInt(bookStockField.getText());
            duration = Integer.parseInt(bookDurationField.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Stock and Duration must be integers.");
            return;
        }

        String bookId = generateId();
        Book newBook;
        switch (category.toLowerCase()) {
            case "story":
                newBook = new StoryBook(bookId, title, author, category, stock, duration);
                break;
            case "history":
                newBook = new HistoryBook(bookId, title, author, category, stock, duration);
                break;
            case "text":
                newBook = new TextBook(bookId, title, author, category, stock, duration);
                break;
            default:
                showAlert("Error", "Invalid book category.");
                return;
        }

        bookData.add(newBook);
        clearBookFields();
        showAlert("Success", "Book successfully added.");
    }

    public void displayRegisteredStudents(ActionEvent event) {
        bookTablePane.setVisible(false);
        studentTablePane.setVisible(true);
        studentTableView.setItems(studentData);
    }

    public void displayBooks(ActionEvent event) {
        studentTablePane.setVisible(false);
        bookTablePane.setVisible(true);
        bookTableView.setItems(bookData);
    }

    public void logout(ActionEvent event) {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearStudentFields() {
        studentNameField.clear();
        studentNimField.clear();
        studentFacultyField.clear();
        studentProgramField.clear();
    }

    private void clearBookFields() {
        bookTitleField.clear();
        bookAuthorField.clear();
        bookCategoryField.clear();
        bookStockField.clear();
        bookDurationField.clear();
    }

    private String generateId() {
        return java.util.UUID.randomUUID().toString().substring(0, 14);
    }
}
