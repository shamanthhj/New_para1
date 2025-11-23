package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;
	
	public static String getProperty(String key)
	{
		if(prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
				prop.load(fis);
			}catch (IOException e){
				System.out.println("Config not found" + e.getMessage());
			}
		}
		return prop.getProperty(key);
	}
}
