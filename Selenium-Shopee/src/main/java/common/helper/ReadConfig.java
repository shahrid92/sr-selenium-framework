package common.helper;
import common.properties.readPropertiesFile;

import java.util.Properties;

public class ReadConfig {

    private Properties p;
    private String url;
    private String browserDriver,browserDriverPath;
    private String headlessArgs,disableGpuArgs,maxWindowsArgs;

    public ReadConfig(String browser) {
        switch (browser) {
            case "chrome":
                url = readPropertiesFile.Property().getProperty("targetUrl");
                browserDriver = readPropertiesFile.Property().getProperty("driver.chrome");
                browserDriverPath = readPropertiesFile.Property().getProperty("driver.chrome.path");
                headlessArgs = readPropertiesFile.Property().getProperty("chrome.options.headless");
                disableGpuArgs = readPropertiesFile.Property().getProperty("chrome.options.gpu");
                maxWindowsArgs = readPropertiesFile.Property().getProperty("chrome.options.windows");
                break;

            case "firefox":
                break;

            case "IE":
                break;

            default:
                break;
        }
    }

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
}
