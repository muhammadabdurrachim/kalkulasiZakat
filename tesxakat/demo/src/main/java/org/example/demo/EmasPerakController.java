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

public class EmasPerakController {

    @FXML
    private TextField JumlahEmas;

    @FXML
    private TextField JumlahPerak;

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
    void buttonHitung(ActionEvent event) {
        try {
            // Ambil input dari TextField
            String namaOrang = Nama.getText();
            LocalDate tanggalLokal = Tanggal.getValue();
            double jumlahEmas = Double.parseDouble(JumlahEmas.getText());
            double jumlahPerak = Double.parseDouble(JumlahPerak.getText());

            // Validasi input
            if (namaOrang.isEmpty()) {
                hasilZakat.setText("Nama tidak boleh kosong.");
                return;
            }
            if (tanggalLokal == null) {
                hasilZakat.setText("Tanggal tidak boleh kosong.");
                return;
            }
            if (jumlahEmas < 0) {
                hasilZakat.setText("Jumlah emas tidak boleh negatif.");
                return;
            }
            if (jumlahPerak < 0) {
                hasilZakat.setText("Jumlah perak tidak boleh negatif.");
                return;
            }

            ZakatEmasdanPerak zakatEmasdanPerak = new ZakatEmasdanPerak(namaOrang, tanggalLokal, jumlahEmas, jumlahPerak);
            int zakatEmas = zakatEmasdanPerak.hitungZakatEmas();
            int zakatPerak = zakatEmasdanPerak.hitungZakatPerak();

            HistoryZakat.getInstance().addZakat(zakatEmasdanPerak);

            hasilZakat.setText("Zakat Emas: " + zakatEmas + " Gram\nZakat Perak: " + zakatPerak + " Gram");
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