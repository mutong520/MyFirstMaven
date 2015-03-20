package com.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	
	public static String getProperties(String key) {
		String result = "";
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath()+"config/config.properties";
		
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream (new FileInputStream(path));
			props.load(in);
			result = props.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
