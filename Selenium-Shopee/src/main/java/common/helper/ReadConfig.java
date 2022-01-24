package common.helper;
import common.properties.readPropertiesFile;

import java.util.Properties;

public class ReadConfig {

    private Properties p;
    private String url,gridurl,mode;
    private String browserDriver,browserDriverPath;
    private String headlessArgs,disableGpuArgs,maxWindowsArgs;

    public ReadConfig(String browser) {
        url = readPropertiesFile.Property().getProperty("targetUrl");
        gridurl = readPropertiesFile.Property().getProperty("grid.hub.url");
        mode = readPropertiesFile.Property().getProperty("driver.mode");
        switch (browser) {
            case "chrome":
                browserDriver = readPropertiesFile.Property().getProperty("driver.chrome");
                browserDriverPath = readPropertiesFile.Property().getProperty("driver.chrome.path");
                headlessArgs = readPropertiesFile.Property().getProperty("chrome.options.headless");
                disableGpuArgs = readPropertiesFile.Property().getProperty("chrome.options.gpu");
                maxWindowsArgs = readPropertiesFile.Property().getProperty("chrome.options.windows");

                break;

            case "firefox":
                browserDriver = readPropertiesFile.Property().getProperty("driver.firefox");
                browserDriverPath = readPropertiesFile.Property().getProperty("driver.firefox.path");
                headlessArgs = readPropertiesFile.Property().getProperty("firefox.options.headless");
                break;

            case "edge":
                browserDriver = readPropertiesFile.Property().getProperty("driver.edge");
                browserDriverPath = readPropertiesFile.Property().getProperty("driver.edge.path");
                break;

            default:
                break;
        }
    }

    public String getGridurl() { return gridurl; }

    public String getMaxWindowsArgs(){
        return this.maxWindowsArgs;
    }

    public String getDisableGpuArgs(){
        return this.disableGpuArgs;
    }

    public String getHeadlessArgs(){
        return this.headlessArgs;
    }

    public String getBrowserDriverPath(){
        return this.browserDriverPath;
    }

    public String getBrowserDriver(){
        return this.browserDriver;
    }

    public String getUrl(){
        return this.url;
    }

    public String getMode(){return this.mode;}
}
