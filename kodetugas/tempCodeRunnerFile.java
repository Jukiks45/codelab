import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> userStudent = new ArrayList<>();
    static ArrayList<String> bookList = new ArrayList<>();
    public static void main(String[] args) {
        bookList.add("ED90-2BE3-DA44*title*author*Sejarah*3");
        bookList.add("JK91-VSE3-QAW9*title2*author2*Komedi*4");
        bookList.add("E1P1-W8E3-DBH5*title3*author3*Komedi*2");
    menu();
    }

    static void menu() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Library system =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        switch (pil) {
            case 1:
                System.out.println("Student");
                inputNim();
                break;
            case 2:
                System.out.println("Admin");
                System.out.print("Enter Your Username (admin): ");
                String useradmin = input.next();
                System.out.print("Enter Your NIM (admin): ");
                String passadmin = input.next();
                if (useradmin.equalsIgnoreCase("admin") && passadmin.equalsIgnoreCase("admin")) {
                    System.out.println("Successful Login as Admin");
                    menuAdmin();
                } else {
                    System.out.println("Invalid creditial for admin");
                    menu();
                }
                break;
            case 3:
                System.out.println("Thankyou Exiting Program");
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }

    static void inputNim() {
        Scanner input = new Scanner(System.in);
        String nim;
        boolean continueInput = true;
        int i = 99;
        while (continueInput) {
            System.out.print("Enter your NIM (input " + i + " for back): ");
            nim = input.next();
            if (checkNim(nim) == 1) {
                System.out.println("benar");
                menuStudent();
                continueInput = false;
            } else if (i == 0) {
                System.out.println("Input NIM gagal");
                continueInput = false;
            } else {
                i--;
            }
        }
        input.close();
    }

    static int checkNim(String nim) {
        if (nim.length() == 15) {
            return 1;
        } else {
            return 0;
        }
    }

    static void menuStudent() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Student Menu =====");
        System.out.println("1. Buku Terpinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Pinjam Buku atau Logout");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        Mahasiswa menu = new Mahasiswa();

        switch (pil) {
            case 1:
                System.out.println("Buku Terpinjam");
                menu.displayBooks();
                break;
            case 2:
                System.out.println("Pinjam Buku");
                menuStudent();
                break;
            case 3:
                System.out.println("Pinjam Buku atau Logout");
                menu.Logout();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }

    static void menuAdmin() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        Admin settingan = new Admin();

        switch (pil) {
            case 1:
                settingan.addStudent();
               break;
            case 2:
                settingan.displayStudents();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }
}

class Admin {
    String adminUsername;
    String adminPassword;
    String[] studentList;

    void displayStudents() {
        for (String data : Main.userStudent) {
            studentList = data.split("-");
            System.out.println("Nama: "+studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2]+"\nProgram:"+studentList[3]+"\n");
        }
        Main.menuAdmin();
    }

    void addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama Mahasiswa : ");
        String nama = input.nextLine();
        System.out.print("Masukkan nim Mahasiswa : ");
        String nim = input.nextLine();
        while (nim.length() != 15) {
            System.out.println("NIM harus 15 Digit !!!");
            System.out.print("Masukkan nim Mahasiswa : ");
            nim = input.nextLine();
        }
        System.out.print("Masukkan fakultas Mahasiswa : ");
        String fakultas = input.nextLine();
        System.out.print("Masukkan jurusan Mahasiswa : ");
        String jurusan = input.nextLine();

        Main.userStudent.add(nama + "-" + fakultas + "-" +nim+"-"+ jurusan);

        Main.menuAdmin();
        input.close();
    }
}


class Mahasiswa {
    String name;
    String faculty;
    String programStudi;

    void Logout(){
        Scanner input = new Scanner(System.in);
        int pil;
        System.out.println("Input Id Buku yang Ingin dipinjam (input 99 untuk back)");
        System.out.print("Input: ");
        pil = input.nextInt();
        if (pil == 99) {
            Main.menu();
        }
        input.close();
    }

    void displayBooks(){

        System.out.println("===================================================================================");
        System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Stock ||");
        System.out.println("===================================================================================");

        for (int i = 0; i < Main.bookList.size(); i++) {
            String[] book = Main.bookList.get(i).split("\\*");
            System.out.println("|| " + (i + 1) + " || " + book[0] + "\t ||" +book[1] + "\t || " +book[2] + "\t ||" + book[3] + "\t || " + book[4]+"   ||");
        }

        System.out.println("===================================================================================");

         Main.menuStudent();
    }
    
}