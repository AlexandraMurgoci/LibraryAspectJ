package library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
    private static final String URL = "jdbc:postgresql:librarydb";
    private static final String USER = "libraryapp";
    private static final String PASSWORD = "password";

    public static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public static void initConnection() {
        if(connection == null) {
            try{
                Properties props = new Properties();

                props.setProperty("user", USER);

                props.setProperty("password",PASSWORD);

                props.setProperty("stringtype", "unspecified");
                connection = DriverManager.getConnection(URL,props);
                LOGGER.info("Database connection opened successfully");
            }
            catch (SQLException e) {
                System.out.println("Connection failure.");
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection() {
        if(connection!=null) {
            try {
                connection.close();
                LOGGER.info("Database connection closed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
