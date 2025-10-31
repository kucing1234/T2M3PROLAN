
import java.security.SecureRandom;
import java.util.Random;

/**
 * Kelas PasswordGenerator bertanggung jawab untuk membuat
 * kata sandi acak (random password) yang aman.
 *
 * @author Nama Praktikan (NIM Anda)
 * @version 1.0
 * @since 2025-10-31
 */
public class PasswordGenerator {

    /**
     * String konstan yang berisi semua karakter yang diizinkan
     * untuk pembuatan password (Kapital, Huruf Kecil, Angka, Simbol).
     */
    private static final String KARAKTER_GABUNGAN =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz" +
                    "0123456789" +
                    "!@#$%^&*()_+-=[]{}|;:,.<>?";

    /**
     * Objek Random yang aman untuk menghasilkan nilai acak.
     */
    private final Random random = new SecureRandom();

    /**
     * Panjang kata sandi yang akan dibuat.
     */
    private final int panjang;

    /**
     * Konstruktor untuk kelas PasswordGenerator.
     *
     * @param panjang Panjang yang diinginkan untuk kata sandi.
     * @throws IllegalArgumentException jika panjang yang diberikan kurang dari atau sama dengan 0.
     */
    public PasswordGenerator(int panjang) {
        if (panjang <= 0) {
            throw new IllegalArgumentException("Panjang password harus lebih dari 0");
        }
        this.panjang = panjang;
    }

    /**
     * Method utama untuk menghasilkan kata sandi.
     *
     * @return String kata sandi yang telah diacak.
     */
    public String generatePassword() {
        StringBuilder password = new StringBuilder(this.panjang);

        for (int i = 0; i < this.panjang; i++) {
            int randomIndex = random.nextInt(KARAKTER_GABUNGAN.length());
            password.append(KARAKTER_GABUNGAN.charAt(randomIndex));
        }

        return password.toString();
    }
}