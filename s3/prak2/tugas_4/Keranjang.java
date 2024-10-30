package tugas_4;

public class Keranjang {
    public Baju baju;
    public String lokasi;

    public Keranjang(Baju baju, String lokasi) {
        this.baju = baju;
        this.lokasi = lokasi;
    }

    public void tampilkanKeranjang() {
        System.out.println("Lokasi Pembelian: " + lokasi);
        baju.tampilkanBaju();
    }
}
