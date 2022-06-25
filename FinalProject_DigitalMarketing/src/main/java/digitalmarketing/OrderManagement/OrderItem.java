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

    Product selectedProduct;
    int actualPrice;
    int quantitySold;

    public OrderItem(Product p, int q, int ap) {
        selectedProduct = p;
        p.addOrderItem(this); //make sure product links back to the item
        quantitySold = q;
        actualPrice = ap;
    }

    public int getItemTotalPrice() {
        return actualPrice * quantitySold;
    }
    
    public int getItemSalesPerformance() {
        return actualPrice - selectedProduct.getTargetPrice();
    }
    
    // New!
    public int getItemQuantitySold() {
        return quantitySold;
    }
    
     public void printItemDetails(){
        System.out.println(selectedProduct.getName() + " | Price: " + actualPrice + "| Quantity: " + quantitySold);
    }
}