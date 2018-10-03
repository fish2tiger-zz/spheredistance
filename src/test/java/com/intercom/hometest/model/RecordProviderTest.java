package com.intercom.hometest.model;

import com.intercom.hometest.provider.RecordProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecordProviderTest {

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = {
            "customers.txt",
            "https://s3.amazonaws.com/intercom-take-home-test/customers.txt"
    })
    public void testDataLoading(String path) {
        assertEquals(RecordProvider.loadData(path, CustomerRecord.class).size(), 32);
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = {
            "abcdefg.hijklmn",
            "https://where.is.the.data"
    })
    public void testDataLoadingFromNonExistings(String path) {
        assertEquals(RecordProvider.loadData(path, CustomerRecord.class).size(), 0);
    }
}
