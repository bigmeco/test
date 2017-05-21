import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
            AnchorPane root = FXMLLoader.load(getClass().getResource("loginint.fxml"));
            primaryStage.setResizable(false);

            primaryStage.setScene(new Scene(root, 300, 180));
            primaryStage.show();

    }
}
