/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Supplier;



/**
 *
 * @author HeZhou
 */
public class SupplierSummary {
    
    Supplier subjectSupplier;
    int salesValume;
    int acutalSalesVolume;
    int itemSoldQuantity;

    public SupplierSummary(Supplier ss) {
        this.subjectSupplier = ss;
        salesValume = ss.getSalesValume();
        acutalSalesVolume = ss.getSalesVolume();
        itemSoldQuantity = ss.getItemSoldQuantity();
    }
    

    public int getSalesValume() {
        return salesValume;
    }
    
    
    
    public void print() {
        System.out.println(subjectSupplier.getName());
        System.out.println(" | Item Sold Quantity: " + itemSoldQuantity + " | Sales Volume: " +  acutalSalesVolume + " | Sales Valume:" + salesValume);
    }  
}
