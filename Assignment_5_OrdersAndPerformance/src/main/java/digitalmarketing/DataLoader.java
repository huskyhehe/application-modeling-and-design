/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalmarketing;

import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.Personnel.Person;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author HeZhou
 */
public class DataLoader {
    
    Faker faker;
    
    
    public DataLoader(){
        faker = new Faker();
    }
    
    public void populateBusiness(Business b, int supplierCount, int customerCount){
       populateSupplierDirectory(b.getSupplierDirectory(), supplierCount);
       populateCustomerDirectory(b.getCustomerDirectory(), customerCount);
       // add products: pickSupplierToAddProducts
       // add orders: pickCustomersToAddOrders
       // add      
       }
    
    
    // New!
    public void pickSuppliersToAddProducts(Business b, int pickedSupplierCount, int productPerSupplier) {
        ArrayList pickedSupplierList = createRandomList(b.getSupplierDirectory().getSuppliers(), pickedSupplierCount);
        for (int i = 0; i < pickedSupplierCount; i++) {
            Supplier s = (Supplier) pickedSupplierList.get(i);
            populateProductCatalog(b, s, productPerSupplier); 
        }
    }
        
    
    public void populateSupplierDirectory(SupplierDirectory sd, int count){
        for (int i=0; i<count; i++){
            String supplierName = faker.company().name();
            String departmentName = faker.commerce().department();
            sd.newSupplier(supplierName, departmentName);
        }
    }
    
    public void populateCustomerDirectory(CustomerDirectory cd, int count){
        for (int i=0; i<count; i++){
            String customerName = faker.name().fullName();
            cd.newCustomerProfile(new Person(customerName));
        }
    }
    
    
    // New!
    public void populateProductCatalog(Business b, Supplier s, int productCount) {            
        
        ProductCatalog pc = s.getProductcatalog();
        
        for (int i = 0; i < productCount; i++) {
            
            int floorPrice = getRandomPrice(70,90);
            int ceilingPrice = getRandomPrice(110,130);
            int targetPrice = getRandomPrice(90,110);
        
            String productName = faker.commerce().productName();
            Product newProduct = pc.newProduct(floorPrice, ceilingPrice, targetPrice, productName);
            b.getMasterProductList().add(newProduct);
        }   
    }
    
    
    
    // New!
    public void pickCustomersToAddOrders(Business b, int pickedCustomerCount, int orderPerCustomer, int itemPerOrder) {
        ArrayList pickedCustomerList = createRandomList(b.getCustomerDirectory().getCustomerlist(), pickedCustomerCount);
                
        for (int i = 0; i < pickedCustomerCount; i++) {
            CustomerProfile cp = (CustomerProfile) pickedCustomerList.get(i);
            
            for (int j = 0; j < orderPerCustomer; j++) {
                Order order = new Order(cp);
                ArrayList pickedProductList = createRandomList(b.getMasterProductList(), itemPerOrder);
                
                for (int k = 0; k < itemPerOrder; k++) {
                    Product selectedProduct = (Product) pickedProductList.get(k);
                    int acturalPrice = getRandomPrice(100,130);   
                    Random random = new Random();
                    int quantity =  random.nextInt(5)+ 1;
                    
                    order.newOrderItem(selectedProduct, quantity, acturalPrice);                    
                }
                b.getMasterorderlist().getOrders().add(order);
            }
        }  
    }
 
        
    
    
    public int getRandomPrice(int lower, int upper){
        if (lower > upper) return 0;
        Random random = new Random();
        int result = 0;
        result = lower + random.nextInt(upper - lower);
        return result;
    }
    
    
    
   
    // New!
    public static ArrayList createRandomList(ArrayList arr, int n) {
        HashMap map = new HashMap();
        ArrayList arrNew = new ArrayList();
        if (arr.size() <= n) return arr;
        else {
            while (map.size() < n) {
                int random = (int) (Math.random() * arr.size());
                if (!map.containsKey(random)) {
                    map.put(random, arr.get(random));
                    arrNew.add(arr.get(random));
                }
            }
            return arrNew;
        }
    }

    
}
