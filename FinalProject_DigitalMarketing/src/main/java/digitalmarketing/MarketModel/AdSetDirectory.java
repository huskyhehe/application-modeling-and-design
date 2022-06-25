/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author HeZhou
 */
public class AdSetDirectory {
    
    Business business;
    ArrayList<AdSet> adSets;

    
    public AdSetDirectory(Business b) {
        this.business = b;
        this.adSets = new ArrayList<>();
    }
    
    
    // Getters
    public ArrayList<AdSet> getAdSets() {
        return adSets;
    }
    
    
    public AdSet newAdSet(String name, String des, String assignmentCode, int cps) {
        AdSet newAdSet = new AdSet(name, des, cps);
        for (MarketChannelAssignment mca : business.getAssignmentDirectory().getAssignments()) {
            if (mca.getCode().equals(assignmentCode)) {
                newAdSet.setMarketChannelAssignment(mca);
                mca.setAdSet(newAdSet);
                adSets.add(newAdSet);
            }
        }
        return newAdSet;
    }

    
    // Output
    public void printDetails() {
        System.out.println("============================ AdSet Directory =============================");
        for (AdSet ad : adSets) {
            ad.printDetails();
        }
        System.out.println();
    } 
}
