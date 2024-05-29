package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class PertanianController {

    @FXML
    private TextField HasilPanen;

    @FXML
    private TextField Nama;

    @FXML
    private DatePicker Tanggal; // Mengubah ke DatePicker

    @FXML
    private Button buttonKembali;

    @FXML
    private Label hasilZakat;

    @FXML
    private Button hitungPanen;


    @FXML
    void hitungPanen(ActionEvent event) {
        try {
            // Ambil input dari TextField
            String namaOrang = Nama.getText();
            LocalDate tanggalLokal = Tanggal.getValue();
            double hasilPanen = Double.parseDouble(HasilPanen.getText());

            // Validasi input
            if (namaOrang.isEmpty()) {
                hasilZakat.setText("Nama tidak boleh kosong.");
                return;
            }
            if (tanggalLokal == null) {
                hasilZakat.setText("Tanggal tidak boleh kosong.");
                return;
            }
            if (hasilPanen < 0) {
                hasilZakat.setText("Hasil panen tidak boleh negatif.");
                return;
            }

            ZakatPertanian zakatPertanian = new ZakatPertanian(namaOrang, tanggalLokal, hasilPanen);
            double jumlahZakat = zakatPertanian.hitungZakat();

            HistoryZakat.getInstance().addZakat(zakatPertanian);

            hasilZakat.setText("Zakat Pertanian: " + jumlahZakat + " Kg");
        } catch (NumberFormatException e) {
            hasilZakat.setText("Hasil panen harus berupa angka.");
        } catch (Exception e) {
            e.printStackTrace();
            hasilZakat.setText("Terjadi kesalahan dalam perhitungan zakat.");
        }
    }

    @FXML
    void buttonKembali(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("MenuMaal.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}