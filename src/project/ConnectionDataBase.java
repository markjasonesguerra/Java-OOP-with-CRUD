package project;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDataBase {

    // This method is used to establish a connection with the MySQL database
    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/projectoopdb";
            Connection connection = DriverManager.getConnection(url, "root", "12345");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
