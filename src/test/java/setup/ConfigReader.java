package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties properties;
	//public final String propertyFilePath= "EventManagementAutomation/src/main/resources/config/config.properties";
	public final String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

	public ConfigReader() {
	     
	    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public String getBrowserName() {
	
		String browsername = properties.getProperty("browser");
		if(browsername!= null) {
		    return browsername;
		}
		return "";
	}
	
	
	public String getBookingUrl() {
	    
	    String url = properties.getProperty("bookingUrl");
		if(url != null) {
		    return url;
		}
		return "";
	}
	
	public String getContactUsUrl() {
	    
	    String contacturl = properties.getProperty("contactUrl");
		if(contacturl != null) {
		    return contacturl;
		}
		return "";
	}
	
	public String getDriverName() {
	    
	    String name = properties.getProperty("drivername");
		if(name != null) {
		    return name;
		}
		return "";
	}

	public String getDriverPath() {
    
    String path = properties.getProperty("driverpath");
	if(path != null) {
	    return path;
	}
	return "";
}
}