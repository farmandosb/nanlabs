package spacex.nanlabs.recruitment.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public final class PropertiesReader {


	    /**
	     * Constant LOGGER.
	     */
	    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);

	    /**
	     * Constant PROPERTIES.
	     */
	    private static final Properties PROPERTIES;

	    /**
	     * Constant PROP_FILE.
	     */
	    private static final String PROP_FILE = "apikey.properties";

	    /**
	     * Default private constructor PropertiesReader.
	     */
	    private PropertiesReader() {
	    }

	    static {
	        PROPERTIES = new Properties();
	        final URL props;
			try {
				props = propertiesClassPathResource(PROP_FILE).getURL();
				try {
					PROPERTIES.load(props.openStream());
				} catch (IOException ex) {

					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(ex.getClass().getName() + "AditionalPropertiesReader method");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

		public static Resource propertiesClassPathResource(String path) {
			return new ClassPathResource(path);
		}

	   /**
	 * Method getProperty.
	 *
	 * @param name String name file.
	 * @return Return property
	 */
	public static String getProperty(final String name) {

	    return PROPERTIES.getProperty(name);
	}
}