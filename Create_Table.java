package JavaFX;

import java.sql.Connection;
import java.sql.Statement;

public class Create_Table {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_connection();
        try {
            String query = "create table employee(id SERIAL primary key, name varchar(200), address varchar(200))";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("finished");
        } catch (Exception e)
        {
        e.printStackTrace();
        }

    }

}
