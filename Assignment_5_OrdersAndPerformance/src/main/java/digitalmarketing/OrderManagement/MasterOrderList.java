/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    
    Business business;
    ArrayList<Order> orders;
    MasterOrderReport masterorderreport;

    public MasterOrderList(Business b) {
        orders = new ArrayList();
        business = b;
    }

    public Order newOrder(CustomerProfile cp) {
        Order o = new Order(cp);
        orders.add(o);
        return o;

    }

    public MasterOrderReport generateMasterOrderReport() {
        masterorderreport = new MasterOrderReport();

        return masterorderreport;

    }

    public int getSalesVolume() {

        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getOrderTotal();
        }
        return sum;
    }
    
    // New!
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    
    public void printOrders(){
        for (Order o : orders){
            o.printOrderDetails();
        }
    }
    
}
