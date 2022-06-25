/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class ProductDirectory {    
    Business business;
    ArrayList<Product> products;

    public ProductDirectory(Business b) {
        this.business = b;
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public Product newProduct(String name, int targetPrice) {
        Product newProduct = new Product(name, targetPrice);
        products.add(newProduct);
        return newProduct;
    }
        

    
    // Output
    public void printDetails() {
        System.out.println("===== Product Directory =======");
        for (Product p : products){
            System.out.print("* ");
            p.printDetails();
        }
    }
}
