package common.properties;

import java.io.*;
import java.util.Properties;

public class readPropertiesFile {
    private static String propertiesFile;
    public readPropertiesFile(String p){
        this.propertiesFile = p;
    }
    public static Properties Property(){
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/"+propertiesFile)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
