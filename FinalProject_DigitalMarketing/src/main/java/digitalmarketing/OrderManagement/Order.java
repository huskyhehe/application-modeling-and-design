/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.MarketChannelAssignment;
import digitalmarketing.ProductManagement.Bundle;
import digitalmarketing.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class Order {
    
    CustomerProfile customer;
    ArrayList<OrderKit> orderKits;
    MarketChannelAssignment mcAssignment;


    public Order() {
        orderKits = new ArrayList<>();
    }

    
    public Order(CustomerProfile cp, MarketChannelAssignment mca) {
        this.orderKits = new ArrayList<>();
        this.mcAssignment = mca;
        this.customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
    }


    public MarketChannelAssignment getMcAssignment() {
        return mcAssignment;
    }

    public OrderKit newOrderKit(Bundle bundle, int quantity) {
        OrderKit ok = new OrderKit(this, bundle, quantity);
        orderKits.add(ok);
        return ok;
    }

    public void addOrderKit(OrderKit ok) {
        this.getOrderKits().add(ok);
    }

    public int getSalesRevenue() {
        int sum = 0;
        for (OrderKit ok : orderKits) {
            sum = sum + ok.getTotalFinalPrice();
        }
        return sum;
    }


    public ArrayList<OrderKit> getOrderKits() {
        return orderKits;
    }

    public boolean isBundleInOrder(Bundle b) {
        for (OrderKit ok : this.getOrderKits()) {
            if (ok.getSelectedBundle().equals(b)) return true;
        }
        return false;
    }

    public int getTotalOriginalPrice() {
        int sum = 0;
        for (OrderKit ok : orderKits) {
            sum += ok.getTotalOriginalPrice();
        }
        return sum;
    }

    public int getTotalSavings() {
        int sum = 0;
        for (OrderKit ok : orderKits) {
            sum += ok.getTotalDiscount();
        }
        return sum;
    }

    // Output
    public void displayForCustomer(){
        System.out.println("+++++++++++++++++++ Order Details +++++++++++++++++++++++");
        System.out.println("       " + customer.getId() + ", thanks for your order!");
        for (OrderKit ok : orderKits) {
            ok.displayForCustomer();
        }
        System.out.println("                                       Original: $" + getTotalOriginalPrice());
        System.out.println("                            Your Bundle Savings: $" + getTotalSavings());
        System.out.println("                                    Order Total: $" + getSalesRevenue());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    
    public void printDetails(){
        System.out.println("Order for: " + customer.getId());
        for (OrderKit ok : orderKits){
            System.out.print("* ");
            ok.printDetails();
        }
        System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Total: $" + this.getSalesRevenue());
        System.out.println("(Market: " + this.getMcAssignment().getMarket().getName() +
                           " | Channel: " + this.getMcAssignment().getChannel().getName() + ")");
        System.out.println("---------------------------------------------");
    }   
}