package by.bsuir.autoservice.manager;

import java.util.ResourceBundle;

public class PropertiesManager {

	public static String getProperty(String bundle, String key) {
		return ResourceBundle.getBundle(bundle).getString(key);
	}
}
