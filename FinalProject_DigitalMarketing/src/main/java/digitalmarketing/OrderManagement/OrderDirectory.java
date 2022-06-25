/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.MarketModel.MarketChannelAssignment;

/**
 *
 * @author HeZhou
 */
public class OrderDirectory {
    
    Business business;
    ArrayList<Order> orders;
    OrdersReport ordersReport;

    // Constructor
    public OrderDirectory(Business b) {
        orders = new ArrayList<>();
        business = b;
    }

    
    public Order newOrder(CustomerProfile cp, MarketChannelAssignment mca) {
        Order o = new Order(cp, mca);
        mca.getMarket().getMarketOrders().add(o);
        mca.getChannel().getChannelOrders().add(o);
        mca.getAdSet().getAdLeadOrders().add(o);
        orders.add(o);
        return o;
    }
    
    
    public Order newOrder(String marketName, String channelName, String CustomerId) {
        Order o = newOrder(business.getMarketDirectory().addCustomerToMarket(marketName, CustomerId),
                business.getAssignmentDirectory().findAssignment(marketName, channelName));
        return o;
    }


    
    public int getTotalRevenue() {
        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getSalesRevenue();
        }
        return sum;
    }


    public ArrayList<Order> getOrders() {
        return orders;
    }
    

    // Output
    public void printDetails() {
        System.out.println("========================== Order Directory ==============================");
        for (Order o : orders) {
            o.printDetails();
        }
        System.out.println();
    }
    
}
