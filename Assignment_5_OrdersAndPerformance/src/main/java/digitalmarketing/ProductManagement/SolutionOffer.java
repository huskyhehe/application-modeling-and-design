/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.ProductManagement;

import java.util.ArrayList;
import digitalmarketing.MarketModel.Market;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;
    Market market;
    public SolutionOffer(Market m){
        market = m;
        products = new ArrayList();
    }
    
    public void addProduct(Product p){
        products.add(p);
    }
    public void setPrice(int p){
        price = p;
        
    }
    
}
