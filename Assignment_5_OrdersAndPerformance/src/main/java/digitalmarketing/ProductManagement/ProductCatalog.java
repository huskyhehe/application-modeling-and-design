/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import java.util.ArrayList;
import digitalmarketing.Supplier.Supplier;
import java.util.Collections;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    Supplier supplier;
    String type;
    ArrayList<Product> products;
    

    public ProductCatalog(String t, Supplier s) {
        type = t;
        products = new ArrayList();
        supplier = s;
    }

    public ProductCatalog() {
        type = "noname";
        products = new ArrayList();
    }
    
    // New!
    public ArrayList<Product> getProducts() {
        return products;
    }
    

    public Product newProduct(int fp, int cp, int tp, String n) {
        Product p = new Product(fp, cp, tp, n);
        products.add(p);
        return p;
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();

        for (Product p : products) {

            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }

    public void printDetails(){
        
        Collections.sort(products, new ProductComparator(0));
        
        
        System.out.println("Product Catalog for: " + type);
        for (Product p : products){
            System.out.print("* ");
            p.printDetails();
        }
    }
    
}
