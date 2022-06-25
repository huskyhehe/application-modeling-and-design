/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;


import digitalmarketing.OrderManagement.Order;
import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class AdSet {
    
    String name;
    String description;    
    MarketChannelAssignment mca;    
    int costPerSale;
    ArrayList<Order> adSetOrders;

    
    // Constructor
    public AdSet(String name, String des, int cps) {
        this.name = name;
        this.description = des;
        this.costPerSale = cps;
        adSetOrders = new ArrayList<>();
    }    
    

    // Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Order> getAdLeadOrders() {
        return adSetOrders;
    }

    public int getTotalCost() {
        return costPerSale * adSetOrders.size();
    }



    // Setters
    public void setMarketChannelAssignment(MarketChannelAssignment mca) {
        this.mca = mca;
    }


    public int getSalesRevenue() {
        int sum = 0;
        for (Order o : adSetOrders) {
            sum += o.getSalesRevenue();
        }
        return sum;
    }

    public int getOrderQuantity() {
        return adSetOrders.size();
    }
       

    // Output
    public void displayForCustomer() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++            " + mca.getChannel().getName() + " Ad");
        System.out.println("+++");
        System.out.println("+++              ** " + name + " **");
        System.out.println("+++       **** " + description + " ****");
        System.out.println("+++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    
    public void printDetails() {
        System.out.println(" * " + name + " | " + description);
        System.out.println("   - Target Market: " + mca.getMarket().getName());
        System.out.println("   - Media Channel: " + mca.getChannel().getName()); 
        System.out.println("   - Cost Per Sale: " + costPerSale);
        System.out.println("   - Order Count: " + this.getOrderQuantity());
        System.out.println("   - Total  Cost: " + this.getTotalCost());
        System.out.println("-------------------------------------------------");
    }
}

