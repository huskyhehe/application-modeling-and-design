package digitalmarketing;

import digitalmarketing.Business.Business;
import digitalmarketing.MarketModel.*;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.OrderManagement.OrdersReport;
import digitalmarketing.ProductManagement.BundlesReport;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Interaction {

    Business b;


    //Constructor
    public Interaction(Business b) {
        this.b = b;
    }


    public void ManagerDashboard() {
        System.out.println();
        System.out.println("*************** Management Dashboard ****************");
        System.out.println("   11 Bundle Directory      12 Bundles Report");
        System.out.println("   21 Market Directory      22 Markets Report");
        System.out.println("   31 Channel Directory     32 Channels Report");
        System.out.println("   41 Ad Set Directory      42 Ad Sets Report");
        System.out.println("   51 Order Directory       52 Orders Report");
        System.out.println("*****************************************************");
        System.out.println("-- Enter the number you want to check: ");
        Scanner scan = new Scanner(System.in);

        String select;

        while (scan.hasNextLine()) {

            select = scan.nextLine();
            switch(select) {
                case "11":
                    b.getBundleDirectory().printDetails();
                    break;

                case "12":
                    BundlesReport br = new BundlesReport(b);
                    br.printTopRank();
                    break;

                case "21":
                    b.getMarketDirectory().printDetails();
                    break;

                case "22":
                    MarketsReport mr = new MarketsReport(b);
                    mr.printTopRank();
                    break;

                case "31":
                    b.getChannelDirectory().printDetails();
                    break;

                case "32":
                    ChannelsReport cr = new ChannelsReport(b);
                    cr.printTopRank();
                    break;

                case "41":
                    b.getAdSetDirectory().printDetails();
                    break;

                case "42":
                    AdSetsReport ar = new AdSetsReport(b);
                    ar.printTopRank();
                    break;

                case "51":
                    b.getOrderDirectory().printDetails();
                    break;

                case "52":
                    OrdersReport or = new OrdersReport(b);
                    or.printDescription();
                    break;

                default:
                    System.out.print("-- Enter the number you want to check: ");
                    break;
            }
        }
        scan.close();
    }


    public void CustomerDemo() {

        String marketName;
        String channelName;
        String bundleTitle;
        int quantity;
        String customerId;

        String anyString1;
        String anyString2;

        System.out.println();

        Scanner scan = new Scanner(System.in);

        // Step 1: market
        System.out.println("********************SONY Digital Marketing Customer Flow *******************");
        System.out.println("|Step1/6| Which market do you belong to?");
        System.out.println(" (This question will be figured out by mobile phone in real life)");
        for (Market m : b.getMarketDirectory().getMarkets()) {
            System.out.println(m.getName());
        }
        System.out.print("-- Enter your choice: ");
        marketName = scan.nextLine();


        // Step 2: Channel
        System.out.println();
        System.out.println("|Step2/6| Which channel are you browsing?");
        System.out.println(" (This question will be figured out by mobile phone in real life)");
        for (Channel c : b.getMarketDirectory().findMarket(marketName).getChannels()) {
            System.out.println(c.getName());
        }
        System.out.print("-- Enter your choice: ");
        channelName = scan.nextLine();

        // Step 3: Display Ad
        System.out.println();
        System.out.println("|Step3/6| Personalized Ad Exposure");
        System.out.println(" (You will be redirected to the online shop.)");
        b.getAssignmentDirectory().findAssignment(marketName, channelName).getAdSet().displayForCustomer();
        System.out.print("-- Enter 'go' to the online shop: ");
        anyString1 = scan.nextLine();

        // Step 4: Select Bundle
        System.out.println();
        System.out.println("|Step4/6| Bundle Selection");
        System.out.println("++++++++++++++++++ SONY -- Play Station ++++++++++++++++++");
        System.out.println("++++           Online Shop - Bundle Option            ++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        b.getAssignmentDirectory().findAssignment(marketName, channelName).displayBundlesForCustomer();
        System.out.print("-- Enter your bundle choice: ");
        bundleTitle = scan.nextLine();
        System.out.print("-- Enter the count: ");
        quantity = scan.nextInt();

        // Step 5: Customer Sign In
        System.out.println();
        System.out.println("|Step5/6| Customer Sign Up");
        System.out.println("++++++++++++++++++ Customer Sign Up ++++++++++++=++++++++");
        System.out.print("-- Enter Customer id: ");
        scan.nextLine();
        customerId = scan.nextLine();
        System.out.print("-- Enter 'ok' to check out: ");
        anyString2 = scan.nextLine();

        // Step 6: Order Display
        System.out.println();
        System.out.println("|Step6/6| View Your Order");
        Order o = b.getOrderDirectory().newOrder(marketName, channelName, customerId);
        o.newOrderKit(b.getBundleDirectory().findBundle(bundleTitle),quantity);

        o.displayForCustomer();

        scan.close();
    }
}
