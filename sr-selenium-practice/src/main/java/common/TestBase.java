package common;

import common.utilities.ReadConfigFile;
import common.utilities.ScenarioContext;
import common.utilities.TestEnum;

import common.utilities.listener.actionListener;
import listener.ListenerTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import com.github.javafaker.Faker;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static common.utilities.TestEnum.*;


@Listeners({ListenerTest.class,actionListener.class})

public class TestBase {

    protected Faker faker;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static long  globalTimestamp;
    public ScenarioContext scenarioContext = new ScenarioContext();

    public void setupBrowser()  {
        ChromeOptions options;
        ReadConfigFile prop = new ReadConfigFile();
        TestEnum browser = TestEnum.valueOf(prop.getProperties(BROWSER));
        String baseUri = prop.getProperties(BASEURL);
        boolean isParallel = Boolean.valueOf(prop.getProperties(PARALLEL_REMOTE));
        boolean isRemote = Boolean.valueOf(prop.getProperties(BROWSER_REMOTE));
        this.faker = new Faker();
        switch (browser) {
            case CHROME:
                options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                if(isParallel){
                    try{
                        driver.set(new RemoteWebDriver(new URL(prop.getProperties(BROWSER_REMOTE_URL)), options));
                        System.out.println("Active Thread :" + Thread.currentThread().getId());
                    }catch (Exception es){
                        System.out.println(es.getMessage());
                    }
                }else{
                      if(isRemote){
                          try{
                              driver.set(new RemoteWebDriver(new URL(prop.getProperties(BROWSER_REMOTE_URL)), options));
                              System.out.println("Active Thread :" + Thread.currentThread().getId());
                          }catch (Exception es){
                              System.out.println(es.getMessage());
                          }
                      }else{
                          driver.set(new ChromeDriver(options));
                      }
//                    options.addArguments("--headless=new");
//                    options.setBrowserVersion("119.0.6045.106");
//                    options.setCapability("browserVersion", "119.0.6045.106");
                }


                createNewFolder();
                break;
            case FIREFOX:
                break;
            case EDGE:
                break;

            default:
                throw new IllegalArgumentException("No browser was selected.");

        }

      //  webDriverListener wdl = new webDriverListener(drivers.get());
     //  EventFiringDecorator<WebDriver> d = new EventFiringDecorator<>(wdl);

     //   this.driver = d.decorate(drivers.get());
        this.driver.get().manage().window().maximize();
        this.driver.get().get(baseUri);

    }

    protected void tearDown() {
        if (driver != null)
        {
            try
            {
                driver.get().quit();
            }
            catch (WebDriverException e) {
                System.out.println("***** CAUGHT WEBDRIVEREXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }

        }
    }

    public static void createNewFolder(){
        globalTimestamp = System.currentTimeMillis();
    }

    //TODO: js execute, cucumber, rest assured,, allure/extent report, sql, paramatization
    //TODO: https://www.youtube.com/watch?v=w9sfxQH62Yo&ab_channel=SaravananSeenivasan
    //TODO: add more test cases
    //TODO: share context are not working when passing parameter to another scenario outline. new states are created.
}
