/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.CustomerManagement;

import digitalmarketing.Personnel.Person;
import digitalmarketing.Business.Business;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    Business business;
    ArrayList<CustomerProfile> customerlist;

    public CustomerDirectory(Business d) {

        business = d;
        customerlist = new ArrayList();

    }

    public CustomerProfile newCustomerProfile(Person p) {

        CustomerProfile sp = new CustomerProfile(p);
        customerlist.add(sp);
        return sp;
    }

    public CustomerProfile findCustomer(String id) {

        for (CustomerProfile sp : customerlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public CustomersReport generatCustomerPerformanceReport() {
        CustomersReport customersreport = new CustomersReport();

        for (CustomerProfile cp : customerlist) {

            CustomerSummary cs = new CustomerSummary(cp);
            customersreport.addCustomerSummary(cs);
        }
        return customersreport;
    }
    
    public void printCustomerNames(){
        System.out.println("------------------- Customer Directory -----------------");
   
        Collections.sort(customerlist, new CustomerComparator() );
        
        
        for (CustomerProfile c : customerlist){
            System.out.println(c.getName());
        }
        System.out.println();
    }
    
    
    // New!
    public ArrayList<CustomerProfile> getCustomerlist() {
        return customerlist;
    }
    
}
