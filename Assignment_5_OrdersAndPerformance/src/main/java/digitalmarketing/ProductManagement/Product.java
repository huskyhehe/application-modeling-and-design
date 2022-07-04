/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;



import java.util.ArrayList;
import digitalmarketing.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class Product {

    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    ArrayList<OrderItem> orderitems;


    public Product(int fp, int cp, int tp, String n) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderitems = new ArrayList();
        name = n;
    }

    public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; //returns itself
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    
    
    public void addOrderItem(OrderItem oi) {
        orderitems.add(oi);
    }

    //Number of item sales above target 
    public int getNumberOfProductSalesAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public boolean isProductAlwaysAboveTarget() {

        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == false) {
                return false; //
            }
        }
        return true;
    }
    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getSalesVolume() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();     //positive and negative values       
        }
        return sum;
    }
    
    // New!
    public int getSoldQuantity() {
        int sum = 0; 
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getQuantity(); 
        }
        return sum;
    }

    
    public String getName() {
        return name;
    }
    
    
    public void printDetails(){
        System.out.println("Product: " + name + " | floor: " + floorPrice + " | ceiling: " + ceilingPrice + " | target: " + targetPrice);
    }

}
