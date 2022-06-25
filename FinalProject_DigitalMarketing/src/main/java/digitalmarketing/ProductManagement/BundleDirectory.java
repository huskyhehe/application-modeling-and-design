/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class BundleDirectory {
    
    Business business;   
    ArrayList<Bundle> bundles;

    
    // Constructor
    public BundleDirectory(Business b) {
        this.business = b;
        bundles = new ArrayList<>();
    }
    
    // Getters
    public ArrayList<Bundle> getBundles() {
        return bundles;
    }
    
    
    public Bundle newBundle(String title) {
        Bundle newBundle = new Bundle(title);
        bundles.add(newBundle);
        return newBundle;
    }
    
    
    public Bundle newBundle(String title, ArrayList<String> productsNames) {
        Bundle newBundle = new Bundle(title);
        for (String pn : productsNames) {
            for (Product p : business.getProductDirectory().getProducts()) {
                if (p.getName().equals(pn)) newBundle.addProduct(p);
            }    
        }
        bundles.add(newBundle); 
        return newBundle;    
    }
    
    
    public void addProductToBundle(String bundleTitle, String productName) {
        for (Bundle b : bundles) {
            if (b.getTitle().equals(bundleTitle)) {
                for (Product p : business.getProductDirectory().getProducts()) {
                    if (p.getName().equals(productName)) b.addProduct(p);
                }
            }
        }    
    }
              

    public Bundle findBundle(String bundleTitle) {
        for (Bundle b : bundles) {
            if (b.getTitle().equals(bundleTitle)) return b;
        }
        return null;
    }

    
    public void printDetails() {
        System.out.println("==================== Bundle Directory =======================");
        for (Bundle b : bundles) {           
            b.printDetails();
        }
    }
}
