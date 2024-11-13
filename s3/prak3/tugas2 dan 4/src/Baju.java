
public class Baju {
    private String nama;
    private double harga;
    private int jumlahStok;

    /**
     * Konstruktor untuk kelas Baju.
     *
     * @param nama Nama baju.
     * @param harga Harga baju.
     * @param jumlahStok Jumlah stok awal dari baju.
     */

    public Baju(String nama, double harga, int jumlahStok) {
        this.nama = nama;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }

    /**
     * Menampilkan informasi baju termasuk nama, harga asli, harga diskon,
     * dan jumlah stok yang tersedia.
     */
    public void tampilkanBaju() {
        double hargaDiskon = harga * 0.9;
        System.out.println("Nama Baju: " + nama);
        System.out.println("Harga: $" + harga);
        System.out.println("Harga Diskon: $" + hargaDiskon);
        System.out.println("Jumlah Stok: " + jumlahStok);
    }

    /**
     * Menyesuaikan jumlah stok yang tersedia.
     *
     * @param penyesuaian Nilai perubahan stok (positif untuk menambah, negatif untuk mengurangi).
     */
    public void sesuaikanJumlahStok(int penyesuaian) {
        jumlahStok += penyesuaian;
        System.out.println("Jumlah stok disesuaikan. Stok baru: " + jumlahStok);
    }

    // Getter untuk atribut nama
    public String getNama() {
        return nama;
    }

    // Getter untuk atribut harga

    public double getHarga() {
        return harga;
    }

    // Getter untuk atribut jumlahStok
    public int getJumlahStok() {
        return jumlahStok;
    }
}
