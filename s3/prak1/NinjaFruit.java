import java.util.*;
//tugas 1
public class NinjaFruit {
    public static void main(String[] args) {
        // benarkan syntax
        List<String> buah = Arrays.asList("apel", "pisang", "kiwi", "anggur", "semangka");
        System.out.println("Total huruf: " + calculateTotalLength(buah));
        System.out.println("Kata terpanjang: " + findLongestWord(buah));
        System.out.println("Daftar kata dalam huruf kapital: " + capitalizeWords(buah));
        System.out.println("Panjang masing-masing kata: " + wordLengths(buah));
    }

    public static int calculateTotalLength(List<String> words) { // menghitung jumlah huruf
        int totalLength = 0;
        //ubah <
        for (int i = 0; i < words.size(); i++) {
            totalLength += words.get(i).length();
        }
        return totalLength;
    }

    public static String findLongestWord(List<String> words) { // menemukan kata terpanjang
        if (words.isEmpty()) {
            throw new IllegalArgumentException("List kosong");
        }
        String longestWord = "";
        //tidak perlu ada else if karena if ini sudah bisa menghandle atau mencakup semua kemungkinan
        for (String word : words) {
            if (word != null && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static List<String> capitalizeWords(List<String> words) { // mengkapitalisasi semua kata
        List<String> capitalized = new ArrayList<>();
        for (String word : words) {
            //tidak usah menggunakan substring 1 nanti itu akan menghilangkan huruf pertama dari kata
            capitalized.add(word.toUpperCase());
        }
        return capitalized;
    }

    public static List<Integer> wordLengths(List<String> words) { // menghitung panjang kata
        List<Integer> lengths = new ArrayList<>();
        for (String word : words) {
            //mengganti operator == menjadi != karena harus dicek dulu sebelum memanggil word length
            if (word != null) {
                lengths.add(word.length());
            }
        }
        return lengths;
    }
}
