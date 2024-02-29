import java.util.Scanner;

public class tugas {
    private static String[] mahasiswa = {"999", "666"};

    private static String adminUsername = "admin";
    private static String adminPassword = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. keluar");
            System.out.print("pilih (1-3): ");
            option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1:
                    logiStudents(scanner);
                    break;
                case 2:
                    loginAdmin(scanner);
                    break;
                case 3:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("pilihan tidak valid, tolong pilih antara 1 sampai 3.");
            }
        } while (option != 3);
    }

    public static void logiStudents(Scanner scanner) {
        System.out.print("masukkan NIM anda: ");
        String nim = scanner.nextLine();
        boolean found = false;
        for (String studentNIM : mahasiswa) {
            if (studentNIM.equals(nim)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Berhasil login sebagai mahasiswa");
        } else {
            System.out.println("User tidak ditemukan");
        }
    }

    public static void loginAdmin(Scanner scanner) {
        System.out.print("Masukkan username anda: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password anda: ");
        String password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Succes login sebagai admin");
        } else {
            System.out.println("User admin tidak ditemukan!!");
        }
    }
}
