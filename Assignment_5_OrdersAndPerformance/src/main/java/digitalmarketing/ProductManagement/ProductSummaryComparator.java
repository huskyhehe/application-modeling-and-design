/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import java.util.Comparator;

/**
 *
 * @author HeZhou
 */
public class ProductSummaryComparator implements Comparator<ProductSummary> {

    @Override
    public int compare(ProductSummary o1, ProductSummary o2) {
        
        int i = o1.getAcutalsalesvolume();
        int j = o2.getAcutalsalesvolume();
        return j-i;
    }

    
}
