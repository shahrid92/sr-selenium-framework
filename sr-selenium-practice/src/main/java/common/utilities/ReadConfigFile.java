package common.utilities;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static common.utilities.TestEnum.*;

public class ReadConfigFile {

    static String configPath = System.getProperty(APP_CONFIG.toString());
    static Properties prop = new Properties();
    public String getProperties(TestEnum attr){
        Path path = Paths.get(configPath + "/src/test/resources/app.properties");
        try(InputStream input = Files.newInputStream(path)){
            prop.load(input);
            return prop.getProperty(attr.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Get properties values executed." + attr);
        }
        System.out.println("something is not right...");
        return null;
    }

}
