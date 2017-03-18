package sample;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
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
import java.sql.*;

public class Controller {



    private static final String URLk = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false" ;
    private static final String login = "root" ;
    private static final String pass = "root" ;
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)" ;
    private static final String VIVODtovar = "SELECT * FROM tovar" ;
    @FXML
    private TextField vx1;
    @FXML
    private TextField vx2;


    String v1;
    String v2;

//@FXML
//private void initialize() {
//    initData();
//    idT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("id"));
//    nameT.setCellValueFactory(new PropertyValueFactory<tovar, String>("name"));
//    maneT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("mane"));
//
//
//    tableUsers.setItems(usersData);
//}
//
//    private void initData() {
//        usersData.add(new tovar(1, "Alex", 15));
//        usersData.add(new tovar(2, "Bob", 45));
//        usersData.add(new tovar(3, "Jeck", 6456));
//        usersData.add(new tovar(4, "Mike", 456));
//        usersData.add(new tovar(5, "colin", 122));
//    }


    public void SQLZ() {
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URLk,login,pass);
            if(!connection.isClosed()){
                System.out.println("esti");
                preparedStatement = connection.prepareStatement(VIVODtovar);
//                preparedStatement.setInt(1,0);
//                preparedStatement.setString(2,"egurt");
//                preparedStatement.setInt(3,24);
//                preparedStatement.execute();
                Statement statement = connection.createStatement();
//                statement.execute("insert into users (name, age, emeil)  values('asds',22,'dfdsfsgvc');");
//                // int res =  statement.executeUpdate("update users set name='dd' where id=13;");
////              ResultSet res =  statement.executeQuery("SELECT * FROM users");
////                System.out.println(res.absolute(12));
//                statement.addBatch("insert into users (name, age, emeil)  values('asdsss',12,'dfdsfsgvc');");
//                statement.addBatch("insert into users (name, age, emeil)  values('asdsdfs',32,'dfdsfsgvc');");
//                statement.addBatch("insert into users (name, age, emeil)  values('asdfs',22,'dfdsfsgvc');");
//                statement.executeBatch();
                // statement.clearBatch();
                ResultSet res = preparedStatement.executeQuery();
                tovar t;

                while (res.next()){
                   // t = new tovar(res.getInt("id"),res.getString("name"),res.getInt("mane"));

                    //usersData.add(new tovar(res.getInt("id"),res.getString("name"),res.getInt("mane")));
                   // System.out.println(usersData);

                }
            }
            connection.close();
            if(connection.isClosed()){
                System.out.println("ZAKRIL");

            }
        }catch (SQLException e){
            System.err.println("nety draivera");
        }

    }

    public void GO(ActionEvent actionEvent) {
      v1 =vx1.getText();
        v2 =vx2.getText();

if (v1.equals("1")&& v2.equals("1")){
    System.out.println( v1);
    System.out.println( v2);
    try {
        Prepod(actionEvent);
    } catch (IOException e) {
        e.printStackTrace();
    }
    SQLZ();

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
