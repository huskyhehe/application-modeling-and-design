/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;
import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class MarketDirectory {
    
    Business business;
    ArrayList<Market> markets;
    ArrayList<MarketChannelAssignment> assignments;

    
    // Constructor
    public MarketDirectory(Business b) {
        this.business = b;
        markets = new ArrayList<>();
    }

    // Getters
    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public ArrayList<MarketChannelAssignment> getAssignments() {
        return assignments;
    }

    
    public Market newMarket(String name) {
        Market newMarket = new Market(name);
        markets.add(newMarket);
        return newMarket;
    }
    
    
    public CustomerProfile addCustomerToMarket(String marketName, String CustomerId) {
        for (CustomerProfile cp : business.getCustomerDirectory().getCustomers()) {
            if (cp.getId().equals(CustomerId)) {
                for (Market m : markets) {
                    if (m.getName().equals(marketName)) {
                        cp.setMarket(m);
                        return cp;
                    }
                }                
            }
        }        
        CustomerProfile newCP = business.getCustomerDirectory().newCustomerProfile(CustomerId);
        for (Market m : markets) {
            if (m.getName().equals(marketName)) {
                newCP.setMarket(m);
                return newCP;
            }
        }
        return null;
    }

    
    public MarketChannelAssignment newAssignment(Market market, Channel channel) {
        MarketChannelAssignment newAssignment = market.newAssignment(channel);
        this.assignments.add(newAssignment);  
        return newAssignment;
    }


    public Market findMarket(String name) {
        for (Market m : markets) {
            if (m.getName().equals(name)) return m;
        }
        return null;
    }
    
    // Output    
    public void printDetails() {
        System.out.println("========================== Market Directory ==============================");
        for (Market m : markets) {
            m.printDetails();
        }
        System.out.println();
    }
}