import com.intercom.hometest.model.CustomerRecord;
import com.intercom.hometest.model.Location;
import com.intercom.hometest.provider.RecordProvider;
import com.intercom.hometest.util.CustomerRangeSearch;

import java.util.List;

/**
 * The IntercomHomeTest class is the entry point for running the search
 * to find customers within distance of 100km to the Intercom Dublin office.
 */
public class IntercomHomeTest {

    private static final String customerDataUrl = "https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
    private static final double intercom_x = 53.339428;
    private static final double intercom_y = -6.257664;
    private static final double range = 100;

    public static void main(String[] args) {
        List<CustomerRecord> records = RecordProvider.loadData(customerDataUrl, CustomerRecord.class);
        Location intercomDublinOffice = new Location(intercom_x, intercom_y);
        CustomerRangeSearch.printCustomerInfoInRange(range, intercomDublinOffice, records);
    }
}
