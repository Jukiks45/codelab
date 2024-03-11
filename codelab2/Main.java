import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                scanner.nextLine(); // Consume newline character
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = scanner.nextLine();
                if (nim.length() != 15) {
                    System.out.println("NIM Harus 15 Digit!!!");
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = scanner.nextLine();
                }
                System.out.print("Masukkan jurusan mahasiswa: ");
                String jurusan = scanner.nextLine();
                Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
                daftarMahasiswa.add(mahasiswa);
                System.out.println("Data mahasiswa berhasil ditambahkan.");
            } else if (pilihan == 2) {
                Mahasiswa.tampilUniversitas();
                System.out.println("Data Mahasiswa:");
                for (Mahasiswa mhs : daftarMahasiswa) {
                    mhs.tampilDataMahasiswa();
                }
            } else if (pilihan == 3) {
                System.out.println("Adios");
                scanner.close(); // Tutup scanner sebelum keluar dari program
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }
}
