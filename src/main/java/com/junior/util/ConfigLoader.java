package com.junior.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private Properties properties = null;
	private static ConfigLoader configLoader = null;
	private String proFileName = "config.properties";
	private ConfigLoader() {
		InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(proFileName);
		
		if(inputStream != null) {
			properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ConfigLoader getInstance() {
		if(configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getValue(String key) {
		if(properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return null;
	}
}
