package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bigi on 30.03.2017.
 */

public class DBWor {
    private static final String URLk = "jdbc:mysql://localhost:3306/magazin?autoReconnect=true&useSSL=false" ;
    private static final String login = "root" ;
    private static final String pass = "root" ;
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)" ;
    private static final String VIVODtovar = "SELECT * FROM tovar" ;
    private Connection connection;

    public DBWor(){
        try {
            connection = DriverManager.getConnection(URLk,login,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
