package digitalmarketing.MarketModel;

public class ChannelSummary {

    Channel subjectChannel;
    int salesRevenue;
    int orderQuantity;

    // Constructor
    public ChannelSummary(Channel c) {
        this.subjectChannel = c;
        this.salesRevenue = c.getSalesRevenue();
        this.orderQuantity =c.getOrderQuantity();
    }

    // Getters
    public int getSalesRevenue() {
        return salesRevenue;
    }

    // Output
    public void printDetails() {
        System.out.println(subjectChannel.getName());
        System.out.println(" | Order Quantity: " + orderQuantity + " | Sales Revenue: $" +  salesRevenue);
    }
}
