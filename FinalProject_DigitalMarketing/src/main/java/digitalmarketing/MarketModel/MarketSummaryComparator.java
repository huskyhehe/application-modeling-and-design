package digitalmarketing.MarketModel;

import java.util.Comparator;

public class MarketSummaryComparator implements Comparator<MarketSummary> {

    @Override
    public int compare(MarketSummary o1, MarketSummary o2) {
        return o2.getSalesRevenue() - o1.getSalesRevenue();
    }
}
