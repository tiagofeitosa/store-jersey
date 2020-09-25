package br.com.tgf.store.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	
	public static String getProperty(String file, String key) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
	    prop.load(input);
		return prop.getProperty(key);
	}
}
