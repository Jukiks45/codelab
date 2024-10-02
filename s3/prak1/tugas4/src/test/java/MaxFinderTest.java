import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test; 
import com.example.MaxFinder; 

public class MaxFinderTest {

    // Pengujian untuk memastikan metode findMax bekerja dengan benar untuk angka positif
    @Test
    public void ujiAngkaPositif() {
        assertEquals(3, MaxFinder.findMax(1, 2, 3), "Nilai maksimum dari 1, 2, 3 haruslah 3");
        assertEquals(3, MaxFinder.findMax(3, 2, 1), "Nilai maksimum dari 3, 2, 1 haruslah 3");
    }

    // Pengujian untuk memastikan metode findMax bekerja dengan benar untuk angka negatif
    @Test
    public void ujiAngkaNegatif() {
        assertEquals(-1, MaxFinder.findMax(-1, -2, -3), "Nilai maksimum dari -1, -2, -3 haruslah -1");
    }

    // Pengujian untuk memastikan metode findMax bekerja dengan benar untuk kombinasi angka positif dan negatif atau nol
    @Test
    public void ujiAngkaCampuran() {
        assertEquals(1, MaxFinder.findMax(0, 0, 1), "Nilai maksimum dari 0, 0, 1 haruslah 1");
    }

    // Pengujian untuk memastikan metode findMax bekerja dengan benar ketika semua angka yang diuji adalah sama
    @Test
    public void ujiAngkaSamaSemua() {
        assertEquals(5, MaxFinder.findMax(5, 5, 5), "Nilai maksimum dari 5, 5, 5 haruslah 5");
    }

    // Pengujian untuk memastikan metode findMax bekerja dengan benar ketika semua angka adalah nol
    @Test
    public void ujiAngkaNol() {
        assertEquals(0, MaxFinder.findMax(0, 0, 0), "Nilai maksimum dari 0, 0, 0 haruslah 0");
    }
}
