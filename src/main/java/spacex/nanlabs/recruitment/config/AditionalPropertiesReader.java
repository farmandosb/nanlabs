package spacex.nanlabs.recruitment.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public final class AditionalPropertiesReader {

	/**
	 * Constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AditionalPropertiesReader.class);

	/**
	 * Constant PROPERTIES.
	 */
	private static final Properties ADITIONAL_PROPERTIES;

	/**
	 * Constant PROP_FILE.
	 */
	private static final String PROP_FILE = "aditional.properties";

	/**
	 * Default private constructor PropertiesReader.
	 */
	private AditionalPropertiesReader() {
	}

	static {
		ADITIONAL_PROPERTIES = new Properties();
		//final URL props = ClassLoader.getSystemResource(PROP_FILE);
		final URL props;
		try {
			props = propertiesClassPathResource(PROP_FILE).getURL();
			try {
				ADITIONAL_PROPERTIES.load(props.openStream());
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

		return ADITIONAL_PROPERTIES.getProperty(name);
	}
}