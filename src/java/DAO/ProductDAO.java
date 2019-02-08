/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ARCADE Software MX
 */
public class ProductDAO {
    
    // Product attributes info
        // private String name;
        // private int price;
        // private String desc;
    //
    
    public void create(Product p) throws SQLException {
        
        // Generate connection
        Connection con = ConnectionDB.getConnection();
        
        // SQL Query to Database
        String sql = "INSERT INTO `Product` (`name`, `price`, `desc` ) VALUES (?, ?, ?)";     
        // PreparedStatement to inject the Query
        PreparedStatement ps = con.prepareStatement(sql);
        
        try {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getPrice());
            ps.setString(3, p.getDesc());
            ps.execute();
        } catch(SQLException e) {
            System.out.println("ProductDAO create error");
            System.out.println(e.toString());
        } finally {
            // Close the DB
            con.close();
        }
    }
    
    public void create(Product[] p) throws SQLException {
        
        // Generate connection
        Connection con = ConnectionDB.getConnection();
        
        // SQL Query to Database
        String sql = "INSERT INTO `Product` (`name`, `price`, `desc` ) VALUES (?, ?, ?)";     
        // PreparedStatement to inject the Query
        PreparedStatement ps = con.prepareStatement(sql);
        
        try {
            for (Product p1 : p) {
                ps.setString(1, p1.getName());
                ps.setInt(2, p1.getPrice());
                ps.setString(3, p1.getDesc());
                ps.execute();  
            }
        } catch(SQLException e) {
            System.out.println("ProductDAO create error");
            System.out.println(e.toString());
        } finally {
            // Close the DB
            con.close();
        }
    }
    
    public List<Product> read() throws SQLException {
        
        // Generate connection
        Connection con = ConnectionDB.getConnection();
        
        // SQL Query to Database
        String sql = "SELECT * FROM `Product`";
        
        // PreparedStatement & ResultSet to inject the Query
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        // List of Product(s)
        List<Product> lop = new ArrayList<>();
        
        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String desc = rs.getString("desc");
                Product p = new Product(id, name, price, desc);
                lop.add(p);
            }
        } catch(SQLException e) {
            System.out.println("ProductDAO read error");
        } finally {
            // Close the DB
            con.close();
        }
    // Return the final list w/ product(s)
    return lop;
    }
}
