public class App {
    public static void main(String[] args) throws Exception {
        Balok balok = new Balok("Balok");
        Tabung tabung = new Tabung("Tabung");
        Kubus kubus = new Kubus("Kubus");

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();
        
        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();


    }
}