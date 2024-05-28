package kumaracafe.s;

import java.util.Scanner;

public class KumaraCafeS {
    private static Scanner inputan = new Scanner(System.in);
    private static final pesanan[] pesanan = new pesanan[20];
    private static String namaPemesan = "";
    private static int indexPesanan = 0;

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("         Selamat Datang di Kumara Cafe's");
        System.out.println("===============================================");

        System.out.print("Masukkan nama pemesan: ");
        namaPemesan = inputan.nextLine();

        tampilkanMenu();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Tampilkan Pesanan");
            System.out.println("3. Edit Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = Integer.parseInt(inputan.nextLine());

            switch (menu) {
                case 1 -> tambahPesanan();
                case 2 -> tampilkanPesanan();
                case 3 -> editPesanan();
                case 4 -> hapusPesanan();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan Kumara Cafe's. Selamat tinggal!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
    }

    private static void tambahPesanan() {
        if (indexPesanan < 20) {
            System.out.print("Masukkan pesanan ke-" + (indexPesanan + 1) + ": ");
            String namaMenu = inputan.nextLine();
            System.out.print("Jumlah pesan: ");
            int jumlahPesan = Integer.parseInt(inputan.nextLine());
            pesanan[indexPesanan] = new pesanan(namaMenu, jumlahPesan);
            indexPesanan++;
        } else {
            System.out.println("Pesanan sudah mencapai batas maksimal.");
        }
    }

    private static void tampilkanPesanan() {
        if (indexPesanan == 0) {
            System.out.println("Tidak ada pesanan.");
            return;
        }

        System.out.println("---------------------------------------------");
        System.out.println("           List pesanan dari " + namaPemesan + "                  ");
        System.out.println("---------------------------------------------");
        System.out.printf("| %-3s | %-13s | %-6s | %-10s |\n", "No.", "Nama Menu", "Jumlah", "Sub Total");
        System.out.println("---------------------------------------------");

        int totalBayar = 0;
        for (int i = 0; i < indexPesanan; i++) {
            pesanan p = pesanan[i];
            int subtotal = p.hitungSubtotal();
            totalBayar += subtotal;
            System.out.printf("| %-3d | %-13s | %-6d | %-10d |\n", (i + 1), p.getNamaMenu(), p.getJumlahPesanan(), subtotal);
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total Bayar: " + totalBayar);
        System.out.println("============================================");
        System.out.print("Pembayaran Konsumen: ");
        int bayar = Integer.parseInt(inputan.nextLine());
        int kembalian = bayar - totalBayar;
        if (kembalian < 0) {
            System.out.println("Uang yang dibayar tidak mencukupi.");
        } else if (kembalian == 0) {
            System.out.println("Uang yang dibayar pas.");
        } else {
            System.out.println("Kembalian: " + kembalian);
        }
        System.out.println("--------------------------------------------");
    }

    private static void editPesanan() {
        if (indexPesanan > 0) {
            System.out.print("Masukkan nomor pesanan yang ingin di-edit: ");
            int editIndex = Integer.parseInt(inputan.nextLine()) - 1;
            if (editIndex >= 0 && editIndex < indexPesanan) {
                System.out.print("Masukkan pesanan baru: ");
                String namaMenu = inputan.nextLine();
                System.out.print("Jumlah pesan baru: ");
                int jumlahPesan = Integer.parseInt(inputan.nextLine());
                pesanan[editIndex].setNamaMenu(namaMenu);
                pesanan[editIndex].setJumlahPesanan(jumlahPesan);
            } else {
                System.out.println("Nomor pesanan tidak valid.");
            }
        } else {
            System.out.println("Tidak ada pesanan untuk di-edit.");
        }
    }

    private static void hapusPesanan() {
        if (indexPesanan > 0) {
            System.out.print("Masukkan nomor pesanan yang ingin dihapus: ");
            int deleteIndex = Integer.parseInt(inputan.nextLine()) - 1;
            if (deleteIndex >= 0 && deleteIndex < indexPesanan) {
                for (int i = deleteIndex; i < indexPesanan - 1; i++) {
                    pesanan[i] = pesanan[i + 1];
                }
                pesanan[indexPesanan - 1] = null;
                indexPesanan--;
            } else {
                System.out.println("Nomor pesanan tidak valid.");
            }
        } else {
            System.out.println("Tidak ada pesanan untuk dihapus.");
        }
    }

    private static void tampilkanMenu() {
        System.out.println("===============================================");
        System.out.println("|                  Daftar Menu            |");
        System.out.println("===============================================");
        System.out.println("| No. |      Menu       |        Harga        |");
        System.out.println("===============================================");
        System.out.println("|  1. |   Es Teh        |       Rp. 1000      |");
        System.out.println("|  2. |   Es Jeruk      |       Rp. 3000      |");
        System.out.println("|  3. |   Lemon Tea     |       Rp. 5000      |");
        System.out.println("|  4. |   Carbonara     |      Rp. 45000      |");
        System.out.println("|  5. |   Canai         |      Rp. 12000      |");
        // Tambahkan menu lainnya sesuai kebutuhan
        System.out.println("===============================================");
    }

    public static int hargaMenu(String menu) {
        return switch (menu.toLowerCase()) {
            case "es teh" -> 1000;
            case "es jeruk" -> 3000;
            case "lemon tea" -> 5000;
            case "carbonara" -> 45000;
            case "canai" -> 12000;
            default -> 0;
        };
    }
}
