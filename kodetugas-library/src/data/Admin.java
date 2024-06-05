package data;

// import controller.MainController;
import exception.custom.IllegalAdminAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.iMenu;

public class Admin extends User implements iMenu {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin123";

    public Admin() {
        super("Admin", "", "", "");
    }

    public void loginAdmin(String username, String password) throws IllegalAdminAccess {
        if (isAdmin(username, password)) {
            menu(); // Menampilkan AdminView.fxml
        } else {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }

    private void showAdminView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            System.err.println("Kesalahan memuat AdminView.fxml: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

    @Override
    public void menu() {
        try {
            showAdminView();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menampilkan menu: " + e.getMessage());
        }
    }

    public boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }
}
