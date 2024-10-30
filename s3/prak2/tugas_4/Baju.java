package tugas_4;

public class Baju {
    public String nm;
    public double h;
    public int Js;

    public Baju(String nm, double h, int Js) {
        this.nm = nm;
        this.h = h;
        this.Js = Js;
    }

    public void tampilkanBaju() {
        double hDiskon = h * 0.9;
        System.out.println("Nama Baju: " + nm);
        System.out.println("Harga: $" + h);
        System.out.println("Harga Diskon: $" + hDiskon);
        System.out.println("Jumlah Stok: " + Js);
    }

    public void sesuaikanJumlahStok(int penyesuaian) {
        Js += penyesuaian;
        System.out.println("Jumlah stok disesuaikan. Stok baru: " + Js);
    }
}
