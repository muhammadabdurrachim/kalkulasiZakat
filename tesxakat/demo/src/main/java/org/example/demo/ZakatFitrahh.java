package org.example.demo;

import java.time.LocalDate;

class ZakatFitrah extends Zakat {
    private static final double beratBeras = 2.5; // kg
    private static final double hargaBeras = 20000; // rupiah
    private int jumlahOrang;

    public ZakatFitrah(String nama, LocalDate tanggal, int jumlahOrang) {
        super(nama, tanggal, "Zakat Fitrah");
        this.jumlahOrang = jumlahOrang;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    @Override
    public int hitungZakat() {
        double totalJumlahBeras = jumlahOrang * beratBeras;
        double totalJumlahUang = totalJumlahBeras * hargaBeras;
        return (int) totalJumlahUang;
    }
}
