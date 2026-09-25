package org.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo1.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    @FXML
    private void obtenerEstudaintes(){
        String sql = "SELECT * FROM estudiante";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

        ){
            System.out.println("Listado de estudiantes");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");

                System.out.println(id + " " + nombre +  " " + correo + " ");
            }
        }catch (SQLException e){
            System.out.println("Error al obtener un estudiante");
            e.printStackTrace();
        }
    }
}