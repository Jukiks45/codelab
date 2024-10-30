/**
 * Kelas Keranjang merepresentasikan keranjang belanja untuk menyimpan item baju
 * yang dipilih beserta lokasi pembeliannya.
 */
public class Keranjang {
    private Baju baju;
    private String lokasi;

    /**
     * Konstruktor untuk kelas Keranjang.
     *
     * @param baju Objek baju yang akan dimasukkan ke dalam keranjang.
     * @param lokasi Lokasi pembelian atau toko.
     */
    public Keranjang(Baju baju, String lokasi) {
        this.baju = baju;
        this.lokasi = lokasi;
    }

    /**
     * Menampilkan informasi keranjang termasuk lokasi pembelian dan detail baju.
     */
    public void tampilkanKeranjang() {
        System.out.println("Lokasi Pembelian: " + lokasi);
        baju.tampilkanBaju();
    }

    // Getter untuk atribut baju
    public Baju getBaju() {
        return baju;
    }

    // Getter untuk atribut lokasi
    public String getLokasi() {
        return lokasi;
    }
}
