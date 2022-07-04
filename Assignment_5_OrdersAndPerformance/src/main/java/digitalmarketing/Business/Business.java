/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Business;

import java.util.ArrayList;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.OrderManagement.MasterOrderList;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.MasterProductDirectory;
import digitalmarketing.ProductManagement.ProductSummary;
import digitalmarketing.ProductManagement.ProductsReport;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    MasterOrderList masterorderlist;
    SupplierDirectory suppliers;
    CustomerDirectory customers;
    // New!
    MasterProductDirectory masterProductDirectory;
    

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList(this);
        suppliers = new SupplierDirectory(this);
        customers = new CustomerDirectory(this);
        masterProductDirectory = new MasterProductDirectory(this);
    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }
    
    private void printTitle(){
        System.out.println("Business : " + name);
    }
    
    
    public void printSupplierDetails(){
        printTitle();
        suppliers.printSupplierList();
    }
    
    
    public MasterOrderList getMasterorderlist() {
        return masterorderlist;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customers;
    }
    
    // New!
    public ArrayList<Product> getMasterProductList() {
        return masterProductDirectory.getMasterProducts();
    }
    
    // New!
    public MasterProductDirectory getMasterProductDirectory() {
        return masterProductDirectory;
    }
        
    
    public void printAllOrders(){
        System.out.println("------------------------ Master Order List ------------------------");
        masterorderlist.printOrders();
        System.out.println();
    }
    
    // New!
    public void printBusinessTitle() {
        System.out.println("------------------------- Business Title --------------------------");
        System.out.println(name);
        System.out.println();
    }
    
    
    public void printPopulatedData() {
        this.printBusinessTitle();
        this.getSupplierDirectory().printSupplierList();
        this.getCustomerDirectory().printCustomerNames();
        this.printAllOrders();       
    }
}
