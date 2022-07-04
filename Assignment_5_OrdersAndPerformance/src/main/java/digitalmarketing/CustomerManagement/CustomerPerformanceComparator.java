/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.CustomerManagement;

import java.util.Comparator;

/**
 *
 * @author ZHOU
 */
public class CustomerPerformanceComparator implements Comparator<CustomerProfile> {

    @Override
    public int compare(CustomerProfile o1, CustomerProfile o2) {
       
        return Integer.compare(o1.getNumberOfOrdersAboveTotalTarget(), o2.getNumberOfOrdersAboveTotalTarget());
    }
    
    
}
