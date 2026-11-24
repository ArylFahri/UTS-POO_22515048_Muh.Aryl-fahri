
/**
 * Class untuk menyimpan data studio bioskop.
 */
public class Studio {
    private String kodeStudio;
    private String namaStudio;
    private int kapasitas;
    private boolean aktif;

    public Studio() {
        this("S001", "Studio 1", 30, true);
    }

    public Studio(String kodeStudio, String namaStudio,
                  int kapasitas, boolean aktif) {
        this.kodeStudio = kodeStudio;
        this.namaStudio = namaStudio;
        setKapasitas(kapasitas);
        this.aktif = aktif;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Studio: " + kodeStudio);
        System.out.println("Nama Studio: " + namaStudio);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Status Aktif: " + aktif);
    }

    public boolean tersediaKursi() {
        return kapasitas > 0 && aktif;
    }

    public void ubahStatus(boolean status) {
        this.aktif = status;
    }

    public String getKodeStudio() {
        return kodeStudio;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        } else {
            throw new IllegalArgumentException(
                "Kapasitas harus lebih dari 0!"
            );
        }
    }
}
