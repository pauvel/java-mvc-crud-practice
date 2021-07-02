package com.pauvel.crudspringboot.Helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ConfigHelper{
    
    private Map<String, String> properties = new HashMap<>();

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getPropertyValue(String key) {
        return this.properties.get(key);
    }

    public ConfigHelper(String lang){
        try {
            this.setProps(lang);
        } catch (Exception e) {
            this.properties = null;
        }
    }

    private void setProps(String lang) throws IOException{
        // Validate if lang exists in validation properties.
        Resource resource = new ClassPathResource("validation"+"_"+lang+".properties");
            Properties loadedProperties = PropertiesLoaderUtils.loadProperties(resource);
            loadedProperties.forEach((key, value) -> {
                properties.put(key.toString(), value.toString());
            });
    }
}