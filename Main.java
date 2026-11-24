import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bioskop bioskop = new Bioskop("Bioskop Mini Aryl");
        AntrianTiket antrian = new AntrianTiket();

        int pilihan;
        int nomorTiket = 1;

        do {
            System.out.println("\n==============================");
            System.out.println("   SISTEM MANAJEMEN BIOSKOP");
            System.out.println("==============================");
            System.out.println("1. Tambah Film");
            System.out.println("2. Tampilkan Film");
            System.out.println("3. Tambah Studio");
            System.out.println("4. Tampilkan Studio");
            System.out.println("5. Pesan Tiket");
            System.out.println("6. Proses Antrean Tiket");
            System.out.println("7. Tampilkan Antrean");
            System.out.println("8. Tampilkan Semua Tiket");
            System.out.println("9. Cari Tiket");
            System.out.println("10. Laporan Bioskop");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {

                    case 1:
                        System.out.print("Kode Film: ");
                        String kode = input.nextLine();

                        System.out.print("Judul Film: ");
                        String judul = input.nextLine();

                        System.out.print("Genre: ");
                        String genre = input.nextLine();

                        System.out.print("Durasi (menit): ");
                        int durasi = Integer.parseInt(input.nextLine());

                        if (kode.isBlank() ||
                            judul.isBlank() ||
                            genre.isBlank()) {
                            System.out.println("Data tidak boleh kosong!");
                            break;
                        }

                        bioskop.tambahFilm(
                            new Film(kode, judul, genre, durasi, true)
                        );
                        break;

                    case 2:
                        bioskop.tampilkanFilm();
                        break;

                    case 3:
                        System.out.print("Kode Studio: ");
                        String kodeStudio = input.nextLine();

                        System.out.print("Nama Studio: ");
                        String namaStudio = input.nextLine();

                        System.out.print("Kapasitas: ");
                        int kapasitas = Integer.parseInt(input.nextLine());

                        if (kodeStudio.isBlank() ||
                            namaStudio.isBlank()) {
                            System.out.println("Data tidak boleh kosong!");
                            break;
                        }

                        bioskop.tambahStudio(
                            new Studio(
                                kodeStudio, namaStudio, kapasitas, true
                            )
                        );
                        break;

                    case 4:
                        bioskop.tampilkanStudio();
                        break;

                    case 5:
                        System.out.print("Kode Film: ");
                        Film film = bioskop.cariFilm(input.nextLine());

                        System.out.print("Kode Studio: ");
                        Studio studio = bioskop.cariStudio(input.nextLine());

                        if (film == null || studio == null) {
                            System.out.println(
                                "Film atau studio tidak ditemukan!"
                            );
                            break;
                        }

                        System.out.print("Nama Pembeli: ");
                        String pembeli = input.nextLine();

                        System.out.print("Nomor Kursi: ");
                        String kursi = input.nextLine();

                        if (pembeli.isBlank() || kursi.isBlank()) {
                            System.out.println("Data tidak boleh kosong!");
                            break;
                        }

                        Tiket tiket = new Tiket(
                            "T" + nomorTiket,
                            film,
                            studio,
                            pembeli,
                            kursi,
                            35000
                        );

                        if (antrian.enqueue(tiket)) {
                            nomorTiket++;
                        }
                        break;

                    case 6:
                        Tiket pesanan = antrian.dequeue();

                        if (pesanan != null) {
                            bioskop.prosesPesanan(pesanan);
                        }
                        break;

                    case 7:
                        antrian.tampilkanAntrian();
                        System.out.println(
                            "Jumlah antrean: " + antrian.size()
                        );
                        break;

                    case 8:
                        bioskop.tampilkanTiket();
                        break;

                    case 9:
                        System.out.print("Masukkan kode tiket: ");
                        bioskop.cariTiket(input.nextLine());
                        break;

                    case 10:
                        bioskop.laporan();
                        break;

                    case 0:
                        System.out.println("Program selesai.");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                pilihan = -1;

            } catch (IllegalArgumentException e) {
                System.out.println("Kesalahan: " + e.getMessage());
                pilihan = -1;
            }

        } while (pilihan != 0);

        input.close();
    }
}
