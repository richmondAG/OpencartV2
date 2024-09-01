package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop = new Properties();



	public static void loadProperties() {
		try (FileInputStream fil = new FileInputStream("src/test/resources/config.properties")) {
			prop.load(fil);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getproperty(String key) {
		return prop.getProperty(key);
	}

}

//try(InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) 
//{ if (input == null) {
//    System.out.println("Sorry, unable to find config.properties");
//    return;
//}
//prop.load(input);
//}
//catch(IOException ex) {
//	 ex.printStackTrace();
//	
//}
//
