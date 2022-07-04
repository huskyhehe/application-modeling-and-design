/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing;


import digitalmarketing.Business.Business;
import digitalmarketing.ProductManagement.ProductsReport;
import digitalmarketing.Supplier.SuppliersReport;


/**
 *
 * @author HeZhou
 */
public class DigitalMarketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // 1.a: init Business
        Business kroger = new Business("Kroger Inc.");  
        
        DataLoader dataLoader = new DataLoader();
               
        // 1.b+d: Populate Suppliers and Customers  
        dataLoader.populateBusiness(kroger, 30, 30);
        
        // 1.c: Pick any 5 Suppliers and add 20 Products to each
        dataLoader.pickSuppliersToAddProducts(kroger, 5, 20);       
       
        // 1.e: Pick any 5 Customers and add 3 Orders with 5 Items to each
        dataLoader.pickCustomersToAddOrders(kroger, 5, 3, 5); 
        
        // Output of 1
        kroger.printPopulatedData();
        
                
              
        // 2. Generate a report with 10 best performing products by total sales volume
        ProductsReport pr = new ProductsReport(kroger);
        // Output of 2
        pr.printTopRank(10);
        

        
        // 3. Generate a reports with 3 best performing suppliers by sales performance
        SuppliersReport sr = new SuppliersReport(kroger);
        // Output of 3
        sr.printTopRank(3);
        
    }
    
}
