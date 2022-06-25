package digitalmarketing.OrderManagement;

import digitalmarketing.Business.Business;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.MarketModel.MarketSummary;
import digitalmarketing.MarketModel.MarketSummaryComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HeZhou
 */
public class OrdersReport {

    Business business;
    ArrayList<OrderSummary> orderSummaries;
    int totalSalesRevenue;
    int orderQuantity;
    int averageOrderValue;

    // Constructor
    public OrdersReport(Business b) {
        this.business = b;
        orderSummaries = new ArrayList<>();
        for (Order o : b.getOrderDirectory().getOrders()) {
            orderSummaries.add(new OrderSummary(o));
        }
    }

    // Getters
    public int getTotalSalesRevenue() {
        int sum = 0;
        for (Order o : business.getOrderDirectory().getOrders()) {
            sum += o.getSalesRevenue();
        }
        return sum;
    }

    public int getOrderQuantity() {
        return business.getOrderDirectory().getOrders().size();
    }

    public int getAverageOrderValue() {
        return getTotalSalesRevenue() / getOrderQuantity();
    }


    // Output
    public void printDescription() {
        System.out.println("------------------------- Orders Report ------------------------");
        System.out.println("* Order Quantity: " + getOrderQuantity());
        System.out.println("* Sales Revenue: $" + getTotalSalesRevenue());
        System.out.println("* Average Order Value (AOV): $" + getAverageOrderValue());
        System.out.println();
    }
}
