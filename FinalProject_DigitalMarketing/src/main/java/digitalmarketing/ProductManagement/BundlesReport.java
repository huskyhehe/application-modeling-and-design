package digitalmarketing.ProductManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;
import java.util.Collections;

public class BundlesReport {

    Business business;
    ArrayList<BundleSummary> bundleSummaries;

    // Constructor
    public BundlesReport(Business b) {
        this.business = b;
        bundleSummaries = new ArrayList<>();
        for (Bundle bundle : b.getBundleDirectory().getBundles()) {
            bundleSummaries.add(new BundleSummary(bundle));
        }
    }

    public void sortByRank() {
        Collections.sort(bundleSummaries, new BundleSummaryComparator());
    }


    // Output
    public void printTopRank() {
        System.out.println("------------------------- Bundles Report ------------------------");
        System.out.println("                      Sorted By: Sales Revenue                    ");
        sortByRank();

        for(int i = 0; i < bundleSummaries.size(); i++) {
            System.out.print("#" + (i + 1) + " ");
            bundleSummaries.get(i).printDetails();
        }

        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Quantity Sold = the count of bundle kits sold");
        System.out.println("* Sales Revenue = Quantity Sold  * Final Price");
        System.out.println();
    }
}
