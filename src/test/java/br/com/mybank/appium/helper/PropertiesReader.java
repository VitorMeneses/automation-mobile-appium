package br.com.mybank.appium.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//builder for reading data from a properties file
public class PropertiesReader {

	String baseFilePath;
	String fileName;
	
	public PropertiesReader(String fileName) {
		baseFilePath = System.getProperty("user.dir") + "/src/test/resources/properties/";
		this.fileName = baseFilePath + fileName + ".properties";
	}
	
	public String read(String property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(fileName);

			prop.load(input);
			
			return prop.getProperty(property);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}