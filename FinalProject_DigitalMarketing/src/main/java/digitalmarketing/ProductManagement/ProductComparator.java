/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalmarketing.ProductManagement;

import java.util.Comparator;

/**
 *
 * @author alelashvili
 */
public class ProductComparator implements Comparator<Product>{

    int compareOptions;

    public ProductComparator(int compareOptions) { // 0 - floorprice, 1 - alphabetically
        this.compareOptions = compareOptions;
    }

    @Override
    public int compare(Product o1, Product o2) {

        if (compareOptions == 0) {
            return (-1) * Integer.compare(o1.getTargetPrice(), o2.getTargetPrice());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
