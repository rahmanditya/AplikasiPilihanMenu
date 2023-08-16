package com.example.pilihanmenu;

public class Menu {

    private String nama,deskripsi;
    private float harga;
    private int id_gambar;
    private boolean pesan;

    public Menu(String nama, String deskripsi, Float harga, int id_gambar, boolean pesan) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.id_gambar = id_gambar;
        this.pesan = pesan;
    }

    public String getNama() { return nama; }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public int getId_gambar() {
        return id_gambar;
    }

    public void setId_gambar(int id_gambar) {
        this.id_gambar = id_gambar;
    }

    public boolean isPesan() {
        return pesan;
    }

    public void setPesan(boolean pesan) {
        this.pesan = pesan;
    }
}
