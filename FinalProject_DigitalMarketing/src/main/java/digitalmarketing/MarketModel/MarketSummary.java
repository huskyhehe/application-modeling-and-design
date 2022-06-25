package digitalmarketing.MarketModel;


public class MarketSummary {

    Market subjectMarket;
    int size;
    int salesRevenue;
    int orderQuantity;

    // Constructor
    public MarketSummary(Market m) {
        this.subjectMarket = m;
        this.size = m.getSize();
        this.salesRevenue = m.getSalesRevenue();
        this.orderQuantity =m.getOrderQuantity();
    }

    // Getters
    public int getSalesRevenue() {
        return salesRevenue;
    }

    // Output
    public void printDetails() {
        System.out.println(subjectMarket.getName());
        System.out.println(" | Market Size: " + size + " | Order Quantity: " + size + " | Sales Revenue: $" +  salesRevenue);
    }
}
