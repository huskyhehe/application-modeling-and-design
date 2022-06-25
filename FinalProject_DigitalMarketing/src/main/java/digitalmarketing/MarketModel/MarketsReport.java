package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;
import java.util.ArrayList;
import java.util.Collections;

public class MarketsReport {

    Business business;
    ArrayList<MarketSummary> marketSummaries;

    // Constructor
    public MarketsReport(Business b) {
        this.business = b;
        marketSummaries = new ArrayList<>();
        for (Market m : b.getMarketDirectory().getMarkets()) {
            marketSummaries.add(new MarketSummary(m));
        }
    }

    public void sortByRank() {
        Collections.sort(marketSummaries, new MarketSummaryComparator());
    }


    // Output
    public void printTopRank() {
        System.out.println("------------------------- Markets Report ------------------------");
        System.out.println("                      Sorted By: Sales Revenue                    ");
        sortByRank();

        for(int i = 0; i < marketSummaries.size(); i++) {
            System.out.print("#" + (i + 1) + " ");
            marketSummaries.get(i).printDetails();
        }

        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Market Size = total count of customers of the market");
        System.out.println("* Order Quantity = total count of orders of the market");
        System.out.println("* Sales Revenue = total orders revenue of the market");
        System.out.println();
    }
}

