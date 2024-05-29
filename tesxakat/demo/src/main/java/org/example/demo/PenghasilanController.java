package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class PenghasilanController {

    @FXML
    private TextField Nama;

    @FXML
    private TextField PenghasilanLain;

    @FXML
    private TextField PenghasilanPerBulan;

    @FXML
    private DatePicker Tanggal;

    @FXML
    private Label hasilZakat;

    @FXML
    private Button buttonKembali;

    @FXML
    private Button hitungPenghasilan;


    @FXML
    void hitungPenghasilan(ActionEvent event) {
        try {
            // Ambil input dari TextField
            String namaOrang = Nama.getText();
            LocalDate tanggalLokal = Tanggal.getValue();
            double penghasilanPerbulan = Double.parseDouble(PenghasilanPerBulan.getText());
            double penghasilanLain = Double.parseDouble(PenghasilanLain.getText());

            // Validasi input
            if (namaOrang.isEmpty()) {
                hasilZakat.setText("Nama tidak boleh kosong.");
                return;
            }
            if (tanggalLokal == null) {
                hasilZakat.setText("Tanggal tidak boleh kosong.");
                return;
            }
            if (penghasilanPerbulan < 0) {
                hasilZakat.setText("Penghasilan per bulan tidak boleh negatif.");
                return;
            }
            if (penghasilanLain < 0) {
                hasilZakat.setText("Penghasilan lain tidak boleh negatif.");
                return;
            }

            ZakatPenghasilan zakatPenghasilan = new ZakatPenghasilan(namaOrang, tanggalLokal, penghasilanPerbulan, penghasilanLain);
            int jumlahZakat = zakatPenghasilan.hitungZakat();

            HistoryZakat.getInstance().addZakat(zakatPenghasilan);

            DecimalFormat formatter = new DecimalFormat("#,###");
            String formatted = formatter.format(jumlahZakat);
            hasilZakat.setText("Rp. " + formatted + " rupiah");
        } catch (NumberFormatException e) {
            hasilZakat.setText("Penghasilan harus berupa angka.");
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