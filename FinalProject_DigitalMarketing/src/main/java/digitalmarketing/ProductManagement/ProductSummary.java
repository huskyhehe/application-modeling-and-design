/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;



/**
 *
 * @author kal bugrara
 */
//this class will extract summary data from the product
public class ProductSummary {
        
    Product subjectProduct;
    int quantitySold;
    int salesRevenue;
    int salesPerformance; //total profit above target --could be negative too
    int rank; // will be done later
    

    public ProductSummary(Product p) {
        subjectProduct = p; //keeps track of the product itself not as well;   
        quantitySold = p.geProductQuantitySold();
        salesRevenue = p.getProductSalesRevenue();
        salesPerformance = p.getProductSalesPerformance();
    }
    
    // New!
    public int getSalesRevenue() {
        return salesRevenue;
    }
    
    // Lab Contents
    public int getRank() {
        return rank;
    }    
    
    public void print(){
        
        System.out.println(subjectProduct.getName());
        System.out.println(" | Quantity Sold: " + quantitySold + " | Sales Revenue: " +  salesRevenue + " | Sales Performance:" + salesPerformance);
        
    }
}

