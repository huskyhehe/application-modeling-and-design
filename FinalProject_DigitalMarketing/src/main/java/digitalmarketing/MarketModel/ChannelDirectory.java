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
public class ChannelDirectory {
    
    Business business;
    ArrayList<Channel> channels;

    
    // Constructor
    public ChannelDirectory(Business b) {
        this.business = b;
        this.channels = new ArrayList<>();
    }
    
    // Getters    
    public ArrayList<Channel> getChannels() {
        return channels;
    }   

    
    public Channel newChannel(String name) {
        Channel newChannel = new Channel(name);
        channels.add(newChannel);
        return newChannel;
    }

    public Channel findChannel(String name) {
        for (Channel c : channels) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }

    
    // Output
    public void printDetails() {
        System.out.println("========================== Channel Directory ==========================");
        for (Channel c : channels) {
            c.printDetails();
        }
        System.out.println();
    }   
}
