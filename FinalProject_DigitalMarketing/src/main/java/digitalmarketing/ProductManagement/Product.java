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

    String name;
    int targetPrice;
    ArrayList<OrderItem> orderItems;
    

    // Constructor
    public Product(String name, int targetPrice) {
        this.name = name;
        this.targetPrice = targetPrice;
        this.orderItems = new ArrayList<>();
    }
    

    // Getters
    public int getTargetPrice() {
        return targetPrice;
    }
 
    
    public void addOrderItem(OrderItem oi) {
        orderItems.add(oi);
    }

    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses

    public int getProductSalesPerformance() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getItemSalesPerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getProductSalesRevenue() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getItemTotalPrice();     //positive and negative values       
        }
        return sum;
    }
    
    // New!
    public int geProductQuantitySold() {
        int sum = 0; 
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getItemQuantitySold(); 
        }
        return sum;
    }

    
    public String getName() {
        return name;
    }
    
    
    
    // Output
    public void printDetails(){
        System.out.println("   - " + name + " | Target Price: " + targetPrice);
    }    

}
