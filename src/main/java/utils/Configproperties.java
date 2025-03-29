package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configproperties {

	static String filepath = "C:\\Users\\heman\\eclipse-workspace\\QtrpPlaywrightTest\\src\\test\\resources\\Config.properties";
	private static Properties properties;

	static {
		try {
			FileInputStream file = new FileInputStream(filepath);
			properties = new Properties();
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties");
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
