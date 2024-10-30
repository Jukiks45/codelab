package tugas_4;

import java.util.Scanner;

public class AplikasiBeliBaju {
    public static void main(String[] args) {
        Baju bju = new Baju("T-Shirt", 50.00, 20);
        Keranjang krj = new Keranjang(bju, "Toko Pakaian Online");
        krj.tampilkanKeranjang();

        // Menambahkan input untuk jumlah baju yang akan dibeli
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baju yang akan dibeli: ");
        int jumlahBeli = scanner.nextInt();

        // Mengurangi jumlah stok setelah dibeli
        bju.sesuaikanJumlahStok(-jumlahBeli);
        krj.tampilkanKeranjang();

        scanner.close();
    }
}
