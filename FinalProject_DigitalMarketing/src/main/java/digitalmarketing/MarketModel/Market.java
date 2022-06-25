/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;

import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.OrderManagement.Order;

import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class Market {
    
    String name;
    ArrayList<CustomerProfile> customerGroup;
    ArrayList<Channel> channels;
    ArrayList<MarketChannelAssignment> assignments;

    ArrayList<Order> marketOrders;
    
    
    // Constructor
    public Market(String name) {
        this.name = name;
        customerGroup = new ArrayList<>();
        channels = new ArrayList<>();
        assignments = new ArrayList<>();
        marketOrders = new ArrayList<>();
    }  

    
    // Getters    
    public String getName() {
        return name;
    }

    public int getSize() {
        return customerGroup.size();
    }

    public ArrayList<CustomerProfile> getCustomerGroup() {
        return customerGroup;
    }

    
    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public ArrayList<MarketChannelAssignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Order> getMarketOrders() {
        return marketOrders;
    }

    public MarketChannelAssignment newAssignment(Channel channel) {
        MarketChannelAssignment newAssignment = new MarketChannelAssignment(this, channel);
        this.channels.add(channel);
        this.assignments.add(newAssignment);
        return newAssignment;
    }


    public int getSalesRevenue() {
        int sum = 0;
        for (Order o : marketOrders) {
            sum += o.getSalesRevenue();
        }
        return sum;
    }

    public int getOrderQuantity() {
        return marketOrders.size();
    }
    
    // Output
    public void printDetails() {
        System.out.println(" * " + name);
        System.out.println("   - Market Size: " + this.getSize());
        System.out.print("   - Marketing Channel:");
        for (Channel c : channels) {
            System.out.print("  #" + c.getName());
        }
        System.out.println("\n------------------------------------------");
    }
}

