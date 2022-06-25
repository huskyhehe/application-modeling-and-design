package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;

import java.util.ArrayList;
import java.util.Collections;

public class ChannelsReport {
    Business business;
    ArrayList<ChannelSummary> channelSummaries;

    // Constructor
    public ChannelsReport(Business b) {
        this.business = b;
        channelSummaries = new ArrayList<>();
        for (Channel c : b.getChannelDirectory().getChannels()) {
            channelSummaries.add(new ChannelSummary(c));
        }
    }

    public void sortByRank() {
        Collections.sort(channelSummaries, new ChannelSummaryComparator());
    }


    // Output
    public void printTopRank() {
        System.out.println("--------------------------- Channels Report ----------------------------");
        System.out.println("                       Sorted By: Sales Revenue                    ");
        sortByRank();

        for(int i = 0; i < channelSummaries.size(); i++) {
            System.out.print("#" + (i + 1) + " ");
            channelSummaries.get(i).printDetails();
        }

        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Order Quantity = total count of orders through the channel");
        System.out.println("* Sales Revenue = total orders revenue through the channel");
        System.out.println();
    }
}
