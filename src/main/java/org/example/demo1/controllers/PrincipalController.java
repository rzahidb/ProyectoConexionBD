package org.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo1.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class PrincipalController {

    @FXML
    private Label lblEstado;

    @FXML
    private void probarConexion() {

        try (Connection connection = DatabaseConnection.getConnection()) {

            lblEstado.setText("Conectado");

        } catch (SQLException e) {

            lblEstado.setText("Error de conexión");
            e.printStackTrace();

        }
    }
}