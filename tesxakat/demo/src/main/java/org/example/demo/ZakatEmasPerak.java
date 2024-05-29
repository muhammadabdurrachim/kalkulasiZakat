package org.example.demo;

import java.time.LocalDate;

class ZakatEmasdanPerak extends Zakat{
    private static final double nisabEmas = 85; //gram
    private static final double nisabPerak = 595; //gram
    private double jumlahEmas_Gram;
    private double jumlahPerak_Gram;

    public ZakatEmasdanPerak(String nama, LocalDate tanggal, double jumlahEmas_Gram, double jumlahPerak_Gram) {
        super(nama,tanggal,"Zakat Emas dan Perak");
        this.jumlahEmas_Gram = jumlahEmas_Gram;
        this.jumlahPerak_Gram = jumlahPerak_Gram;
    }

    public double getJumlahEmas_Gram() {
        return jumlahEmas_Gram;
    }

    public void setJumlahEmas_Gram(double jumlahEmas_Gram) {
        this.jumlahEmas_Gram = jumlahEmas_Gram;
    }

    public double getJumlahPerak_Gram() {
        return jumlahPerak_Gram;
    }

    public void setJumlahPerak_Gram(double jumlahPerak_Gram) {
        this.jumlahPerak_Gram = jumlahPerak_Gram;
    }

    @Override
    public int hitungZakat(){
        int zakatEmas = hitungZakatEmas();
        int zakatPerak = hitungZakatPerak();
        return zakatEmas + zakatPerak;
    }
    public int hitungZakatEmas(){
        if (jumlahEmas_Gram > nisabEmas) {
            return (int) (0.025 * jumlahEmas_Gram);
        } else {
            return 0;
        }
    }
    public int hitungZakatPerak(){
        if (jumlahPerak_Gram > nisabPerak){
            return (int) (0.025 * jumlahPerak_Gram);
        } else {
            return 0;
        }
    }
}
