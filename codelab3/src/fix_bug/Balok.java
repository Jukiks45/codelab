import java.util.Scanner;

class Balok extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input panjang balok: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar balok: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi balok: ");
        tinggi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        super.luasPermukaan();
        System.out.println("luas permukaan balok: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = panjang * lebar * tinggi;
        super.volume();
        System.out.println("Hasil volume balok: " + hasil);
    }
}