/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Supplier;

import java.util.Comparator;


/**
 *
 * @author HeZhou
 */
public class SupplierSummaryComparator implements Comparator<SupplierSummary>{
    
    @Override
    public int compare(SupplierSummary o1, SupplierSummary o2) {
        
        int i = o1.getSalesValume();
        int j = o2.getSalesValume();
        return j-i;
    }
    
}
