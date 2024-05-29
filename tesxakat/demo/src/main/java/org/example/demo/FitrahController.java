package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.text.DecimalFormat;

public class FitrahController {

    @FXML
    private Button Back1;

    @FXML
    private Button buttonKalkulasiFitrah;

    @FXML
    private TextField family;

    @FXML
    private Label hasilZakat;

    @FXML
    private TextField nama;

    @FXML
    private DatePicker tanggal;

    @FXML
    void Back1F(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonKalkulasiFitrah(ActionEvent event) {
        try {
            // Ambil input dari TextField
            String namaOrang = nama.getText();
            LocalDate tanggalLokal = tanggal.getValue();
            int jumlahOrang = Integer.parseInt(family.getText());

            // Validasi input
            if (namaOrang.isEmpty()) {
                hasilZakat.setText("Nama tidak boleh kosong.");
                return;
            }
            if (tanggalLokal == null) {
                hasilZakat.setText("Harap isi Tanggal");
                return;
            }
            if (jumlahOrang <= 0) {
                hasilZakat.setText("Jumlah anggota keluarga harus lebih dari 0!");
                return;
            }

            ZakatFitrah zakatFitrah = new ZakatFitrah(namaOrang, tanggalLokal, jumlahOrang);
            int jumlahZakat = zakatFitrah.hitungZakat();

            HistoryZakat.getInstance().addZakat(zakatFitrah);

            DecimalFormat formatter = new DecimalFormat("#,###");
            String formattedZakat = formatter.format(jumlahZakat);

            hasilZakat.setText("Rp. " + formattedZakat + " rupiah");
        } catch (NumberFormatException e) {
            hasilZakat.setText("Jumlah anggota keluarga harus berupa angka.");
        } catch (Exception e) {
            e.printStackTrace();
            hasilZakat.setText("Mohon Maaf Terjadi Kesalahan dalam Perhitungan Zakat");
        }
    }
}
