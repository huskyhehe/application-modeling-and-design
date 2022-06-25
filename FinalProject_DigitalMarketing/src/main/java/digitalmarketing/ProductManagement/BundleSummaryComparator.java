package digitalmarketing.ProductManagement;

import java.util.Comparator;

public class BundleSummaryComparator implements Comparator<BundleSummary> {

    @Override
    public int compare(BundleSummary o1, BundleSummary o2) {
        return o2.getSalesRevenue() - o1.getSalesRevenue();
    }
}
