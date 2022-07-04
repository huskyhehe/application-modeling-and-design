package digitalmarketing.OrderManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderReport {

    ArrayList<OrderSummary> ordersummarylist;

    public MasterOrderReport() {

        ordersummarylist = new ArrayList();

    }

    public void generateOrderReport(ArrayList<Order> orders) {
        ArrayList<Order> orderlist = orders;
        OrderSummary ordersummary;
        for (Order order : orderlist) {
            ordersummary = new OrderSummary(order);
            ordersummarylist.add(ordersummary);
        }
    }

    public OrderSummary getTopProfitableOrder() { //most profitable order
        OrderSummary currentTopOrder = null;

        for (OrderSummary os : ordersummarylist) {
            if (currentTopOrder == null) {
                currentTopOrder = os; // initial step 
            } else if (os.getOrderProfit() > currentTopOrder.getOrderProfit()) {
                currentTopOrder = os; //we have a new higher total
            }
        }
        return currentTopOrder;
    }
}
