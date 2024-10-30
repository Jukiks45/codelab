import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        // Daftar menu tetap
        MenuItem[] menuList = {
            new MenuItem("Nasi Goreng", 25000),
            new MenuItem("Es Teh", 5000),
            new MenuItem("Ayam Bakar", 30000),
            new MenuItem("Mie Goreng", 20000),
            new MenuItem("Sate Ayam", 35000)
        };

        System.out.println("Daftar Menu:");
        for (int i = 0; i < menuList.length; i++) {
            System.out.printf("%d. %s - Rp %.2f\n", i + 1, menuList[i].getNama(), menuList[i].getHarga());
        }

        System.out.println("\nPilih menu dengan memasukkan nomor (atau ketik 0 untuk selesai):");

        // Loop untuk memilih item sampai selesai
        while (true) {
            System.out.print("Pilih nomor menu: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {  // Selesai memilih
                break;
            } else if (pilihan > 0 && pilihan <= menuList.length) {
                MenuItem selectedMenu = menuList[pilihan - 1];

                System.out.print("Masukkan jumlah: ");
                int jumlah = scanner.nextInt();
                
                // Tambahkan item ke dalam order dengan jumlah yang dipilih
                order.addItem(new MenuItem(selectedMenu.getNama(), selectedMenu.getHarga(), jumlah));
                System.out.println("Item telah ditambahkan!\n");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        // Tampilkan nota setelah semua item dimasukkan
        order.tampilkanNota();
        scanner.close();
    }
}
