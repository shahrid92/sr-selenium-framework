package common.properties;

import java.io.*;
import java.util.Properties;

public class readPropertiesFile {
    public static Properties Property(){
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
