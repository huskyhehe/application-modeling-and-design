/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.Personnel.EmployeeProfile;
import digitalmarketing.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    EmployeeProfile salesperson;

    public Order() {
        orderitems = new ArrayList();
    }

    public Order(CustomerProfile cp) {
        orderitems = new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson = null;
    }

    public Order(CustomerProfile cp, EmployeeProfile ep) {
        orderitems = new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson.addSalesOrder(this);
    }

    public OrderItem newOrderItem(Product p, int q, int ap) {
        OrderItem oi = new OrderItem(p, q, ap);
        orderitems.add(oi);
        return oi;
    }
    

    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    //sum all the item targets and compare to the total of the order 
    public boolean isOrderAboveTotalTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTargetTotal(); //product targets are added
        }
        if (getOrderTotal() > sum) {
            return true;
        } else {
            return false;
        }

    }
       

    public void printOrderDetails(){
        
        System.out.println("Order for: " + customer.getName());
        for (OrderItem oi : orderitems){
            System.out.print("* ");
            oi.printItemDetails();
        }
        System.out.println("-----------------------------------");
    }
    
    
}
