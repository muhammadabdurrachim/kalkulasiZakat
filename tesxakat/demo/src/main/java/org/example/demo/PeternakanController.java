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

public class PeternakanController {

    @FXML
    private TextField JumlahSapi;

    @FXML
    private TextField Nama;

    @FXML
    private DatePicker Tanggal;

    @FXML
    private Button buttonHitung;

    @FXML
    private Button buttonKembali;

    @FXML
    private Label hasilZakat;

    @FXML
    private TextField JumlahKambingDomba;

    @FXML
    void buttonHitung(ActionEvent event) {
        try {
            // Ambil input dari TextField
            String namaOrang = Nama.getText();
            LocalDate tanggalLokal = Tanggal.getValue();
            double jumlahKambingDomba = Double.parseDouble(JumlahKambingDomba.getText());
            double jumlahSapi = Double.parseDouble(JumlahSapi.getText());

            // Validasi input
            if (namaOrang.isEmpty()) {
                hasilZakat.setText("Nama tidak boleh kosong.");
                return;
            }
            if (tanggalLokal == null) {
                hasilZakat.setText("Tanggal tidak boleh kosong.");
                return;
            }
            if (jumlahKambingDomba < 0) {
                hasilZakat.setText("Jumlah kambing/domba tidak boleh negatif.");
                return;
            }
            if (jumlahSapi < 0) {
                hasilZakat.setText("Jumlah sapi tidak boleh negatif.");
                return;
            }

            ZakatPeternakan zakatPeternakan = new ZakatPeternakan(namaOrang, tanggalLokal, jumlahKambingDomba, jumlahSapi);
            int zakatKambingDomba = zakatPeternakan.hitungZakatKambingDomba();
            int zakatSapi = zakatPeternakan.hitungZakatSapi();

            HistoryZakat.getInstance().addZakat(zakatPeternakan);

            hasilZakat.setText("Zakat Kambing/Domba: " + zakatKambingDomba + " Ekor\nZakat Sapi: " + zakatSapi + " Ekor");
        } catch (NumberFormatException e) {
            hasilZakat.setText("Jumlah emas dan perak harus berupa angka.");
        } catch (Exception e) {
            e.printStackTrace();
            hasilZakat.setText("Terjadi kesalahan dalam perhitungan zakat.");
        }
    }

    @FXML
    void buttonKembali(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuMaal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

