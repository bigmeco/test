package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller2 {
    private ObservableList<tovar> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<tovar> tableUsers;

    @FXML
    private TableColumn<tovar, Integer> idT;
    @FXML
    private TableColumn<tovar, String> nameT;
    @FXML
    private TableColumn<tovar, Integer> maneT;

    private static final String URLk = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false" ;
    private static final String login = "root" ;
    private static final String pass = "root" ;
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)" ;
    private static final String VIVODtovar = "SELECT * FROM tovar" ;

    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("id"));
        nameT.setCellValueFactory(new PropertyValueFactory<tovar, String>("name"));
        maneT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("mane"));


        // заполняем таблицу данными
        tableUsers.setItems(usersData);
    }
    private void initData() {
        usersData.add(new tovar(1,"fg",250));

        //usersData.add(new tovar(res.getInt("id"),res.getString("name"),res.getInt("mane")));
    }

}
