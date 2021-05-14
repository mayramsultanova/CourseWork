package JavaFX;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read_Value {
    public static void main (String[] args) {
        Connection connection = null;
        Statement statement = null;
//        ResultSet rs = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_connection();

        try {
            String query = "SELECT * FROM users";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("user_role"));
                System.out.println(rs.getString("password"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
