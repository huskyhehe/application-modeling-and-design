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
public class MasterProductDirectory {    
    Business business;
    ArrayList<Product> masterProducts;

    public MasterProductDirectory(Business b) {
        this.business = b;
        masterProducts = new ArrayList();
    }

    public ArrayList<Product> getMasterProducts() {
        return masterProducts;
    }
    
}
