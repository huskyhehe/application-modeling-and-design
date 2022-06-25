package digitalmarketing.CustomerManagement;

import java.util.Comparator;

/**
 *
 * @author alelashvili
 */
public class CustomerComparator implements Comparator<CustomerProfile> {

    @Override
    public int compare(CustomerProfile o1, CustomerProfile o2) {
        return o1.getId().compareTo(o2.getId());
    }
    
}
