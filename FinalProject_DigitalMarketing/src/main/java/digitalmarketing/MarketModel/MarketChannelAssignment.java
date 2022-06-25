/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;

import digitalmarketing.ProductManagement.Bundle;
import digitalmarketing.ProductManagement.Product;
import java.util.ArrayList;


/**
 *
 * @author HeZhou
 */
public class MarketChannelAssignment {
    
    String code;
    Market market;
    Channel channel;    
    AdSet adSet;
    ArrayList<Bundle> displayBundles;
    
    
    // Constructor
    public MarketChannelAssignment(Market m, Channel c) {    
        this.market = m;
        this.channel = c;
        displayBundles = new ArrayList<>();
    }

    public MarketChannelAssignment(String code, Market m, Channel c) {
        this.code = code;
        this.market = m;
        this.channel = c;
        displayBundles = new ArrayList<>();
    }
    
    
    // Getters
    public String getCode() {
        return code;
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }       
    
    public AdSet getAdSet() {
        return adSet;
    }

    public ArrayList<Bundle> getDisplayBundles() {
        return displayBundles;
    }

    // Setters
    public void setAdSet(AdSet adSet) {
        this.adSet = adSet;
    }


    public int getKitDiscount(Bundle b) {
        for (MarketChannelAssignment mca : b.getDiscountMap().keySet()) {
            if (mca == this) {
                return b.getDiscountMap().get(mca);
            }
        }
        return 0;
    }
    
    public int getKitFinalPrice(Bundle b) {
        int originalPrice = b.getOriginalPrice();
        int finalPrice = 0;
        for (MarketChannelAssignment mca : b.getDiscountMap().keySet()) {
            if (mca == this) {
                finalPrice = originalPrice - b.getDiscountMap().get(mca);
            }      
        }
        return finalPrice;
    }


    // Output
    public void displayBundlesForCustomer() {
        for (Bundle b : displayBundles) {
            System.out.println("+ " + b.getTitle());
            for (Product p : b.getBundledProducts()) {
                System.out.println("+   - " + p.getName());
            }
            System.out.println("+                                        Original: $" + b.calculateOriginalPrice());
            System.out.println("+                                        Discount: $" + getKitDiscount(b));
            System.out.println("+                                             Now: $" + getKitFinalPrice(b));
            System.out.println("----------------------------------------------------------");
        }
    }
}
