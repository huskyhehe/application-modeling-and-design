/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing;

import digitalmarketing.Business.Business;

/**
 *
 * @author HeZhou
 */
public class DigitalMarketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // init Business
        Business sony = new Business("SONY");
        DataLoader dataLoader = new DataLoader(sony);
        Interaction ui = new Interaction(sony);

        // manually populate products, bundles, markets, channels and ads
        dataLoader.populateBusinessData();


        // Customer Role:---------------------------------------------
        // Mock the flow for a customer to make orders
        ui.CustomerDemo();
        System.out.println("\nCheck if the order is in the order directory:");
        sony.getOrderDirectory().printDetails();


//        // Manager Role:----------------------------------------------
//        // auto generate random Orders
//        dataLoader.generateRandomOrders(30);
//        // Mock the dashboard for a manager to check reports
//        ui.ManagerDashboard();
    }
}
