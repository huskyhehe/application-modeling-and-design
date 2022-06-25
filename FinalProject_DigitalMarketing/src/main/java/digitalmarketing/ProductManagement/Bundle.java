/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;


import digitalmarketing.MarketModel.Market;
import digitalmarketing.MarketModel.MarketChannelAssignment;
import digitalmarketing.OrderManagement.OrderKit;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author HeZhou
 */
public class Bundle {
    
    String title;
    ArrayList<Product> bundledProducts;
    ArrayList<Market> targetMarkets;
    HashMap<MarketChannelAssignment, Integer> discountMap; 
    ArrayList<OrderKit> orderKits;

    
    // Constructor
    public Bundle(String title) {
        this.title = title;
        bundledProducts = new ArrayList<>();
        targetMarkets = new ArrayList<>();
        discountMap = new HashMap<>();
        orderKits = new ArrayList<>();
    }

    
    // Getters    
    public String getTitle() {
        return title; 
    }

    public ArrayList<Product> getBundledProducts() {
        return bundledProducts;
    }
    
    public int getOriginalPrice() {
        int sum = 0;
        for (Product p : bundledProducts) {
            sum += p.getTargetPrice();   
        }
        return sum; 
    }    

    public ArrayList<OrderKit> getOrderKits() {
        return orderKits;
    }

    
    public HashMap<MarketChannelAssignment, Integer> getDiscountMap() {
        return discountMap;
    }
    
    
    public void addProduct(Product p){
        bundledProducts.add(p);
    }        
    

        
    public void addToDiscountMap(MarketChannelAssignment mca, Integer discount) {
        mca.getDisplayBundles().add(this);
        if (!targetMarkets.contains(mca.getMarket())) targetMarkets.add(mca.getMarket());
        discountMap.put(mca, discount);   
    }
    
    
    public int calculateOriginalPrice() {
        int sum = 0;
        for (Product p : bundledProducts) {
            sum += p.getTargetPrice();
        }
        return sum;
    }    


    public int getSalesRevenue() {
        int sum = 0;
        for (OrderKit ok : this.getOrderKits()) {
            sum += ok.getTotalFinalPrice();
        }
        return sum;
    }

    public int getQuantitySold() {
        int sum = 0;
        for (OrderKit ok : this.getOrderKits()) {
            sum += ok.getQuantitySold();
        }
        return sum;
    }

    
    // Output    
    public void printDetails() {
        System.out.println(" * " + title);
        System.out.println("   + Included Products: ");
        for (Product p : bundledProducts) {
            System.out.println("       - " + p.getName());
        }
        System.out.println("   + Original Price: $" + getOriginalPrice());
        System.out.println("   + Final Price(After Discount) Settings: ");
        for (MarketChannelAssignment mca : discountMap.keySet()) {
            int finalPrice = getOriginalPrice() - discountMap.get(mca);
            System.out.println("       - < Market: " + mca.getMarket().getName() + " & Channel: " + mca.getChannel().getName() + " >  ==>  $" + finalPrice);
        }
        System.out.println("------------------------------------------------------------");
    }
}
    
    
