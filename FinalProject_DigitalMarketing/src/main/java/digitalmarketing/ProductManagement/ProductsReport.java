/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HeZhou
 */

public class ProductsReport {
    
    Business business;
    ArrayList<ProductSummary> productSummaries;

    
    public ProductsReport() {
        productSummaries = new ArrayList<>();
    }
    
    
    public ProductsReport(Business b) {
        this.business = b;
        productSummaries = new ArrayList<>();
        
        for (Product p : b.getProductDirectory().getProducts()) {
            ProductSummary ps = new ProductSummary(p);
            productSummaries.add(ps);
        }
    }


    public void addProductSummary(ProductSummary ps) {
        productSummaries.add(ps);
    }
    
    
    public void print(){
        System.out.println(" -----------  Product Report ----------- ");
        // Lab Contents
        sortByRank();
        for (ProductSummary ps : productSummaries){
            ps.print();
        }
    }
 
    
    public void sortByRank() {
        Collections.sort(productSummaries, new ProductSummaryComparator());
    }
    
    
    // New!
    public void printTopRank(int head) {
        System.out.println("------------------------ Product Report ------------------------");
        System.out.println("                    Sorted By: Sales Revenue                    ");
        sortByRank();
        for (int i = 0; i < head; i++) {
            System.out.print("#" + (i+1) + " ");
            productSummaries.get(i).print();
        }
        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Quantity Sold = the total item quantity sold");
        System.out.println("* Sales Revenue = Sold Quantity * Actual Price");
        System.out.println("* Sales Performance = Sold Quantity * (Actual Price - Target Price)");
        System.out.println();
    }

}
