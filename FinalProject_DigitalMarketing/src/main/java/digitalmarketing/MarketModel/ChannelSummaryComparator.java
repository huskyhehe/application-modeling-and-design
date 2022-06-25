package digitalmarketing.MarketModel;

import java.util.Comparator;

public class ChannelSummaryComparator implements Comparator<ChannelSummary> {

    @Override
    public int compare(ChannelSummary o1, ChannelSummary o2) {
        return o2.getSalesRevenue() - o1.getSalesRevenue();
    }
}
