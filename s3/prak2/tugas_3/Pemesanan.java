package tugas_3;

public abstract class Pemesanan implements Tiket {
    protected String nama;
    protected String asal;
    protected String tujuan;
    protected double tiket;
    protected double diskon;

    public Pemesanan(String nama, String asal, String tujuan, double tiket, double diskon) {
        this.nama = nama;
        this.asal = asal;
        this.tujuan = tujuan;
        this.tiket = tiket;
        this.diskon = diskon;
    }

    @Override
    public abstract double hitungBiayaTiket();

    @Override
    public abstract double hitungDiskon();

    @Override
    public abstract void tampilkanInformasi();
}
