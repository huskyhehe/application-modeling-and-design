package digitalmarketing.ProductManagement;

public class BundleSummary {

    Bundle subjectBundle;
    int salesRevenue;
    int quantitySold;

    // Constructor
    public BundleSummary(Bundle b) {
        this.subjectBundle = b;
        this.salesRevenue = b.getSalesRevenue();
        this.quantitySold =b.getQuantitySold();
    }

    // Getters
    public int getSalesRevenue() {
        return salesRevenue;
    }

    // Output
    public void printDetails() {
        System.out.println(subjectBundle.getTitle());
        System.out.println(" | Quantity Sold: " + quantitySold + " | Sales Revenue: $" +  salesRevenue);
    }
}
