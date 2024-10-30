package tugas4a;

public class Baju {
    public static final double diskon = 0.9;
    private String nama;
    private double harga;
    private int jumlahStok;

    public Baju(String nama, double harga, int jumlahStok) {
        this.nama = nama;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }

    public void tampilkanBaju() {
        System.out.println("Nama Baju: " + nama);
        System.out.println("Harga: $" + harga);
        System.out.println("Harga Diskon: $" + hitungDiskon());
        System.out.println("Jumlah Stok: " + jumlahStok);
    }

    private double hitungDiskon() {
        return harga * diskon;
    }

    public void sesuaikanJumlahStok(int penyesuaian) {
        jumlahStok += penyesuaian;
        System.out.println("Jumlah stok disesuaikan. Stok baru: " + jumlahStok);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }
}
