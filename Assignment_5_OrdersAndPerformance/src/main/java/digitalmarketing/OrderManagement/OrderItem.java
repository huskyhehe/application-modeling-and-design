/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import digitalmarketing.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {

    Product selectedproduct;
    int actualPrice;
    int quantity;

    public OrderItem(Product p, int q, int ap) {
        selectedproduct = p;
        p.addOrderItem(this); //make sure product links back to the item
        quantity = q;
        actualPrice = ap;
    }

    public int getOrderItemTotal() {
        return actualPrice * quantity;
    }
    
    
    // New!
    public int getQuantity() {
        return quantity;
    }
    


//The following calculates what the price gain would have been if products were sold at target price
    public int getOrderItemTargetTotal() {
        return selectedproduct.getTargetPrice() * quantity;
    }

    //returns positive if seller is making higher margin than target
    //returns negative if seller is making lower margin than target
    //otherwise zero meaning neutral
    public int calculatePricePerformance() {
        return actualPrice - selectedproduct.getTargetPrice();
    }

    public boolean isActualAboveTarget() {
        if (actualPrice > selectedproduct.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isActualBelowTarget() {
        if (actualPrice < selectedproduct.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isActualATTarget() {
        if (actualPrice == selectedproduct.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    
    public void printItemDetails(){
        System.out.println(selectedproduct.getName() + " | Price: " + actualPrice + "| Quantity: " + quantity);
    }
}
