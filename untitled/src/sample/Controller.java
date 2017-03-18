package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField x1;
    public TextField x2;

    public void vv(ActionEvent actionEvent) {
       String D = String.valueOf(x1.getText());
        //x1.setText(String.valueOf(a + b + c))
        System.out.println(D);
        if(D=="1"){
            System.out.println("fffffffff");

        }


    }
}
