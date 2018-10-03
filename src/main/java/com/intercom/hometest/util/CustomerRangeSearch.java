package com.intercom.hometest.util;

import com.intercom.hometest.model.CustomerRecord;
import com.intercom.hometest.model.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The CustomerRangeSearch class searches the customers within the range and prints all
 * the customers who are within the range in ascending order by the user id.
 */
public class CustomerRangeSearch {
    private static final Logger logger = LogManager.getLogger(CustomerRangeSearch.class);

    private static List<CustomerRecord> findCustomerInRange(double range, Location centroid, List<CustomerRecord> records) {
        return records.stream()
                .filter(rec -> SphereDistanceCalculator.isWithinRange(range, rec.getLocation(), centroid))
                .collect(Collectors.toList());
    }

    public static void printCustomerInfoInRange(double range, Location centroid, List<CustomerRecord> records) {
        logger.info("============================================================================");
        logger.info("Printing customer records within the range: " + range + " km " + ", around center: " + centroid);
        List<CustomerRecord> recordsInRange = findCustomerInRange(range, centroid, records);
        Collections.sort(recordsInRange);
        IntStream.range(0, recordsInRange.size()).forEach(index ->
                logger.info(index + " : " + recordsInRange.get(index))
        );
        logger.info("============================================================================");
    }
}
