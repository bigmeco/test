package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller2 {
    private ObservableList<tovar> usersData = FXCollections.observableArrayList();
    private ObservableList<ISTORIAZ> usersData2 = FXCollections.observableArrayList();

    @FXML
    private TableView<tovar> tableUsers;
    @FXML
    private TableView<ISTORIAZ> TB2;

    @FXML
    private TableColumn<tovar, Integer> idT;
    @FXML
    private TableColumn<tovar, String> nameT;
    @FXML
    private TableColumn<tovar, Integer> maneT;
    @FXML
    private TableColumn<tovar, Integer> kolT;

    @FXML
    private TableColumn<ISTORIAZ, Integer> idzakazi;
    @FXML
    private TableColumn<ISTORIAZ, Integer> idprodovets;
    @FXML
    private TableColumn<ISTORIAZ, Integer> idtovar;
    @FXML
    private TableColumn<ISTORIAZ, String> data;

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
        kolT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("Kolijestvo"));
        initData2();
        idzakazi.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idzakazi"));
        idprodovets.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idprodovets"));
        idtovar.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idtovar"));
        data.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, String>("data"));

        // заполняем таблицу данными
        tableUsers.setItems(usersData);
        TB2.setItems(usersData2);

    }
    private void initData() {
        usersData.add(new tovar(0006,"тыква",700,21));
        usersData.add(new tovar(0354,"сгущёнка",76,544));
        usersData.add(new tovar(8318,"арбуз",150,13));
        usersData.add(new tovar(6387,"ананас",240,35));
        usersData.add(new tovar(4863,"сок",120,84));
        usersData.add(new tovar(4866,"яблоко",56,35));
        usersData.add(new tovar(0120,"творог",89,12));
        usersData.add(new tovar(8387,"мясо",320,48));



        //usersData.add(new tovar(res.getInt("id"),res.getString("name"),res.getInt("mane")));
    }
    private void initData2() {


        usersData2.add(new ISTORIAZ(1,6,0120,"21.12.2016"));
        usersData2.add(new ISTORIAZ(2,8,6387,"1.1.2017"));
        usersData2.add(new ISTORIAZ(3,12,8318,"20.03.2012"));

        
    }

}
