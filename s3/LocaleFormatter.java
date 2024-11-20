import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class LocaleFormatter {
    public static void main(String[] args) throws Exception {
        // Definisikan locale untuk Indonesia, Malaysia, dan Amerika Serikat
        Locale[] locales = {new Locale("id", "ID"), new Locale("ms", "MY"), Locale.US};

        // Tampilkan informasi tentang setiap locale
        for (Locale locale : locales) {
            System.out.println("Locale: " + locale.toString());
            System.out.println("Language: " + locale.getDisplayLanguage(locale));
            System.out.println("Country: " + locale.getDisplayCountry(locale));
            System.out.println("Display Name: " + locale.getDisplayName(locale));
            System.out.println();
        }

        // Ambil input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan sebuah angka: ");
        double number = scanner.nextDouble();
        scanner.nextLine(); // Konsumsi newline
        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String inputDate = scanner.nextLine();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputDateFormat.parse(inputDate);

        System.out.println();

        // Format angka, mata uang, dan tanggal untuk setiap locale
        for (Locale locale : locales) {
            System.out.println("Locale: " + locale.toString());

            // Format angka
            NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
            System.out.println("Formatted number: " + numberFormat.format(number));

            // Format mata uang
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
            Currency currency = Currency.getInstance(locale);
            System.out.println("Formatted currency: " + currencyFormat.format(number));
            System.out.println("Currency symbol: " + currency.getSymbol(locale));

            // Format tanggal
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
            System.out.println("Formatted date: " + dateFormat.format(date));
            System.out.println();
        }

        scanner.close();
    }
}
