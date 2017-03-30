package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    private static final String URLk = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String pass = "root";
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)";
    private static final String VIVODtovar = "SELECT * FROM tovar";
    @FXML
    private TextField vx1;
    @FXML
    private TextField vx2;

    String v1;
    String v2;

    public void GO(ActionEvent actionEvent) {
        v1 = vx1.getText();
        v2 = vx2.getText();

        if (v1.equals("1") && v2.equals("1")) {
            System.out.println(v1);
            System.out.println(v2);
            try {
                Prepod(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("noo");
        }
    }

    private void Prepod(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage.setTitle("Редактирование записи");
        stage.setMinHeight(700);
        stage.setMinWidth(700);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }
}
