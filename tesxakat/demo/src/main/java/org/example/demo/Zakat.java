package org.example.demo;

import java.time.LocalDate;

abstract class Zakat {
    private String nama;
    private LocalDate tanggal;;
    private String jenisZakat;

    public Zakat(String nama, LocalDate tanggal, String jenisZakat){
        this.nama = nama;
        this.tanggal = tanggal;
        this.jenisZakat = jenisZakat;
    }

    public abstract int hitungZakat();

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public LocalDate getTanggal(){
        return tanggal;
    }
    public void setTanggal(LocalDate tanggal){
        this.tanggal = tanggal;
    }
    public String getJenisZakat() {
        return jenisZakat;
    }
}
