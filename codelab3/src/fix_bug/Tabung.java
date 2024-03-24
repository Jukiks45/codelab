import java.util.Scanner;

public class Tabung extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jariJari;

    public Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input tinggi tabung: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari2x tabung: ");
        jariJari = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * Math.PI * jariJari * (jariJari + tinggi);
        super.luasPermukaan();
        System.out.println("luas permukaan tabung: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.PI * Math.pow(jariJari, 2) * tinggi;
        super.volume();
        System.out.println("volume tabung: " + hasil);
    }
}
