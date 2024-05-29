package org.example.demo;

import java.util.ArrayList;
import java.util.List;

public class HistoryZakat {
    private static HistoryZakat instance;
    private ArrayList<Zakat> zakats = new ArrayList<>();

    private HistoryZakat() {}

    public static HistoryZakat getInstance() {
        if (instance == null) {
            instance = new HistoryZakat();
        }
        return instance;
    }

    public void addZakat(Zakat zakat) {
        zakats.add(zakat);
        System.out.println("Riwayat zakat berhasil ditambahkan!");
    }

    public void deleteZakat(Zakat zakat) {
        zakats.remove(zakat);
        System.out.println("Riwayat zakat berhasil dihapus!");
    }

    public List<Zakat> getZakatDetails(String nama) {
        List<Zakat> result = new ArrayList<>();
        for (Zakat zakat : zakats) {
            if (zakat.getNama().equals(nama)) {
                result.add(zakat);
            }
        }
        return result;
    }
}
