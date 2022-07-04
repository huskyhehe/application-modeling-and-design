/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.Supplier;

import java.util.ArrayList;
import digitalmarketing.Business.Business;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {

    Business business;
    ArrayList<Supplier> suppliers;

    public SupplierDirectory(Business b) {
        suppliers = new ArrayList();
        business = b;
    }

    public Supplier newSupplier(String n, String t) {
        Supplier supplier = new Supplier(n, this, t);
        suppliers.add(supplier);
        return supplier;

    }

    public Supplier findSupplier(String id) {

        for (Supplier supplier : suppliers) {

            if (supplier.getName().equals(id)) {
                return supplier;
            }
        }
        return null;
    }

    public Supplier findSupplierByIndex(int index) {
        if (index<0) return null;
        if (index>suppliers.size()) return null;
        return suppliers.get(index);
    }
    
    
    public void printSupplierList(){
        System.out.println("---------------------- Supplier Directory -------------------------");
        for (Supplier s : suppliers) {
            s.printSupplierDetails();
        }
        System.out.println();
    }
    
    
    // New!
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
   
}
