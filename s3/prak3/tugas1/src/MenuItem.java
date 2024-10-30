public class MenuItem {
    private String nama;
    private double harga;
    private int jumlah;

    // Konstruktor untuk daftar menu tetap
    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 1;
    }

    // Konstruktor untuk item pesanan dengan jumlah
    public MenuItem(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double hitungSubtotal() {
        return harga * jumlah;
    }
}
