/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.OrderManagement;

/**
 *
 * @author HeZhou
 */
public class OrderSummary {

    Order order;
    int salesRevenue;

    // Constructor
    public OrderSummary(Order o) {
        this.order = o;
        this.salesRevenue = o.getSalesRevenue();
    }

    // Getters
    public int getSalesRevenue() {
        return salesRevenue;
    }
}
