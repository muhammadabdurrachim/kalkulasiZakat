package org.example.demo;

import java.time.LocalDate;

class ZakatPeternakan extends Zakat{
    private static final double nisabKambingDomba = 40;
    private static final double nisabSapi = 30;
    private double jumlahKambingDanDomba;
    private double jumlahSapi;

    public ZakatPeternakan(String nama, LocalDate tanggal, double jumlahKambingDanDomba, double jumlahSapi) {
        super(nama, tanggal, "Zakat Peternakan");
        this.jumlahKambingDanDomba = jumlahKambingDanDomba;
        this.jumlahSapi = jumlahSapi;
    }

    public double getJumlahKambingDanDomba() {
        return jumlahKambingDanDomba;
    }

    public void setJumlahKambingDanDomba(double jumlahKambingDanDomba) {
        this.jumlahKambingDanDomba = jumlahKambingDanDomba;
    }

    public double getJumlahSapi() {
        return jumlahSapi;
    }

    public void setJumlahSapi(double jumlahSapi) {
        this.jumlahSapi = jumlahSapi;
    }

    @Override
    public int hitungZakat() {
        int zakatKambingDanDomba = hitungZakatKambingDomba();
        int zakatSapi = hitungZakatSapi();
        return zakatKambingDanDomba + zakatSapi;
    }
    public int hitungZakatKambingDomba(){
        if (jumlahKambingDanDomba > nisabKambingDomba){
            return (int) (jumlahKambingDanDomba / nisabKambingDomba);
        } else {
            return 0;
        }
    }
    public int hitungZakatSapi(){
        if (jumlahSapi > nisabSapi) {
            return (int) (jumlahSapi / nisabSapi);
        } else {
            return 0;
        }
    }
}
