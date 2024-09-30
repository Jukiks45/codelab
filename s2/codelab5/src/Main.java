import java.util.*;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> nama = new ArrayList<String>();
        int index = 1;

        while (true) {
            System.out.print("Masukkan nama ke-" + index + ": ");
            String namaMahasiswa = input.nextLine();

            try {
                cekNama(namaMahasiswa);

                if (namaMahasiswa.equals("selesai")) {
                    break;
                }

                nama.add(namaMahasiswa);
                index++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Daftar mahasiswa yang diinputkan:");
        for (String n : nama) {
            System.out.println("- " + n);
        }
    }

    public static void cekNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong!");
        }
    }
}
