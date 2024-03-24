public class BangunRuang {
    private String name;

    public BangunRuang(String name) {
        this.name = name;
    }

    public void inputNilai() {
        System.out.println("Input nilai untuk " + name);
    }

    public void luasPermukaan() {
        System.out.println("Menghitung luas permukaan " + name);
    }

    public void volume() {
        System.out.println("Menghitung volume " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
