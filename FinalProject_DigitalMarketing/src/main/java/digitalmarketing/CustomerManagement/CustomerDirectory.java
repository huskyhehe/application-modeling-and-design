/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.CustomerManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    Business business;
    ArrayList<CustomerProfile> customers;

    // Constructor
    public CustomerDirectory(Business d) {
        business = d;
        customers = new ArrayList<>();
    }
    
    // Getters
    public ArrayList<CustomerProfile> getCustomers() {
        return customers;
    }
    
    
    public CustomerProfile newCustomerProfile(String id) {
        CustomerProfile cp = new CustomerProfile(id);
        customers.add(cp);
        return cp;
    }

    
    public CustomerProfile findCustomer(String id) {
        for (CustomerProfile cp : customers) {
            if (cp.isMatch(id)) {
                return cp;
            }
        }
        return null; //not found after going through the whole list
    }

    
    public void printDetails(){
        System.out.println("================ Customer Directory ================");   
        customers.sort(new CustomerComparator());
        for (CustomerProfile cp : customers){
            cp.print();
        }
        System.out.println();
    }
}
