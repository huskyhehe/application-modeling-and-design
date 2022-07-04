/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalmarketing.CustomerManagement;

import java.util.Comparator;

/**
 *
 * @author alelashvili
 */
public class CustomerComparator implements Comparator<CustomerProfile> {

    @Override
    public int compare(CustomerProfile o1, CustomerProfile o2) {
        // -1, 0, 1
        // return (-1) * o1.getName().compareTo(o2.getName());
        return o1.getName().compareTo(o2.getName());
    }
    
}
