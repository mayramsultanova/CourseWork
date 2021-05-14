package JavaFX;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static void main(String[] args) {
        ConnectDB obj_ConnectDB = new ConnectDB();
        System.out.println(obj_ConnectDB.get_connection());
    }


    public Connection get_connection() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "cwdb";
        String username = "postgres";
        String password = "qwerty88";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"",""+username+"",""+password+"");
//            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}







//        ConnectDB obj_ConnectDB = new ConnectDB();
//        System.out.println(obj_ConnectDB.connect());
//        ConnectDB app = new ConnectDB();
//        app.connect();
//
//    }
//    public Connection connect() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return conn;
//    }

