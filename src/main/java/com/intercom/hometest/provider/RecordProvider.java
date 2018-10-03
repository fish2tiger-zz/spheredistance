package com.intercom.hometest.provider;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The RecordProvider class is responsible for loading record from local or remote
 * through the given path and urls.
 */
public class RecordProvider {
    private static final Logger logger = LogManager.getLogger(RecordProvider.class);

    /**
     * Deserialization from file or resource to concrete Model objects
     *
     * @param recordLoc valid file location(path or Url) is acceptable
     * @param type      Model class type
     * @param <T>       Generic Type
     * @return concrete model objects in a list
     */
    public static <T> List<T> loadData(String recordLoc, Class<T> type) {
        try {
            URL fileUrl = new URL(recordLoc);
            return loadDataFromUrl(fileUrl, type);
        } catch (MalformedURLException e) {
            return loadDataFromFile(recordLoc, type);
        }
    }

    /**
     * Load Data from file path
     *
     * @param path valid file path (absolute path or file on resources)
     * @param type Model class type
     * @param <T>  Generic Type
     * @return concrete model objects in a list
     */
    private static <T> List<T> loadDataFromFile(final String path, final Class<T> type) {
        final List<T> records = new ArrayList<>();
        try {
            Path filePath = null;
            if (Files.exists(Paths.get(path))) {
                logger.info("Loading records from filepath: " + path);
                filePath = Paths.get(path);
            } else {
                URL fileUrl = RecordProvider.class.getClassLoader().getResource(path);
                if (fileUrl == null || !Files.exists(Paths.get(fileUrl.toURI()))) {
                    logger.error("File: " + path + " doesn't exist");
                } else {
                    logger.info("loading record from classpath");
                    filePath = Paths.get(fileUrl.getPath());
                }
            }
            if (filePath != null) {
                Files.lines(filePath).forEach(line -> {
                    Gson gson = new Gson();
                    records.add(gson.fromJson(line, type));
                });
            }

        } catch (IOException | URISyntaxException e1) {
            logger.error("Failed to load in customer data from: " + path);
        }
        return records;
    }

    /**
     * Load Data from url
     *
     * @param url  valid url
     * @param type Model class type
     * @param <T>  Generic Type
     * @return concrete model objects in a list
     */
    private static <T> List<T> loadDataFromUrl(URL url, Class<T> type) {
        logger.info("Loading customer records in url: " + url);
        List<T> records = new ArrayList<>();
        try {
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                T record = gson.fromJson(line, type);
                records.add(record);
            }
            bufferedReader.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return records;
    }
}
