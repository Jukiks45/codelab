import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();
    static Admin admin = new Admin();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Sistem Perpustakaan =====");
            System.out.println("1. Masuk sebagai Mahasiswa");
            System.out.println("2. Masuk sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    enterNim(scanner);
                    break;
                case "2":
                    admin.loginAdmin(scanner);
                    break;
                case "3":
                    System.out.println("Terima kasih. Menutup program.");
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    public static void enterNim(Scanner scanner) {
        System.out.print("Masukkan NIM Anda (masukkan 99 untuk kembali): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        } else if (checkNim(nim)) {
            Student student = new Student(nim);
            student.studentMenu(scanner);
        } else {
            System.out.println("NIM tidak valid. Silakan coba lagi.");
            enterNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void initializeData() {
        bookList.add(new Book("388c-e681-9152", "judul1", "pengarang1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "judul2", "pengarang2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "judul3", "pengarang3", "Sejarah", 3));

        userStudent.add(new Student("Taufiq Ramadhan", "202210370311288", "Teknik", "Informatika"));
        userStudent.add(new Student("Who", "200510370318521", "Teknik", "Informatika"));
        userStudent.add(new Student("Sutrisno Adit Pratama", "202210370311203", "Teknik", "Informatika"));
    }
}

class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int stock;

    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public int getStock() { return stock; }
}

class Student {
    private String name;
    private String nim;
    private String faculty;
    private String program;

    public Student(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public Student(String nim) {
        for (Student student : Main.userStudent) {
            if (student.getNim().equals(nim)) {
                this.name = student.getName();
                this.nim = student.getNim();
                this.faculty = student.getFaculty();
                this.program = student.getProgram();
                break;
            }
        }
    }

    public String getNim() { return nim; }

    public void studentMenu(Scanner scanner) {
        while (true) {
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. Buku yang Dipinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Pilih opsi (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buku yang Dipinjam:");
                    break;
                case "2":
                    displayBooks();
                    break;
                case "3":
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    public void displayBooks() {
        System.out.println("=======================================================================================================");
        System.out.printf("| %-4s | %-10s | %-30s | %-20s | %-15s | %-6s |\n", "No.", "ID Buku", "Judul Buku", "Pengarang", "Kategori", "Stok");
        System.out.println("=======================================================================================================");
        int index = 1;
        for (Book book : Main.bookList) {
            System.out.printf("| %-4d | %-10s | %-30s | %-20s | %-15s | %-6d |\n", index, book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock());
            index++;
        }
        System.out.println("=======================================================================================================");
    }

    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public String getProgram() { return program; }
}

class Admin {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public void loginAdmin(Scanner scanner) {
        System.out.print("Masukkan Username Admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Kata Sandi Admin: ");
        String password = scanner.nextLine();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            adminMenu(scanner);
        } else {
            System.out.println("Username atau kata sandi salah. Silakan coba lagi.");
        }
    }

    public void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa Terdaftar");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    displayStudent();
                    break;
                case "3":
                    System.out.println("Keluar dari akun admin.");
                    return;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Masukkan detail mahasiswa:");
        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM mahasiswa harus terdiri dari 15 digit.");
            }
        } while (nim.length() != 15);
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.nextLine();
        Main.userStudent.add(new Student(name, nim, faculty, program));
        System.out.println("Mahasiswa berhasil terdaftar.");
    }

    public void displayStudent() {
        System.out.println("Daftar Mahasiswa Terdaftar:");
        for (Student student : Main.userStudent) {
            System.out.println("Nama: " + student.getName());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Program Studi: " + student.getProgram());
            System.out.println();
        }
    }
}
