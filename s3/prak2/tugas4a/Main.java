package tugas4a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Baju bju = new Baju("T-Shirt", 50.00, 20);
        Keranjang krj = new Keranjang(bju, "Toko Pakaian Online");
        krj.tampilkanKeranjang();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baju yang akan dibeli: ");
        int jumlahBeli = scanner.nextInt();
        bju.sesuaikanJumlahStok(-jumlahBeli);
        krj.tampilkanKeranjang();
        scanner.close();
    }
}
