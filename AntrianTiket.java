
/**
 * Class ADT Queue untuk mengatur antrean tiket bioskop.
 */
public class AntrianTiket {
    private Tiket[] data;
    private int depan;
    private int belakang;
    private int jumlah;
    private final int KAPASITAS = 50;

    public AntrianTiket() {
        data = new Tiket[KAPASITAS];
        depan = 0;
        belakang = -1;
        jumlah = 0;
    }

    // Menambahkan tiket ke antrean
    public boolean enqueue(Tiket tiket) {
        if (isFull()) {
            System.out.println("Antrean penuh!");
            return false;
        }

        belakang = (belakang + 1) % KAPASITAS;
        data[belakang] = tiket;
        jumlah++;

        System.out.println("Tiket masuk antrean.");
        return true;
    }

    // Mengambil tiket dari depan antrean
    public Tiket dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return null;
        }

        Tiket tiket = data[depan];
        data[depan] = null;
        depan = (depan + 1) % KAPASITAS;
        jumlah--;

        return tiket;
    }

    public Tiket front() {
        if (isEmpty()) {
            return null;
        }

        return data[depan];
    }

    public boolean isEmpty() {
        return jumlah == 0;
    }

    public boolean isFull() {
        return jumlah == KAPASITAS;
    }

    public int size() {
        return jumlah;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrean masih kosong.");
            return;
        }

        System.out.println("\n=== DAFTAR ANTREAN ===");

        for (int i = 0; i < jumlah; i++) {
            int index = (depan + i) % KAPASITAS;

            System.out.println(
                (i + 1) + ". " + data[index].getKodeTiket()
            );
        }
    }
}
