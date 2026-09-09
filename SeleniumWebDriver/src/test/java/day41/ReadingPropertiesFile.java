package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//location of property File
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Config.properties");
		
		//Loading property file
		Properties propertiesObj = new Properties();
		propertiesObj.load(file);
		
		//Reading data from property file
		String url = propertiesObj.getProperty("url");
		String email = propertiesObj.getProperty("email");
		String pass = propertiesObj.getProperty("password");
		String cId = propertiesObj.getProperty("customerId");
		
		System.out.println(url);
		System.out.println(email);
		System.out.println(pass);
		System.out.println(cId);
		
		//Reading all keys using two ways
		Set<String> keys = propertiesObj.stringPropertyNames();
		System.out.println(keys);
		
		Set<Object> keyss= propertiesObj.keySet();
		System.out.println(keyss);
		
		//Reading all values
		Collection<Object> values = propertiesObj.values();
		System.out.println(values);
		
		file.close();
		
	}
}
