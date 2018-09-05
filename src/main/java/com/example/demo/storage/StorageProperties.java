package com.example.demo.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties(prefix  = "storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private final String FS = File.separator;
    private String location =
            System.getProperty("user.dir") +
            String.join(FS, FS  + "src", "main", "webapp", "WEB-INF", "images" + FS);

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
