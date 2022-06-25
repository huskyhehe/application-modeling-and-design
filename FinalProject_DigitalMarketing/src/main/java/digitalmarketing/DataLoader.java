/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing;

import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.*;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.OrderManagement.OrderDirectory;
import digitalmarketing.ProductManagement.Bundle;
import digitalmarketing.ProductManagement.BundleDirectory;
import digitalmarketing.ProductManagement.ProductDirectory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author HeZhou
 */
public class DataLoader {

    Business b;
    Faker faker;

    DataLoader(Business business) {
        this.b = business;
        this.faker = new Faker();
    }


    public void populateBusinessData() {
        populateMarkets(b.getMarketDirectory());
        populateChannels(b.getChannelDirectory());
        populateAssignments(b.getAssignmentDirectory());
        populateAdSets(b.getAdSetDirectory());
        populateProducts(b.getProductDirectory());
        populateBundles(b.getBundleDirectory(), b.getAssignmentDirectory());
    }

    public void generateRandomOrders(int count) {
        for (int i = 0; i < count; i++) {
            generateSingleRandomOrder(b.getMarketDirectory(), b.getAssignmentDirectory(), b.getOrderDirectory(), b.getBundleDirectory());
        }

    }

    public void generateSingleRandomOrder(MarketDirectory md, MarketChannelAssignmentDirectory mcad, OrderDirectory od, BundleDirectory bd) {
        Random random = new Random();

        // marketName
        int a = random.nextInt(md.getMarkets().size());
        String marketName = md.getMarkets().get(a).getName();

        // customerId
        String customerId = faker.name().firstName();
        CustomerProfile cp = md.addCustomerToMarket(customerId, marketName);

        // channelName
        int b = random.nextInt(md.findMarket(marketName).getChannels().size());
        String channelName = md.findMarket(marketName).getChannels().get(b).getName();


        Order o = od.newOrder(marketName, channelName, customerId);

        for (int i = 0; i < 2; i++) {
            // bundleName
            int c = random.nextInt(mcad.findAssignment(marketName, channelName).getDisplayBundles().size());
            String bundleTitle = mcad.findAssignment(marketName, channelName).getDisplayBundles().get(c).getTitle();

            // bundleCount
            int e = random.nextInt(2) + 1;
            if (!o.isBundleInOrder(bd.findBundle(bundleTitle))) {
                o.newOrderKit(bd.findBundle(bundleTitle),e);
            }
        }
    }


    public void populateMarkets(MarketDirectory md) {
        md.newMarket("General");
        md.newMarket("Student");    
        md.newMarket("Game Fan");   
    }    


    public void populateChannels(ChannelDirectory cd) {
        cd.newChannel("Instagram Feed");
        cd.newChannel("Facebook Feed");
        cd.newChannel("Netflix Stream");
    } 


    public void populateAssignments(MarketChannelAssignmentDirectory mcad) {
        mcad.newAssignment("gn_ins","General","Instagram Feed");
        mcad.newAssignment("gn_fb","General","Facebook Feed");
        mcad.newAssignment("gn_nf","General","Netflix Stream");         
        mcad.newAssignment("st_ins","Student","Instagram Feed"); 
        mcad.newAssignment("st_fb","Student","Facebook Feed");        
        mcad.newAssignment("gf_ins","Game Fan","Instagram Feed");
        mcad.newAssignment("gf_nf","Game Fan","Netflix Stream");
    }


    public void populateCustomers(MarketDirectory md) {
        md.addCustomerToMarket("Generals", "200");
//        md.addCustomerToMarket("Generals", "202");
        md.addCustomerToMarket("Students", "400");
//        md.addCustomerToMarket("Students", "402");
        md.addCustomerToMarket("Game Fans", "700");
//        md.addCustomerToMarket("Game Fans", "702");
    }


    public void populateAdSets(AdSetDirectory ad) {
        ad.newAdSet("PlayStation 5 Launch Day!","Special Offer for You *Follow Our Ins","gn_ins", 4);
        ad.newAdSet("PlayStation 5 Launch Day!","Limited New Deals for FB","gn_fb", 3);
        ad.newAdSet("PlayStation 5 Launch Day!","Your New Play Choice","gn_nf", 5);
        ad.newAdSet("Back to School Deals!", "New Play Offer For Students *Follow Our Ins","st_ins", 3);
        ad.newAdSet("Back to School Deals!", "New Play Offer For Students on FB","st_fb", 2);
        ad.newAdSet("Luxury Game Experience!", "Special Offer For Our PLUS Members *Follow Our Ins","gf_ins", 4);
        ad.newAdSet("Luxury Game Experience!", "Special Offer For Our PLUS Members","gf_nf", 5);      
    }
    
    
    public void populateProducts(ProductDirectory pd) {
        pd.newProduct("PlayStation5 Console", 499);
        pd.newProduct("Wireless Controller", 80);
        pd.newProduct("VR Headset", 150);
        pd.newProduct("PlayStation Now Subscription - 3 Months", 30);
        pd.newProduct("PlayStation Now Subscription - 6 Months", 50);
        pd.newProduct("PlayStation Plus Subscription - 12 Months", 100);
    }


    public void populateBundles(BundleDirectory bd, MarketChannelAssignmentDirectory mcad) {       
        ArrayList<String> productList1= new ArrayList<>(Arrays.asList("PlayStation5 Console","Wireless Controller"));        
        ArrayList<String> productList2 = new ArrayList<>(Arrays.asList("PlayStation5 Console","Wireless Controller","PlayStation Now Subscription - 3 Months"));
        ArrayList<String> productList3 = new ArrayList<>(Arrays.asList("PlayStation5 Console","Wireless Controller","PlayStation Now Subscription - 6 Months"));
        ArrayList<String> productList4 = new ArrayList<>(Arrays.asList("PlayStation5 Console","VR Headset","PlayStation Plus Subscription - 12 Months"));
            
        Bundle bundle1 = bd.newBundle("Economic PS5 Bundle",  productList1);
        Bundle bundle2 = bd.newBundle("Advanced PS5 Bundle", productList2);
        Bundle bundle3 = bd.newBundle("Luxury PS5 Bundle", productList3);
        Bundle bundle4 = bd.newBundle("Plus-only Ps5+VR Bundle", productList4); 
       
        for (MarketChannelAssignment mca: mcad.getAssignments()) {
            if (null != mca.getCode()) switch (mca.getCode()) {
                case "gn_ins":
                    bundle1.addToDiscountMap(mca, 10);
                    bundle2.addToDiscountMap(mca, 10);
                    bundle3.addToDiscountMap(mca, 10);
                    break;
                case "gn_fb":
                    bundle1.addToDiscountMap(mca, 19);
                    bundle2.addToDiscountMap(mca, 10);
                    bundle3.addToDiscountMap(mca, 19);
                    break;
                case "gn_nf":
                    bundle1.addToDiscountMap(mca, 14);
                    bundle2.addToDiscountMap(mca, 14);
                    bundle3.addToDiscountMap(mca, 14);
                    break;
                case "st_ins":
                    bundle1.addToDiscountMap(mca, 70);
                    bundle2.addToDiscountMap(mca, 70);
                    break;
                case "st_fb":
                    bundle1.addToDiscountMap(mca, 79);
                    bundle2.addToDiscountMap(mca, 79);
                    break;
                case "gf_ins":
                    bundle3.addToDiscountMap(mca, 30);
                    bundle4.addToDiscountMap(mca, 30);
                    break;
                case "gf_nf":
                    bundle3.addToDiscountMap(mca, 34); 
                    bundle4.addToDiscountMap(mca, 34);
                    break;
                default:
                    break;
            }
        }      
    }
}    


