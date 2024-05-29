package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuMaalController {

    @FXML
    private Button hitungEmasPerak;

    @FXML
    private Button hitungPenghasilan;

    @FXML
    private Button hitungPertanian;

    @FXML
    private Button hitungPeternakan;

    @FXML
    private Button kembaliMenu;

    @FXML
    void hitungEmasPerak(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("EmasPerak.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void hitungPenghasilan(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Penghasilan.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void hitungPertanian(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Pertanian.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void hitungPeternakan(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Peternakan.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void kembaliMenu(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
