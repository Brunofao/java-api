/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ProductDAO;
import Models.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ARCADE Software MX
 */
public class ProductService {
    
    private final ProductDAO pdao;

    public ProductService() {
        pdao = new ProductDAO();
    }
    
    public void create(Product p) throws SQLException {
        pdao.create(p);
    }
    
    public void create(Product[] p) throws SQLException {
        pdao.create(p);
    }
    
    public List<Product> read() throws SQLException {
        return pdao.read();
    }
}
