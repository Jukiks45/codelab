import java.util.Scanner;

/**
 * Kelas AplikasiBeliBaju adalah kelas utama yang mengelola pembelian baju.
 * Kelas ini memungkinkan pengguna untuk memilih baju, menentukan jumlah pembelian,
 * dan menyesuaikan stok yang tersedia.
 */
public class AplikasiBeliBaju {
    /**
     * Metode utama yang menjalankan aplikasi pembelian baju.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        Baju baju = new Baju("T-Shirt", 50.00, 20);
        Keranjang keranjang = new Keranjang(baju, "Toko Pakaian Online");
        keranjang.tampilkanKeranjang();

        // Menambahkan input untuk jumlah baju yang akan dibeli
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baju yang akan dibeli: ");
        int jumlahBeli = scanner.nextInt();

        // Mengurangi jumlah stok setelah dibeli
        baju.sesuaikanJumlahStok(-jumlahBeli);
        keranjang.tampilkanKeranjang();

        scanner.close();
    }
}
