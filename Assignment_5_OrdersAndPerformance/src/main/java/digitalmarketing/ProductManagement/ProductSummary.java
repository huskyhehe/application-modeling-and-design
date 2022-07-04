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
    
    
    Product subjectproduct;
    int numberofsalesabovetarget;
    int numberofsalesbelowtarget;
    int salesvalume; //total profit above target --could be negative too
    int acutalsalesvolume;
    // New!
    int soldQuantity;
    int rank; // will be done later

    public ProductSummary(Product p) {

        numberofsalesabovetarget = p.getNumberOfProductSalesAboveTarget();
        salesvalume = p.getOrderPricePerformance();
        subjectproduct = p; //keeps track of the product itself not as well;
        
        acutalsalesvolume = p.getSalesVolume();
        soldQuantity = p.getSoldQuantity();

    }

    public int getNumberAboveTarget() {
        return numberofsalesabovetarget;
    }

    public boolean isProductAlwaysAboveTarget() {
        return false; // to be implemented
    }
    
    public void print(){
        
        System.out.println(subjectproduct.getName());
        System.out.println(" | Sold Quantity: " + soldQuantity + " | Sales Volume: " +  acutalsalesvolume + " | Sales Valume:" + salesvalume);
        
    }

    // Lab Contents
    public int getRank() {
        return rank;
    }

    // New!
    public int getAcutalsalesvolume() {
        return acutalsalesvolume;
    }
    

}
