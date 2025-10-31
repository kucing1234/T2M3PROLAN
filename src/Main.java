
import java.util.Scanner;

/**
 * Kelas Main adalah titik masuk (entry point) utama untuk
 * aplikasi Generator Password Sederhana.
 *
 * @author Nama Praktikan (NIM Anda)
 * @version 1.0
 */
public class Main {

    /**
     * Method main yang dieksekusi saat program dijalankan.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("  GENERATOR PASSWORD SEDERHANA   ");
        System.out.println("===================================");

        int panjangPassword = 0;
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print("Masukkan panjang password yang diinginkan (contoh: 12): ");
            try {
                panjangPassword = Integer.parseInt(scanner.nextLine());

                if (panjangPassword > 0) {
                    inputValid = true;
                } else {
                    System.out.println("Input tidak valid. Panjang harus lebih besar dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }

        try {
            PasswordGenerator generator = new PasswordGenerator(panjangPassword);
            String password = generator.generatePassword();

            System.out.println("\nPassword baru Anda adalah:");
            System.out.println("-----------------------------------");
            System.out.println(password);
            System.out.println("-----------------------------------");

        } catch (IllegalArgumentException e) {
            System.err.println("Terjadi error: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Program selesai.");
    }
}