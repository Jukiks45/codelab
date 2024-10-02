import java.util.Scanner;
//tugas 3
public class TiketWisataOnline {

    static final int HARGA_REGULER_DEWASA = 75000;
    static final int HARGA_REGULER_ANAK = 60000;
    static final int HARGA_TERUSAN_DEWASA = 100000;
    static final int HARGA_TERUSAN_ANAK = 85000;
    static final double KENAIKAN_AKHIR_PEKAN = 1.2; 

    private static String mintaInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Data harus diisi.");
            }
        } while (input.isEmpty());
        return input;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Input data pengguna
            String nama = mintaInput(scanner, "Masukkan nama: ");
            
            String hari = mintaInput(scanner, "masukkan hari :").toLowerCase();
            
            String tanggal = mintaInput(scanner, "Masukkan tanggal (DD/MM/YYYY):");
            
            System.out.print("Jenis tiket (reguler/terusan): ");
            String jenisTiket = scanner.nextLine().toLowerCase();

            System.out.print("Kategori usia (dewasa/anak-anak): ");
            String kategoriUsia = scanner.nextLine().toLowerCase();

            System.out.print("Jumlah tiket: ");
            int jumlahTiket = scanner.nextInt();

            
            int hargaTiket = hitungHargaTiket(jenisTiket, kategoriUsia, hari);
            if (hargaTiket == -1) {
                System.out.println("Input tidak valid.");
                return;
            }

            int totalHarga = hargaTiket * jumlahTiket;
            System.out.println("Nama :" + nama);
            System.out.println("tanggal : " + tanggal);
            System.out.println("Total harga: Rp" + totalHarga);
        }
    }

    public static int hitungHargaTiket(String jenisTiket, String kategoriUsia, String hari) {
        int harga = 0;

        if (jenisTiket.equals("reguler")) {
            if (kategoriUsia.equals("dewasa")) {
                harga = HARGA_REGULER_DEWASA;
            } else if (kategoriUsia.equals("anak-anak")) {
                harga = HARGA_REGULER_ANAK;
            } else {
                return -1; // Input usia salah
            }
        } else if (jenisTiket.equals("terusan")) {
            if (kategoriUsia.equals("dewasa")) {
                harga = HARGA_TERUSAN_DEWASA;
            } else if (kategoriUsia.equals("anak-anak")) {
                harga = HARGA_TERUSAN_ANAK;
            } else {
                return -1; // Input usia salah
            }
        } else {
            return -1; // Input tiket salah
        }

        if (hari.equals("sabtu") || hari.equals("minggu")) {
            harga *= KENAIKAN_AKHIR_PEKAN; // Naik 20%
        }
        return harga;
    }
}
