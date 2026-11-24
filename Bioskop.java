
import java.util.ArrayList;

public class Bioskop {
    private String namaBioskop;
    private ArrayList<Film> daftarFilm;
    private ArrayList<Studio> daftarStudio;
    private ArrayList<Tiket> daftarTiket;

    public Bioskop() {
        this("Bioskop Mini");
    }

    public Bioskop(String namaBioskop) {
        this.namaBioskop = namaBioskop;
        this.daftarFilm = new ArrayList<>();
        this.daftarStudio = new ArrayList<>();
        this.daftarTiket = new ArrayList<>();
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
        System.out.println("Film berhasil ditambahkan.");
    }

    public void tambahStudio(Studio studio) {
        daftarStudio.add(studio);
        System.out.println("Studio berhasil ditambahkan.");
    }

    public void tampilkanFilm() {
        for (Film film : daftarFilm) {
            film.tampilkanInfo();
            System.out.println("----------------");
        }
    }

    public void tampilkanStudio() {
        for (Studio studio : daftarStudio) {
            studio.tampilkanInfo();
            System.out.println("----------------");
        }
    }

    public Film cariFilm(String kode) {
        for (Film film : daftarFilm) {
            if (film.getKodeFilm().equalsIgnoreCase(kode)) {
                return film;
            }
        }
        return null;
    }

    public Studio cariStudio(String kode) {
        for (Studio studio : daftarStudio) {
            if (studio.getKodeStudio().equalsIgnoreCase(kode)) {
                return studio;
            }
        }
        return null;
    }

    public boolean prosesPesanan(Tiket tiket) {
        if (tiket == null) {
            return false;
        }

        for (Tiket t : daftarTiket) {
            if (t.isAktif()
                && t.getStudio() == tiket.getStudio()
                && t.getNomorKursi().equalsIgnoreCase(
                    tiket.getNomorKursi())) {
                System.out.println("Kursi sudah dipesan!");
                return false;
            }
        }

        daftarTiket.add(tiket);
        System.out.println("Pesanan berhasil diproses.");
        return true;
    }

    public void tampilkanTiket() {
        for (Tiket tiket : daftarTiket) {
            if (tiket.isAktif()) {
                tiket.tampilkanInfo();
            }
        }
    }

    public void cariTiket(String kode) {
        for (Tiket tiket : daftarTiket) {
            if (tiket.getKodeTiket().equalsIgnoreCase(kode)) {
                tiket.tampilkanInfo();
                return;
            }
        }

        System.out.println("Tiket tidak ditemukan.");
    }

    public void laporan() {
        double total = 0;

        for (Tiket tiket : daftarTiket) {
            if (tiket.isAktif()) {
                total += tiket.hitungHarga();
            }
        }

        System.out.println("\n=== LAPORAN BIOSKOP ===");
        System.out.println("Nama: " + namaBioskop);
        System.out.println("Jumlah Film: " + daftarFilm.size());
        System.out.println("Jumlah Studio: " + daftarStudio.size());
        System.out.println("Jumlah Tiket: " + daftarTiket.size());
        System.out.println("Pendapatan: Rp" + total);
    }
}
