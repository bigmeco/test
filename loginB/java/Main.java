import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by bigi on 15.03.2017.
 */
public class Main {

  //  private static final String URL = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";﻿


    public static void main(String[] args){
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false","root","root");
            if(!connection.isClosed()){
                System.out.println("esti");
                Statement statement = connection.createStatement();
                statement.execute("insert into users (name, age, emeil)  values('asds',22,'dfdsfsgvc');");
             // int res =  statement.executeUpdate("update users set name='dd' where id=13;");
//              ResultSet res =  statement.executeQuery("SELECT * FROM users");
//                System.out.println(res.absolute(12));
                statement.addBatch("insert into users (name, age, emeil)  values('asdsss',12,'dfdsfsgvc');");
                statement.addBatch("insert into users (name, age, emeil)  values('asdsdfs',32,'dfdsfsgvc');");
                statement.addBatch("insert into users (name, age, emeil)  values('asdfs',22,'dfdsfsgvc');");
                statement.executeBatch();
                statement.clearBatch();
            }
            connection.close();
            if(connection.isClosed()){
                System.out.println("ZAKRIL");

            }
        }catch (SQLException e){
            System.err.println("nety draivera");
        }

    }
}
