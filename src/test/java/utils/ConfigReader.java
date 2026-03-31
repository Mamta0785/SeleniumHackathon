package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static synchronized Properties initializeProperties() {
        if (prop == null) {
            prop = new Properties();
            try (InputStream input = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties")) {

                if (input == null) {
                    throw new RuntimeException("config.properties not found in classpath");
                }

                prop.load(input);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        return initializeProperties().getProperty(key);
    }
}
