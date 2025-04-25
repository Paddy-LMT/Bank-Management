package bank.management.system;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Attempt to connect to the database
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankSystem",
                "root",
                "1234"
            );
            
            System.out.println("Successfully connected to MySQL database!");
            
            // Test query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DATABASE()");
            if (resultSet.next()) {
                System.out.println("Connected to database: " + resultSet.getString(1));
            }
            
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            System.out.println("Please add mysql-connector-java-8.0.28.jar to your classpath");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check your MySQL server and credentials");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 