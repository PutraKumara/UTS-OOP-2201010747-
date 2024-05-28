package kumaracafe.s;

public class pesanan {
    private String namaMenu;
    private int jumlahPesanan;

    // Constructor
    public pesanan(String namaMenu, int jumlahPesanan) {
        this.namaMenu = namaMenu;
        this.jumlahPesanan = jumlahPesanan;
    }

    // Getters and Setters
    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    // Method to calculate subtotal
    public int hitungSubtotal() {
        return jumlahPesanan * KumaraCafeS.hargaMenu(namaMenu);
    }
}
