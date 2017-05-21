/**
 * Created by bigme on 21.05.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Diplim extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("control.fxml"));
        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene(root, 300, 180));
        primaryStage.show();
    }
}
