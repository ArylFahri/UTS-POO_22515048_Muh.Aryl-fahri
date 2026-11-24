
/**
 * Class untuk menyimpan data pemesanan tiket.
 */
public class Tiket {
    private String kodeTiket;
    private Film film;
    private Studio studio;
    private String namaPembeli;
    private String nomorKursi;
    private double harga;
    private boolean aktif;

    public Tiket() {
        this("T001", null, null, "Umum", "A1", 35000);
    }

    public Tiket(String kodeTiket, Film film,
                 Studio studio, String namaPembeli,
                 String nomorKursi, double harga) {
        this.kodeTiket = kodeTiket;
        this.film = film;
        this.studio = studio;
        this.namaPembeli = namaPembeli;
        this.nomorKursi = nomorKursi;
        setHarga(harga);
        this.aktif = true;
    }

    public double hitungHarga() {
        return harga;
    }

    public void batalkanTiket() {
        aktif = false;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Tiket: " + kodeTiket);
        System.out.println("Film: " +
            (film != null ? film.getJudul() : "Belum dipilih"));
        System.out.println("Studio: " +
            (studio != null ? studio.getKodeStudio() : "Belum dipilih"));
        System.out.println("Pembeli: " + namaPembeli);
        System.out.println("Nomor Kursi: " + nomorKursi);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Status: " + aktif);
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public Film getFilm() {
        return film;
    }

    public Studio getStudio() {
        return studio;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            throw new IllegalArgumentException(
                "Harga harus lebih dari 0!"
            );
        }
    }
}
