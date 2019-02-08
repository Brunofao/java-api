/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ARCADE Software MX
 */
public class Product {
    
    private int id;
    private String name;
    private int price;
    private String desc;

    public Product() {
    }
    
    public Product(int id, String name, int price, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    
    public Product(String name, int price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + '}';
    }
}
