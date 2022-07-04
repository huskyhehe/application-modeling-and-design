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
 * @author kal bugrara
 */
public class ProductsReport {
    
    Business business;
    ArrayList<ProductSummary> productsummarylist;

    public ProductsReport() {
        productsummarylist = new ArrayList();
    }
    
    public ProductsReport(Business b) {
        this.business = b;
        productsummarylist = new ArrayList();
        
        for (Product p : b.getMasterProductList()) {
            ProductSummary ps = new ProductSummary(p);
            productsummarylist.add(ps);
        }
    }



    public void addProductSummary(ProductSummary ps) {
        productsummarylist.add(ps);
    }
    

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary currenttopproduct = null;

        for (ProductSummary ps : productsummarylist) {
            if (currenttopproduct == null) {
                currenttopproduct = ps; // initial step 
            } else if (ps.getNumberAboveTarget() > currenttopproduct.getNumberAboveTarget()) {
                currenttopproduct = ps; //we have a new higher total
            }

        }
        return currenttopproduct;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsalwaysabovetarget = new ArrayList(); //temp array list

        for (ProductSummary ps : productsummarylist) {
            if (ps.isProductAlwaysAboveTarget() == true) {
                productsalwaysabovetarget.add(ps);
            }
        }

        return productsalwaysabovetarget;
    }


    
    public void print(){
        System.out.println(" -----------  Product Report ----------- ");
        // Lab Contents
        sortByRank();
        for (ProductSummary ps : productsummarylist){
            ps.print();
        }
    }
 
   
    
    public void sortByRank() {
        Collections.sort(productsummarylist, new ProductSummaryComparator());
    }
    
    
    // New!
    public void printTopRank(int head) {
        System.out.println("------------------------ Product Report ------------------------");
        System.out.println("                     Sorted By: Sales Volume                    ");
        sortByRank();
        for (int i = 0; i < head; i++) {
            System.out.print("#" + (i+1) + " ");
            productsummarylist.get(i).print();
        }
        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Sold Quantity = the total item quantity sold");
        System.out.println("* Sales Volume = Sold Quantity * Actural Price");
        System.out.println("* Sales Valume = Sold Quantity * (Actural Price - Target Price)");
        System.out.println();
    }

}
