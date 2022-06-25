package digitalmarketing.MarketModel;

public class AdSetSummary {
    AdSet subjectAdSet;
    int totalCost;
    int salesRevenue;
    int orderQuantity;

    // Constructor
    public AdSetSummary(AdSet ad) {
        this.subjectAdSet = ad;
        this.totalCost = ad.getTotalCost();
        this.salesRevenue = ad.getSalesRevenue();
        this.orderQuantity =ad.getOrderQuantity();
    }

    // Getters
    public int getSalesRevenue() {
        return salesRevenue;
    }

    // Output
    public void printDetails() {
        int revenueMinusCost = salesRevenue - totalCost;
        System.out.println(subjectAdSet.getName() + " | " + subjectAdSet.getDescription());
        System.out.println(" | Order Quantity: " + orderQuantity + " | Order Sales Revenue: $" +  salesRevenue);
        System.out.println(" | Total Cost: $" + totalCost + " | Revenue minus Cost: $" + revenueMinusCost);
    }
}
