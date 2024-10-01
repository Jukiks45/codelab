import java.util.Scanner;
import java.util.regex.Pattern;
//tugas 2
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidator {

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password harus memiliki panjang minimal 8 karakter.");
        }
        //negasi disini sebagai pembalik untuk membalikkan boolean pada find
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf besar (A-Z).");
        }

        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf kecil (a-z).");
        }

        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu angka (0-9).");
        }

        if (!Pattern.compile("[!@#$%^&*]").matcher(password).find()) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter khusus (!, @, #, $, %, ^, &, *).");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            System.out.println("Password valid.");
        } catch (InvalidPasswordException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
