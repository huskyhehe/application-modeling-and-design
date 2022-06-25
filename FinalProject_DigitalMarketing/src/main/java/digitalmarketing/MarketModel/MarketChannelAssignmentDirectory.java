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
public class MarketChannelAssignmentDirectory {
    
    Business business;
    ArrayList<MarketChannelAssignment> assignments;
    
    
    // Constructor
    public MarketChannelAssignmentDirectory(Business business) {
        this.business = business;
        this.assignments = new ArrayList<>();
    }
    
    
    // Getters
    public ArrayList<MarketChannelAssignment> getAssignments() {
        return assignments;
    }
    
    
    public MarketChannelAssignment newAssignment(Market market, Channel channel) {
        MarketChannelAssignment mca = market.newAssignment(channel);
        market.getChannels().add(channel);
        channel.getMarkets().add(market);
        assignments.add(mca);
        return mca;
    }

    public MarketChannelAssignment newAssignment(String code, String marketName, String channelName) {
        MarketChannelAssignment mca = new MarketChannelAssignment(code, business.getMarketDirectory().findMarket(marketName), business.getChannelDirectory().findChannel(channelName));
        business.getMarketDirectory().findMarket(marketName).getChannels().add(business.getChannelDirectory().findChannel(channelName));
        business.getChannelDirectory().findChannel(channelName).getMarkets().add(business.getMarketDirectory().findMarket(marketName));
        assignments.add(mca);
        return mca;
    }


    public MarketChannelAssignment findAssignment(String code) {
        for (MarketChannelAssignment mca : assignments) {
            if (mca.getCode().equals(code)) return mca;
        }
        return null;
    }

    public MarketChannelAssignment findAssignment(String marketName, String channelName) {
        for (MarketChannelAssignment mca : assignments) {
            if (mca.getMarket().getName().equals(marketName) && mca.getChannel().getName().equals(channelName)) {
                return mca;
            }
        }
        return null;
    }
}