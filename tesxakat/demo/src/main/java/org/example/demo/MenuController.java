package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MenuController {

    @FXML
    private Button Fitrah1;

    @FXML
    private Button Maal;

    @FXML
    private Button Riwayat;

    // Handler untuk tombol Fitrah
    @FXML
    private void Fitrah1(ActionEvent event) throws IOException {
        loadFXML(event, "Fitrah.fxml");
    }

    // Handler untuk tombol Maal
    @FXML
    private void Maal(ActionEvent event) throws IOException {
        loadFXML(event, "MenuMaal.fxml");
    }

    @FXML
    private void Riwayat(ActionEvent event) throws IOException {
        loadFXML(event, "HistoryZakat.fxml");
    }

    // Method untuk memuat dan menampilkan FXML baru
    private void loadFXML(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Node node = fxmlLoader.load();
        Scene scene = new Scene((Parent) node);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
