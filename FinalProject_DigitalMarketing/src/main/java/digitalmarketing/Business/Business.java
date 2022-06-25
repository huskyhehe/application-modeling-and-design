/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Business;


import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.MarketModel.MarketDirectory;
import digitalmarketing.OrderManagement.OrderDirectory;
import digitalmarketing.ProductManagement.BundleDirectory;
import digitalmarketing.ProductManagement.ProductDirectory;
import digitalmarketing.MarketModel.ChannelDirectory;
import digitalmarketing.MarketModel.AdSetDirectory;
import digitalmarketing.MarketModel.MarketChannelAssignmentDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    OrderDirectory orderDirectory;
    CustomerDirectory customerDirectory;
    // New!
    ProductDirectory productDirectory;
    BundleDirectory bundleDirectory;
    MarketDirectory marketDirectory;
    ChannelDirectory channelDirectory;
    AdSetDirectory adSetDirectory;
    MarketChannelAssignmentDirectory assignmentDirectory;

    
    // Constructor
    public Business(String n) {
        this.name = n;
        orderDirectory = new OrderDirectory(this);
        customerDirectory = new CustomerDirectory(this);
        productDirectory = new ProductDirectory(this);
        bundleDirectory = new BundleDirectory(this);
        marketDirectory = new MarketDirectory(this);
        channelDirectory = new ChannelDirectory(this);
        adSetDirectory = new AdSetDirectory(this);
        assignmentDirectory = new MarketChannelAssignmentDirectory(this);
    }
    
    
    // Getters
    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }  
    
    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }
    
    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    public BundleDirectory getBundleDirectory() {
        return bundleDirectory;
    }

    public MarketDirectory getMarketDirectory() {
        return marketDirectory;
    }

    public ChannelDirectory getChannelDirectory() {
        return channelDirectory;
    }

    public AdSetDirectory getAdSetDirectory() {
        return adSetDirectory;
    }

    public MarketChannelAssignmentDirectory getAssignmentDirectory() {
        return assignmentDirectory;
    }

    // New!
    public void printBusinessTitle() {
        System.out.println("------------------------- Business Title --------------------------");
        System.out.println(name);
        System.out.println();
    }
}
