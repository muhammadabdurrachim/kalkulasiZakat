package org.example.demo;

import java.time.LocalDate;

class ZakatPertanian extends Zakat {
    private static final double nisabPerTahun = 750;
    private double hasilPanen;

    public ZakatPertanian(String nama, LocalDate tanggal, double hasilPanen) {
        super(nama, tanggal, "Zakat Pertanian");
        this.hasilPanen = hasilPanen;
    }

    public double getHasilPanen() {
        return hasilPanen;
    }

    public void setHasilPanen(double hasilPanen) {
        this.hasilPanen = hasilPanen;
    }

    @Override
    public int hitungZakat(){
        if (hasilPanen > nisabPerTahun) {
            return (int) (0.05 * hasilPanen);
        } else {
            return 0;
        }
    }
}
