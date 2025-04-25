package bank.management.system;

import java.sql.*;

public class Connn {
    Connection connection;
    Statement statement;
    public Connn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","1234");
            statement = connection.createStatement();
            
            // Create bank table if it doesn't exist
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS bank (" +
                "pin VARCHAR(10), " +
                "date DATETIME, " +
                "type VARCHAR(20), " +
                "amount VARCHAR(20)" +
                ")");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}