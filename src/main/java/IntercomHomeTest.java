import com.intercom.hometest.model.CustomerRecord;
import com.intercom.hometest.model.Location;
import com.intercom.hometest.provider.RecordProvider;
import com.intercom.hometest.util.CustomerRangeSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * The IntercomHomeTest class is the entry point for running the search
 * to find customers within distance of 100km to the Intercom Dublin office.
 */
public class IntercomHomeTest {
    private static final Logger logger = LogManager.getLogger(IntercomHomeTest.class);

    private static final double intercom_x = 53.339428;
    private static final double intercom_y = -6.257664;
    private static final double range = 100;
    private static String customerDataUrl = "https://s3.amazonaws.com/intercom-take-home-test/customers.txt";

    public static void main(String[] args) {
        if(args!=null && args.length>0) {
            customerDataUrl = args[0];
        }
        logger.info("Read customer record from: "+ customerDataUrl);
        List<CustomerRecord> records = RecordProvider.loadData(customerDataUrl, CustomerRecord.class);

        Location intercomDublinOffice = new Location(intercom_x, intercom_y);
        logger.info("Search customers with range: "+range+" km to the Intercom Dublin office : "+ intercomDublinOffice);

        CustomerRangeSearch.printCustomerInfoInRange(range, intercomDublinOffice, records);
    }
}
