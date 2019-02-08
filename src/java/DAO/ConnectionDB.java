/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ARCADE Software MX
 */
public class ConnectionDB {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    // Driver
    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    
    // URL DB Connection String & TimeZone
    private static final String URLJDBC = "jdbc:mysql://127.0.0.1:3306/products";
    private static final String USETIMEZONE = "?useTimezone=false&serverTimezone=UTC&useSSL=false";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVERNAME);
            return DriverManager.getConnection(URLJDBC + USETIMEZONE, USERNAME, PASSWORD);
        } catch(ClassNotFoundException | SQLException e) {
            e.toString();
            return null;
        }
    }
    
    public boolean closeConnection(Connection c) {
        try {
            c.close();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }
}
