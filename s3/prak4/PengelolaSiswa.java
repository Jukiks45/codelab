import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Siswa {
    String nama;
    int nilai;

    public Siswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nilai: " + nilai;
    }
}

public class PengelolaSiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Siswa> daftarSiswa = new ArrayList<>();
        int pilihan;

        do {
            // Tampilkan menu
            System.out.println("Menu:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Urutkan dan Tampilkan berdasarkan Nama");
            System.out.println("3. Urutkan dan Tampilkan berdasarkan Nilai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    // Tambah siswa
                    System.out.print("Masukkan nama siswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nilai siswa: ");
                    int nilai = scanner.nextInt();
                    daftarSiswa.add(new Siswa(nama, nilai));
                    System.out.println("Data siswa berhasil ditambahkan!");
                    break;

                case 2:
                    // Urutkan berdasarkan nama
                    Collections.sort(daftarSiswa, Comparator.comparing(s -> s.nama));
                    System.out.println("Data siswa diurutkan berdasarkan nama:");
                    for (Siswa s : daftarSiswa) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    // Urutkan berdasarkan nilai (descending)
                    Collections.sort(daftarSiswa, (s1, s2) -> s2.nilai - s1.nilai);
                    System.out.println("Data siswa diurutkan berdasarkan nilai:");
                    for (Siswa s : daftarSiswa) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    // Keluar program
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
