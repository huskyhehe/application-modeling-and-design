package digitalmarketing.MarketModel;

import java.util.Comparator;

public class AdSetSummaryComparator implements Comparator<AdSetSummary> {

    @Override
    public int compare(AdSetSummary o1, AdSetSummary o2) {
        return o2.getSalesRevenue() - o1.getSalesRevenue();
    }
}
