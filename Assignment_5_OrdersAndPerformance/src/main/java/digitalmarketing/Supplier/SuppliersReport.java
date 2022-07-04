/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Supplier;

import digitalmarketing.Business.Business;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HeZhou
 */
public class SuppliersReport {
    
    Business business;
    ArrayList<SupplierSummary> supplierSummaryList;
 

    public SuppliersReport() {
        supplierSummaryList = new ArrayList();
    }
    
    public SuppliersReport(Business b) {
        this.business = b;
        supplierSummaryList = new ArrayList();
        
        for (Supplier s : b.getSupplierDirectory().getSuppliers()) {
            supplierSummaryList.add(new SupplierSummary(s));
        }
    }
    
    public void addSupplierSummary(SupplierSummary ss) {
        supplierSummaryList.add(ss);
    }
    
    
    public void sortByRank() {
        Collections.sort(supplierSummaryList, new SupplierSummaryComparator());
    }
    
    
    public void print() {
        System.out.println(" -----------  Supplier Report ----------- ");
        sortByRank();
        for (SupplierSummary ss : supplierSummaryList){
            ss.print();
        }
    }
    
    
    
    public void printTopRank(int head) {
        System.out.println("------------------------- Supplier Report ------------------------");
        System.out.println("                      Sorted By: Sales Valume                     ");
        sortByRank();
        for (int i = 0; i < head; i++) {
            System.out.print("#" + (i + 1) + " ");
            supplierSummaryList.get(i).print();
        }
        System.out.println();
        System.out.println("Indicator Descriptions:");
        System.out.println("* Sold Quantity = the total item quantity sold");
        System.out.println("* Sales Volume = Sold Quantity * Actural Price");
        System.out.println("* Sales Valume = Sold Quantity * (Actural Price - Target Price)");
        System.out.println();
    }
}
