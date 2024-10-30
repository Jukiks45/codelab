package tugas_3;

public class TiketPesawat extends Pemesanan {

    public TiketPesawat(Info info) {
        super(info.nama(), info.asal(), info.tujuan(), info.tiket(), info.diskon());
    }

    @Override
    public double hitungBiayaTiket() {
        return tiket - (tiket * (diskon / 100));
    }

    @Override
    public double hitungDiskon() {
        return tiket * (diskon / 100);
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("Nama Penumpang : " + nama);
        System.out.println("Lokasi Keberangkatan : " + asal);
        System.out.println("Tujuan Penerbangan : " + tujuan);
        System.out.println("Harga Tiket Awal : Rp." + tiket);
        System.out.println("Persentase Diskon : " + diskon + "%");
        System.out.println("Biaya Tiket Setelah Diskon : Rp." + hitungBiayaTiket());
        System.out.println("Jumlah Diskon Total : Rp." + hitungDiskon());
    }
}
