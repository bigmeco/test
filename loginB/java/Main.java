import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by bigi on 15.03.2017.
 */
public class Main {

    private static final String URLk = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false" ;
    private static final String login = "root" ;
    private static final String pass = "root" ;
    private static final String DOBAVLENIE = "INSERT INTO tovar VALUES(?,?,?)" ;



    public static void main(String[] args){
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URLk,login,pass);
            if(!connection.isClosed()){
                System.out.println("esti");
                preparedStatement = connection.prepareStatement(DOBAVLENIE);
                preparedStatement.setInt(1,0);
                preparedStatement.setString(2,"egurt");
                preparedStatement.setInt(3,24);
            preparedStatement.execute();
                Statement statement = connection.createStatement();
                statement.execute("insert into users (name, age, emeil)  values('asds',22,'dfdsfsgvc');");
             // int res =  statement.executeUpdate("update users set name='dd' where id=13;");
//              ResultSet res =  statement.executeQuery("SELECT * FROM users");
//                System.out.println(res.absolute(12));
                statement.addBatch("insert into users (name, age, emeil)  values('asdsss',12,'dfdsfsgvc');");
                statement.addBatch("insert into users (name, age, emeil)  values('asdsdfs',32,'dfdsfsgvc');");
                statement.addBatch("insert into users (name, age, emeil)  values('asdfs',22,'dfdsfsgvc');");
                statement.executeBatch();
               // statement.clearBatch();
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
