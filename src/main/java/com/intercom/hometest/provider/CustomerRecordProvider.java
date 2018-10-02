package com.intercom.hometest.provider;

import com.google.gson.Gson;
import com.intercom.hometest.model.CustomerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CustomerRecordProvider {
    protected static final Logger logger = LogManager.getLogger(CustomerRecordProvider.class);

    public static List<CustomerRecord> loadData(String location){
        logger.info("logging information from location: "+ location);
        StringBuilder content = new StringBuilder();
        List<CustomerRecord> records = new ArrayList<>();
        try{

            URL url = new URL(location);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                Gson gson = new Gson();
                CustomerRecord record = gson.fromJson(line, CustomerRecord.class);
                records.add(record);
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (MalformedURLException e){
            logger.error("URL "+ location+ " isn't a valid url which failed to load cstomer record.");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        records.forEach(logger:: info);
        return records;
    }


}
