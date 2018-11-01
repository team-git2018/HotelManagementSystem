package databaseoperations;

import java.sql.*;

public class DatabaseOperations 
{
    public static final String connectionUrl = "jdbc:mysql://localhost:3306/hoteldb";
    public static final String userName = "root";
    public static final String password = "root";
    
    public static Connection establishConnection()throws ClassNotFoundException, SQLException 
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(connectionUrl, userName, password);
        return con;
    }      
}
