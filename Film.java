
/**
 * Class untuk menyimpan data film bioskop.
 */
public class Film {
    private String kodeFilm;
    private String judul;
    private String genre;
    private int durasi;
    private boolean tersedia;

    public Film() {
        this("F001", "Film Default", "Umum", 120, true);
    }

    public Film(String kodeFilm, String judul,
                String genre, int durasi, boolean tersedia) {
        this.kodeFilm = kodeFilm;
        this.judul = judul;
        this.genre = genre;
        setDurasi(durasi);
        this.tersedia = tersedia;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Film: " + kodeFilm);
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Tersedia: " + tersedia);
    }

    public void ubahKetersediaan(boolean status) {
        this.tersedia = status;
    }

    public boolean cocokJudul(String kata) {
        return judul.equalsIgnoreCase(kata);
    }

    public String getKodeFilm() {
        return kodeFilm;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setDurasi(int durasi) {
        if (durasi > 0) {
            this.durasi = durasi;
        } else {
            throw new IllegalArgumentException(
                "Durasi harus lebih dari 0!"
            );
        }
    }
}
