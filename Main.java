package JavaFX;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void openNewScene(String window, Button button, boolean hide) {
        if (hide)
            button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


    public static String choice;
    public static Scanner input = new Scanner(System.in);
    public static String pass;
    public static Scanner inputs = new Scanner(System.in);
    public static String result = "";

    public static void main(String[] args) {
        launch(args);
        main_main_menu();
//        launch(args);

    }
    public static void main_main_menu() {

        System.out.println("Welcome to our amazing program! ");
        System.out.println("Please, enter your position in the company: ");
        System.out.println("1 - marketer ");
        System.out.println("2 - director ");
        System.out.println("3 - manager ");
        System.out.println("4 - worker ");
        authorization();

    }
    public static String authorization() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs1 = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_connection();
        String host = "localhost";
        String port = "5432";
        String db_name = "cwdb";
        String username = "postgres";
        String password1 = "qwerty88";
        System.out.print("Type here your account type: ");
        String account_type = inputs.next();

        String user_role = account_type;
        System.out.print("Enter your password: ");
        String password = inputs.next();

//        System.out.println(account_type);
        try {
//                System.out.println(password);
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password1 + "");
                statement = connection.createStatement();
                String Q = "SELECT * FROM USERS WHERE user_role ='" + user_role + "'AND password='" + password + "'";
                ResultSet rs = statement.executeQuery(Q);
                //  ResultSet rs = statement.executeQuery("SELECT user_role, password FROM users WHERE user_role = user_role, password = password;");
            if (user_role.equals("director") && password.equals("222")){
                result = "director";
                director_account();
                main_menu();
            }
                if (rs.next()) {
                    result = user_role;
                    main_menu();
                }
                else {
                    System.out.println(rs.next() + " "+ rs);
                    System.out.println("Wrong password");
                }
        } catch (Exception e) {
            System.out.println("wrong password or login " + e);
        }
        return result;
    }
    public static void main_menu() {
        String account_type = result;

        switch (account_type) {

            case "marketer":
                marketing_account();
                break;
            case "hr":
                hr_account();
                break;
            case "director":
                director_account();
                break;
            case "manager":
                manager_account();
                   break;
            case "worker":
                worker_account();
                break;
            default:
                System.out.println("This is not a valid Menu Option! Please Select Another");
                break;
        }
    }
    public static void marketing_account() {
        System.out.println("Welcome lovely Head of Marketing");
        int num;
        do {
            System.out.println(" ");
            System.out.println("============= Menu of marketer ===================");
            System.out.println("Please choose the menu number for the programme operation, if you have finished, choose 6");
            System.out.println("1 - Show list of all coverage areas\n" +
                    "2 - Show list of categories for marketing\n" +
                    "3 - Show allocated budget for a particular category of marketing locations\n" +
                    "4 - Show total budget for marketing\n" +
                    "5 - Spending a budget on promotion\n" +
                    "6 - Log out");
            int numn = 0;
            num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("1 - Show coverage area for Bishkek\n" +
                            "2 - Show coverage area for Talas\n" +
                            "3 - Show coverage area for Jallabad\n" +
                            "4 - Show coverage area for Osh\n" +
                            "5 - Coverage area for Naryn\n" +
                            "6 - Coverage area for Issyk Kul\n" +
                            "7 - Show coverage area for Batken");
                    int number;
                    number = inputs.nextInt();
                    switch (number) {
                        case 1:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 2:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '2'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 3:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '3'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 4:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '4'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }

                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 5:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '5'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 6:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '6'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 7:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '7'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                    }
                    break;
                case 2:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM social_media ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            String name_of_social_media = rs1.getString("name_of_social_media");
                            int followers = rs1.getInt("followers");
                            System.out.println("1)In " + name_of_social_media + " we have " + followers + " followers");
                        }
                    } catch (Exception e) {
                        System.out.println("Error ! Something wrong here");
                    }
                    break;
                case 3:
                    System.out.println("1 - Show the budget for Bishkek\n" +
                            "2 - Show the budget for Talas\n" +
                            "3 - Show the budget for Jallalabad\n" +
                            "4 - Show the budget for Osh\n" +
                            "5 - Show the budget for Naryn\n" +
                            "6 - Show the budget for Issuk Kul\n" +
                            "7 - Show the budget for Batken\n");
                    int numm;
                    Scanner in2 = new Scanner(System.in);
                    numm = in2.nextInt();
                    switch (numm) {
                        case 1:
                            System.out.println("The budget for Bishkek is 25 000$ ");
                            break;
                        case 2:
                            System.out.println("The budget for Talas is 15 000$ ");
                            break;
                        case 3:

                            System.out.println("The budget for Jalal Abad is 23 000$");
                            break;
                        case 4:
                            System.out.println("The budget for Osh is 10 000$ ");
                            break;
                        case 5:
                            System.out.println("The budget for Naryn is 21 000$");
                            break;
                        case 6:
                            System.out.println("The budget for Issyk kul is 12 670$  ");
                            break;
                        case 7:
                            System.out.println("The budget for Batken is 1 000$");
                            break;
                    }
                    break;
                case 4:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM total_budget_marketing ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int total_budget_marketing2 = rs1.getInt("amount_total");

                            System.out.println("The total budget for promotion marketing " + total_budget_marketing2 + " $");
                        }
                    } catch (Exception e) {
                        System.out.println("Error ! Something wrong here");
                    }
                    break;
                case 5:
                    int numb;
                    Scanner inn = new Scanner(System.in);
                    System.out.println("For what you want to spend the money:\n" +
                            "1- Instagram\n" +
                            "2 - Facebook\n" +
                            "3 - YouTube\n" +
                            "4 - Other\n");
                    numb = inn.nextInt();
                    int expenditure;
                    switch (numb) {
                        case 1:
                            try {
                                System.out.println("Instagram");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = inn.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing);

                                    if (amount_total_budget_for_marketing > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing - expenditure;
                                        System.out.println("Yes, there is enough funds for it!");
                                        amount_total_budget_for_marketing = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }

                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Facebook");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = inn.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing);

                                    if (amount_total_budget_for_marketing > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing - expenditure;
                                        System.out.println("Yes, we can allow this amount to promotion ");
                                        amount_total_budget_for_marketing = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);
                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);
                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Youtube");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = inn.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing);
                                    if (amount_total_budget_for_marketing > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing - expenditure;
                                        System.out.println("Yes, there is enough funds for it ");
                                        amount_total_budget_for_marketing = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);
                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);
                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than  total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 4:
                            try {
                                System.out.println("Other ");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = inn.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing);
                                    if (amount_total_budget_for_marketing > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing - expenditure;
                                        System.out.println("Yes, there is enough funds for it ");
                                        amount_total_budget_for_marketing = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        default:
                            System.out.println("You entered incorrect data");
                    }
                    break;
                case 6:
                    System.out.println("Bye! You have returned to main menu!  ");
                    main_main_menu();
                    break;
//                    num = 6;
            }
        } while (num != 6);
    }


    public static void hr_account() {
        System.out.println("Welcome Head of the hr! ");
    }

    public static void director_account() {
        System.out.println("Welcome our lovely Director! ");
        System.out.println("Please choose the menu number for the programme operation, if you have finished, choose 7");
        System.out.println("1- Show list of all coverage areas\n" +
                "2 - Show list of budget categories\n" +
                "3 - Show the allocated budget for a specific category of places for marketing\n" +
                "4 - Show current marketing funds\n" +
                "5 - Show total budget required for salary\n" +
                "6 - Increase the salary of an employee: or Lower the employee's salary:\n" +
                "7 - Exit");
        int num = 0;
        do {
            System.out.println("  ");
            System.out.println("Need you more functionality? If no, choose 7");
            System.out.print("Please, enter the number : ");

            Scanner in3 = new Scanner(System.in);
//            int num;
            num = in3.nextInt();


            switch (num) {
                case 1:
                    System.out.println("1 - Show coverage area for Bishkek\n" +
                            "2 - Show coverage area for Talas\n" +
                            "3 - Show coverage area for Jallabad\n" +
                            "4 - Show coverage area for Osh\n" +
                            "5 - Coverage area for Naryn\n" +
                            "6 - Coverage area for Issyk Kul\n" +
                            "7 - Show coverage area for Batken");

                    int number;
                    Scanner in = new Scanner(System.in);
                    number = in.nextInt();
                    switch (number) {
                        case 1:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 2:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '2'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }

                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;

                        case 3:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '3'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;

                        case 4:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '4'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 5:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '5'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 6:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '6'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 7:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '7'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;


                    }
                    break;
                case 2:
                    System.out.println("Show list of budget categories:\n" +
                            "1 - amount_of_budget_marketing\n" +
                            "2 - amount_of_budget_salary");
                    int numbr;
                    Scanner inpu1 = new Scanner(System.in);
                    numbr = inpu1.nextInt();
                    switch (numbr) {
                        case 1:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_marketing);

                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;

                        case 2:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_for_salary WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_salary = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_salary);
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                    }
                case 3:
                    System.out.println("For what you want to spend the money:\n" +
                            "1- Instagram\n" +
                            "2 - Facebook\n" +
                            "3 - YouTube\n" +
                            "4 - Other\n");
                    int nnumb;
                    Scanner innv = new Scanner(System.in);
                    nnumb = innv.nextInt();
                    int expenditure;

                    switch (nnumb) {
                        case 1:
                            try {
                                System.out.println("Instagram");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = innv.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing);

                                    if (amount_total_budget_for_marketing > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing - expenditure;
                                        System.out.println("Yes we can allow this amount for the promotion");
                                        amount_total_budget_for_marketing = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Facebook");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = innv.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing1 = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing1);

                                    if (amount_total_budget_for_marketing1 > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing1 - expenditure;
                                        System.out.println("Yes we can allow this amount for the promotion");
                                        amount_total_budget_for_marketing1 = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Youtube");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = innv.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing2 = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing2);

                                    if (amount_total_budget_for_marketing2 > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing2 - expenditure;
                                        System.out.println("Yes we can allow this amount for the promotion");
                                        amount_total_budget_for_marketing2 = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                        case 4:
                            try {
                                System.out.println("Other");
                                System.out.println("Enter in the amount of expenditure you want to spend from the total budget");
                                expenditure = innv.nextInt();

                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    int amount_total_budget_for_marketing3 = rs1.getInt("amount_total");
                                    System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing3);

                                    if (amount_total_budget_for_marketing3 > expenditure) {
                                        int res;
                                        res = amount_total_budget_for_marketing3 - expenditure;
                                        System.out.println("Yes we can allow this amount for the promotion");
                                        amount_total_budget_for_marketing3 = res;
                                        try {
                                            Connection connection1 = null;
                                            Statement statement1 = null;
                                            ConnectDB obj_ConnectDB1 = new ConnectDB();
                                            connection1 = obj_ConnectDB1.get_connection();
                                            String v = "UPDATE total_budget_marketing SET amount_total = ? ";
                                            PreparedStatement ps = connection.prepareStatement(v);
                                            ps.setInt(1,res);

                                            ps.executeUpdate();
                                            System.out.println("Now the total budget is " + res);

                                        } catch (Exception e) {
                                            System.out.println("Error! Something wrong here" + e);
                                        }
                                    } else {
                                        System.out.println("It is more than total budget");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error! Something wrong here");
                            }
                            break;
                    }
                    break;
                case 4:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM total_budget_marketing WHERE id = '1'";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {

                            int amount_total_budget_for_marketing4 = rs1.getInt("amount_total");
                            System.out.println("The total budget for marketing is " + amount_total_budget_for_marketing4);
                        }
                    } catch (Exception e) {
                        System.out.println("Error! Something wrong here" + e);
                    }
                    break;
                case 5:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM total_budget_for_salary WHERE id = '1'";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {

                            int amount_total_budget_for_salary = rs1.getInt("amount_total");
                            System.out.println("The total budget for salary is " + amount_total_budget_for_salary);
                        }

                    } catch (Exception e) {
                        System.out.println("Error! Something wrong here" + e);
                    }
                    break;
                case 6:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM workers  ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {

                            int id_wor = rs1.getInt("id");
                            String name_wor = rs1.getString("name");
                            String surname_wor = rs1.getString("surname");
                            int salary_wor = rs1.getInt("salary");
                            System.out.println("================================================");
                            System.out.println("The total budget for salary is " + id_wor);
                            System.out.println("The total budget for salary is " + name_wor);
                            System.out.println("The total budget for salary is " + surname_wor);
                            System.out.println("The total budget for salary is " + salary_wor);
                            System.out.println("================================================");
                        }

                    } catch (Exception e) {
                        System.out.println("Error! Something wrong here" + e);
                    }

                    System.out.println("Enter the name of worker: ");
                    String worker = input.next();
                    int worker_salary = 0;
                    String worker_name = "";
                    String worker_surname = "";

                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM workers WHERE name = '"+worker+"'";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);

                        while (rs1.next()) {
                            worker_name = rs1.getString("name");
                            worker_surname = rs1.getString("surname");
                            worker_salary = rs1.getInt("salary");
                            System.out.println("Worker that you choosed: " + worker_name + " " + worker_surname + " " + worker_salary);
                        }

                    } catch (Exception e) {
                        System.out.println("Error! Something wrong here" + e);
                    }
                    System.out.println("Choose your option 1)increase or 2)decrease");
                    int option = input.nextInt();
                    if (option == 1 ){
                        System.out.print("Number to increase salary = ");
                        int increase_salary = input.nextInt();
                        int increase_summ = increase_salary + worker_salary;
                        try {
                            Connection connection = null;
                            Statement statement = null;
                            ConnectDB obj_ConnectDB = new ConnectDB();
                            connection = obj_ConnectDB.get_connection();
                            String q = "UPDATE workers SET salary = ? WHERE name = ? AND surname = ? ";
                            PreparedStatement ps = connection.prepareStatement(q);
                            ps.setInt(1,increase_summ);
                            ps.setString(2, worker_name);
                            ps.setString(3, worker_surname);

                            ps.executeUpdate();
                            System.out.println("Total = "+ increase_summ);

                        } catch (Exception e) {
                            System.out.println("Error! Something wrong here" + e);
                        }
                    }
                    else if(option == 2){
                        System.out.println("Number to decrease salary = ");
                        int decrease_salary = input.nextInt();
                        int decrease_summ = worker_salary - decrease_salary;
                        try {
                            Connection connection = null;
                            Statement statement = null;
                            ConnectDB obj_ConnectDB = new ConnectDB();
                            connection = obj_ConnectDB.get_connection();
                            String q = "UPDATE workers SET salary = ? WHERE name = ? AND surname = ? ";
                            PreparedStatement ps = connection.prepareStatement(q);
                            ps.setInt(1,decrease_summ);
                            ps.setString(2, worker_name);
                            ps.setString(3, worker_surname);

                            ps.executeUpdate();
                            System.out.println("Total = "+ decrease_summ);

                        } catch (Exception e) {
                            System.out.println("Error! Something wrong here" + e);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Bye! You have returned to main menu!  ");
                    main_main_menu();

                    break;
            }
        } while (num != 7);

    }
    public static void manager_account() {
        System.out.println("Yeeaahhh Welcome Head of Management ! ");
        int numt = 0;
        do {
            System.out.println("     ");
            System.out.println("============= Menu of manger ===================");
            System.out.println("1 - Show the list of employees\n" +
                    "2 - Show to-do list for manager \n" +
                    "3 - Show to-do list for worker\n" +
                    "4 - Show a list of all coverage areas\n" +
                    "5 - Exit ");
            Scanner min = new Scanner(System.in);
            numt = min.nextInt();
            switch (numt) {
                case 1:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM workers ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_workers = rs1.getInt("id");
                            String name_workers = rs1.getString("name");
                            String surname_workers = rs1.getString("surname");
                            System.out.println("================================================");
                            System.out.println("The worker's id is : " + id_workers);
                            System.out.println("The worker's name is: " + name_workers);
                            System.out.println("The worker's surname is: " + surname_workers);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 2:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM list_of_tasks_for_manager ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_task = rs1.getInt("id");
                            String name_of_task = rs1.getString("name_of_task");
                            String description_task = rs1.getString("description");
                            int manager_id = rs1.getInt("manager_id");
//                                    String manager_id = rs1.getString("workers_id");
                            System.out.println("================================================");
                            System.out.println("The manager's id_task is:  " + id_task);
                            System.out.println("The name of tasks of manager:  " + name_of_task);
                            System.out.println("The description of tasks:  " + description_task);
                            System.out.println("The manager_id of tasks:  " + manager_id);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 3:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM list_of_tasks_for_workers ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_task = rs1.getInt("id");
                            String name_of_task = rs1.getString("name_of_task");
                            String description_task = rs1.getString("description");
                            int workers_id = rs1.getInt("workers_id");
//                                    String workers_id = rs1.getString("workers_id");
                            System.out.println("================================================");
                            System.out.println("The worker's id_task is: " + id_task);
                            System.out.println("The  name of tasks of workers: " + name_of_task);
                            System.out.println("The description of tasks:  " + description_task);
                            System.out.println("The workers_id of tasks:  " + workers_id);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 4:
                    System.out.println("1 - Show coverage area for Bishkek\n" +
                            "2 - Show coverage area for Talas\n" +
                            "3 - Show coverage area for Jallabad\n" +
                            "4 - Show coverage area for Osh\n" +
                            "5 - Coverage area for Naryn\n" +
                            "6 - Coverage area for Issyk Kul\n" +
                            "7 - Show coverage area for Batken");
                    int number;
                    Scanner in = new Scanner(System.in);
                    number = in.nextInt();
                    switch (number) {
                        case 1:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '1'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 2:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '2'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;

                        case 3:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '3'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;

                        case 4:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '4'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 5:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '5'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 6:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '6'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for " + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                        case 7:
                            try {
                                Connection connection = null;
                                Statement statement = null;
                                ConnectDB obj_ConnectDB = new ConnectDB();
                                connection = obj_ConnectDB.get_connection();
                                String q = "SELECT * FROM REGIONS WHERE id = '7'";
                                statement = connection.createStatement();
                                ResultSet rs1 = statement.executeQuery(q);
                                while (rs1.next()) {
                                    String name_of_regions1 = rs1.getString("name_of_regions");
                                    int percent_of_covered_area1 = rs1.getInt("percent_of_covered_area");
                                    int amount_of_users1 = rs1.getInt("amount_of_users");
                                    System.out.println("The percentage of coverage area for" + name_of_regions1 + " is " + percent_of_covered_area1 + "\nThe amount of users(clients) in this area are " + amount_of_users1);
                                }
                            } catch (Exception e) {
                                System.out.println("Error ! Something wrong here");
                            }
                            break;
                    }
                    break;
                            case 5:
                                System.out.println("Bye! You have returned to main menu!  ");
                                main_main_menu();
                                break;
//                default:
//                    System.out.println("incorrect data");
                        } } while (numt != 5);
            }


    public static void worker_account() {
        System.out.println("Yeeaaahhh Welcome Worker of our company ! ");
        int numt = 0;
        do {
            System.out.println("            ");
            System.out.println("============= Menu of worker ===================");
            System.out.println("1 Show the list of tasks assigned \n" +
                    "2 - Show a list of completed tasks\n" +
                    "3 - Show to-do list I'm working on\n" +
                    "4 - Show salary\n" +
                    "5 - Exit ");
            Scanner min = new Scanner(System.in);

            numt = min.nextInt();
            switch (numt) {
                case 1:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM list_of_tasks_for_workers WHERE workers_id = 1  ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_task = rs1.getInt("id");
                            String name_of_task = rs1.getString("name_of_task");
                            String description_task = rs1.getString("description");
                            int workers_id = rs1.getInt("workers_id");
//                                    String workers_id = rs1.getString("workers_id");
                            System.out.println("The worker's id_task is: " + id_task);
                            System.out.println("The  name of tasks of workers: " + name_of_task);
                            System.out.println("The description of tasks:  " + description_task);
                            System.out.println("The workers_id of tasks:  " + workers_id);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 2:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM list_of_tasks_for_workers WHERE status = true and id ='1' ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_task = rs1.getInt("id");
                            String name_of_task = rs1.getString("name_of_task");
                            String description_task = rs1.getString("description");
                            int workers_id = rs1.getInt("workers_id");
                            boolean status = rs1.getBoolean("status");

                            System.out.println("The worker's id_task is: " + id_task);
                            System.out.println("The  name of tasks of workers: " + name_of_task);
                            System.out.println("The description of tasks:  " + description_task);
                            System.out.println("The workers_id of tasks:  " + workers_id);
                            System.out.println("The status of tasks:  " + status);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 3:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM list_of_tasks_for_workers WHERE status = false and workers_id ='1' ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int id_task = rs1.getInt("id");
                            String name_of_task = rs1.getString("name_of_task");
                            String description_task = rs1.getString("description");
                            int workers_id = rs1.getInt("workers_id");
                            boolean status = rs1.getBoolean("status");


                            System.out.println("================================================");
                            System.out.println("The worker's id_task is: " + id_task);
                            System.out.println("The  name of tasks of workers: " + name_of_task);
                            System.out.println("The description of tasks:  " + description_task);
                            System.out.println("The workers_id of tasks:  " + workers_id);
                            System.out.println("The status of tasks:  " + status);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 4:
                    try {
                        Connection connection = null;
                        Statement statement = null;
                        ConnectDB obj_ConnectDB = new ConnectDB();
                        connection = obj_ConnectDB.get_connection();
                        String q = "SELECT * FROM workers WHERE id = '1' ";
                        statement = connection.createStatement();
                        ResultSet rs1 = statement.executeQuery(q);
                        while (rs1.next()) {
                            int salary = rs1.getInt("salary");
                            System.out.println("================================================");
                            System.out.println("Your salary is " + salary);
                            System.out.println("================================================");
                        }
                    } catch (Exception e) {
                        System.out.println("Something wrong!");
                    }
                    break;
                case 5:
                    System.out.println("Bye! You have returned to main menu!  ");
                    main_main_menu();
                    break;
//                default:
//                    System.out.println("incorrect data");
            }
        } while (numt != 5);
    }

}