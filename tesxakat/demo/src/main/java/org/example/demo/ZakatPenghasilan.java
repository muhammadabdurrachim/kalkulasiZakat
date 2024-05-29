package org.example.demo;

import java.time.LocalDate;

class ZakatPenghasilan extends Zakat {
    private static final double nisabPerBulan = 6800000;
    private double penghasilanPerBulan;
    private double penghasilanLain;

    public ZakatPenghasilan(String nama, LocalDate tanggal, double penghasilanPerBulan, double penghasilanLain) {
        super(nama, tanggal, "Zakat Penghasilan");
        this.penghasilanPerBulan = penghasilanPerBulan;
        this.penghasilanLain = penghasilanLain;
    }

    public double getPenghasilanPerBulan() {
        return penghasilanPerBulan;
    }

    public void setPenghasilanPerBulan(double penghasilanPerBulan) {
        this.penghasilanPerBulan = penghasilanPerBulan;
    }

    public double getPenghasilanLain() {
        return penghasilanLain;
    }

    public void setPenghasilanLain(double penghasilanLain) {
        this.penghasilanLain = penghasilanLain;
    }

    @Override
    public int hitungZakat(){
        double totalPenghasilanPerBulan = penghasilanPerBulan + penghasilanLain;
        if (totalPenghasilanPerBulan > nisabPerBulan){
            return (int) (0.025 * totalPenghasilanPerBulan);
        } else {
            return 0;
        }
    }
}
