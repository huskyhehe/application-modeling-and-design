/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.CustomerManagement;

import digitalmarketing.MarketModel.Market;
import digitalmarketing.Personnel.Person;
import java.util.ArrayList;
import digitalmarketing.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    

    ArrayList<Order> orders;
    Person person;
    Market market;

    // Constructor
    public CustomerProfile(String id) {
        this.person = new Person(id);
        this.orders = new ArrayList<>();
    }
    

    // Getters
    public String getId(){
        return person.getPersonId();
    }

    public Market getMarket() {
        return market;
    }
       
    // Setters    
    public void setMarket(Market m) {
        if (this.market != null) this.market.getCustomerGroup().remove(this);
        this.market = m;   
        m.getCustomerGroup().add(this);
    }
    
    
    public int getTotalPricePerformance(){ 
        //for each order in the customer order list
        //calculate order price performance and add it to the sum

        return 0;}
 
        
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    
    public void addCustomerOrder(Order o){
        orders.add(o);
    } 

    
    // Print
    public void print() {
        System.out.println(" * Id: " + this.getId() + " | Market: " + this.getMarket().getName());
    }
}
