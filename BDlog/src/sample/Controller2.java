package sample;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

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

    private static final String URLk = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String pass = "root";
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)";
    private static final String VIVODtovar = "SELECT * FROM tovar";

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
        SQLZ();


    }


    private void initData2() {


        usersData2.add(new ISTORIAZ(1, 6, 0120, "21.12.2016"));
        usersData2.add(new ISTORIAZ(2, 8, 6387, "1.1.2017"));
        usersData2.add(new ISTORIAZ(3, 12, 8318, "20.03.2012"));


    }

    public void SQLZ() {
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URLk, login, pass);
            if (!connection.isClosed()) {
                System.out.println("esti");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(VIVODtovar);
//                statement.execute("insert into users (name, age, emeil)  values('asds',22,'dfdsfsgvc');");
//                // int res =  statement.executeUpdate("update users set name='dd' where id=13;");
////              ResultSet res =  statement.executeQuery("SELECT * FROM users");
////                System.out.println(res.absolute(12));
//                statement.addBatch("insert into users (name, age, emeil)  values('asdsss',12,'dfdsfsgvc');");
//                statement.addBatch("insert into users (name, age, emeil)  values('asdsdfs',32,'dfdsfsgvc');");
//                statement.addBatch("insert into users (name, age, emeil)  values('asdfs',22,'dfdsfsgvc');");
//                statement.executeBatch();
                // statement.clearBatch();
                // System.out.println(res.getInt("id"));

                while (resultSet.next()) {

                    tovar t = new tovar();
                    t.setId(resultSet.getInt(1));
                    t.setName(resultSet.getString(2));
                    t.setMane(resultSet.getInt(3));
                    t.setKolijestvo(resultSet.getInt(4));
                    usersData.add(t);
                }
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("ZAKRIL");

            }
        } catch (SQLException e) {
            System.err.println("nety draivera");
        }

    }
}
