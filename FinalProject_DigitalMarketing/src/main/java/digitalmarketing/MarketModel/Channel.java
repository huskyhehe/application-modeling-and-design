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
 * @author kal bugrara
 */
public class Channel {
    
    String name;
    ArrayList<Market> markets;
    ArrayList<AdSet> adSets;
    ArrayList<MarketChannelAssignment> assignments;

    ArrayList<Order> channelOrders;

    // Constructor
    public Channel(String name) {
        this.name = name;
        this.markets = new ArrayList<>();
        this.adSets = new ArrayList<>();
        this.channelOrders = new ArrayList<>();
    } 
    
    
    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public ArrayList<MarketChannelAssignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Order> getChannelOrders() {
        return channelOrders;
    }

    public int getSalesRevenue() {
        int sum = 0;
        for (Order o : channelOrders) {
            sum += o.getSalesRevenue();
        }
        return sum;
    }

    public int getOrderQuantity() {
        return channelOrders.size();
    }

    // Output
    public void printDetails() {
        System.out.println(" * " + name);
        System.out.print("   - Target Markets:");
        for (Market m : this.markets) {
            System.out.print("  #" + m.getName());
        }
        System.out.println("\n------------------------------------------");
    }

}
