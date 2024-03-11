import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        String jenisKelamin;
        while (true) {
            System.out.print("Jenis Kelamin (L/P): ");
            String jenisKelaminInput = scanner.nextLine();
            if (jenisKelaminInput.equalsIgnoreCase("L")) {
                jenisKelamin = "Laki-laki";
                break;
            } else if (jenisKelaminInput.equalsIgnoreCase("P")) {
                jenisKelamin = "Perempuan";
                break;
            } else {
                System.out.println("Input tidak valid. Masukkan 'L' untuk Laki-laki atau 'P' untuk Perempuan.");
            }
        }

        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        String tanggalLahirString = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString);

        LocalDate sekarang = LocalDate.now();
        Period selisihTime = Period.between(tanggalLahir, sekarang);

        System.out.println("\nNama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur Anda: " + selisihTime.getYears() + " tahun " + selisihTime.getMonths() + " bulan");
        
        scanner.close();
    }
}
