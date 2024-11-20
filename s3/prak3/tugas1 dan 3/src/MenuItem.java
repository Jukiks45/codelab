public class MenuItem<String> {
    private String nama;
    private double harga;
    private int jumlah;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 1;
    }

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
