package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HistoryController {

    @FXML
    private TextField nama;

    @FXML
    private Pane hasilPane;

    @FXML
    private Label hasilNama;

    @FXML
    private Label hasilTanggal;

    @FXML
    private Label hasilJenisZakat;

    @FXML
    private Label hasilJumlahZakat;

    @FXML
    private Label hasilJumlahZakat2;

    @FXML
    private Label hasilNama2;

    @FXML
    private Pane hasilPane2;

    @FXML
    private Label hasilJenisZakat2;

    @FXML
    private Label hasilTanggal2;

    @FXML
    private Button hapusHistory;

    @FXML
    private Button hapusHistory2;

    @FXML
    private Button kembaliMenu2;

    private Zakat zakat1;
    private Zakat zakat2;

    @FXML
    void handleCari() {
        String namaOrang = nama.getText();
        List<Zakat> zakatList = HistoryZakat.getInstance().getZakatDetails(namaOrang);

        if (!zakatList.isEmpty()) {
            zakat1 = zakatList.get(0);
            hasilNama.setText(zakat1.getNama());
            hasilTanggal.setText(zakat1.getTanggal().toString());
            hasilJenisZakat.setText(zakat1.getJenisZakat());
            hasilJumlahZakat.setText(formatJumlahZakat(zakat1));
            hasilPane.setVisible(true);
            hasilPane2.setVisible(false);

            if (zakatList.size() > 1) {
                zakat2 = zakatList.get(1);
                hasilNama2.setText(zakat2.getNama());
                hasilTanggal2.setText(zakat2.getTanggal().toString());
                hasilJenisZakat2.setText(zakat2.getJenisZakat());
                hasilJumlahZakat2.setText(formatJumlahZakat(zakat2));
                hasilPane2.setVisible(true);
            } else {
                hasilPane2.setVisible(false);
            }
        } else {
            hasilPane.setVisible(false);
            hasilPane2.setVisible(false);
            System.out.println("Zakat tidak ditemukan.");
        }
    }

    private String formatJumlahZakat(Zakat zakat) {
        if (zakat instanceof ZakatFitrah) {
            return "Rp. " + zakat.hitungZakat() + " rupiah";
        } else if (zakat instanceof ZakatEmasdanPerak) {
            ZakatEmasdanPerak zakatEmasdanPerak = (ZakatEmasdanPerak) zakat;
            return "Zakat Emas: " + zakatEmasdanPerak.hitungZakatEmas() + " gram \nZakat Perak: " + zakatEmasdanPerak.hitungZakatPerak() + " gram";
        } else if (zakat instanceof ZakatPertanian) {
            ZakatPertanian zakatPertanian = (ZakatPertanian) zakat;
            return zakatPertanian.hitungZakat() + " Kg";
        } else if (zakat instanceof ZakatPenghasilan) {
            ZakatPenghasilan zakatPenghasilan = (ZakatPenghasilan) zakat;
            return "Rp. " + zakatPenghasilan.hitungZakat() + " Rupiah ";
        } else if (zakat instanceof ZakatPeternakan) {
            ZakatPeternakan zakatPeternakan = (ZakatPeternakan) zakat;
            return "Zakat Kambing/Domba : " + zakatPeternakan.hitungZakatKambingDomba() + " Ekor \nZakat Sapi: " + zakatPeternakan.hitungZakatSapi() + " Ekor";
        } else {
            return "Rp. " + zakat.hitungZakat() + " rupiah";
        }
    }

    @FXML
    void hapusHistory(ActionEvent event) {
        if (zakat1 != null) {
            HistoryZakat.getInstance().deleteZakat(zakat1);
            hasilPane.setVisible(false);

            zakat1 = null;
            zakat2 = null;
            System.out.println("Riwayat zakat pertama berhasil dihapus!");
        }
    }

    @FXML
    void hapusHistory2(ActionEvent event) {
        if (zakat2 != null) {
            HistoryZakat.getInstance().deleteZakat(zakat2);
            hasilPane2.setVisible(false);
            zakat2 = null;
            System.out.println("Riwayat zakat kedua berhasil dihapus!");
        }
    }

    @FXML
    void kembaliMenu2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
