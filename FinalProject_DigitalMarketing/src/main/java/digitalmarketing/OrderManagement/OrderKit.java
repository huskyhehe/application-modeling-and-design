/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import digitalmarketing.MarketModel.MarketChannelAssignment;
import digitalmarketing.ProductManagement.Bundle;
import digitalmarketing.ProductManagement.Product;

/**
 *
 * @author HeZhou
 */
public class OrderKit {
        
    Bundle selectedBundle;
    int finalPrice;
    int quantitySold;
    int discount;
    Order order;
    
    // Constructor    
    public OrderKit(Order order, Bundle bundle, int quantity) {
        this.selectedBundle = bundle;
        this.quantitySold = quantity;
        int originalPrice = bundle.calculateOriginalPrice();
        for (MarketChannelAssignment mca : bundle.getDiscountMap().keySet()) {
            if (mca == order.mcAssignment) {
                discount =  bundle.getDiscountMap().get(mca);
            }
        }
        this.finalPrice = originalPrice - discount;

        bundle.getOrderKits().add(this);//make sure product links back to the item
    }

    public Bundle getSelectedBundle() {
        return selectedBundle;
    }


    public int getTotalFinalPrice() {
        return finalPrice * quantitySold;
    }

    public int getTotalOriginalPrice() {
        return selectedBundle.calculateOriginalPrice() * quantitySold;
    }

    public int getQuantitySold() {
        return quantitySold;
    }


    public int getTotalDiscount() {
        return discount * quantitySold;
    }


    // Output
    public void printDetails(){
        System.out.println(selectedBundle.getTitle()+ " | $" + finalPrice + " | Quantity: " + quantitySold);
    }


    public void displayForCustomer() {
        System.out.println("+ " + selectedBundle.getTitle() + " --------------- Quantity: " + quantitySold);
        for (Product p : selectedBundle.getBundledProducts()) {
            System.out.println("+   - " + p.getName());
        }
    }
}
