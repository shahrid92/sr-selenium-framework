package common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver_Test{
    WebDriver driver;
    ChromeOptions options;

    public void setWebdriver(String propterty1,String path,String args){
        System.setProperty(propterty1,path);
        ChromeOptions optionss = new ChromeOptions();
        this.options = optionss.addArguments(args);
    }

    public WebDriver getDriver(){
        this.driver = new ChromeDriver(options);
        return driver;
    }

}
