package common.driver;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class TargetFactory {

    private static final Logger log = LogManager.getLogger(TargetFactory.class);

    public WebDriver createDriver(String browser){
        Target target = Target.valueOf("LOCAL");
        WebDriver driver;

        switch(target){
            case LOCAL:

                break;
            case REMOTE:
                break;
        }

        return driver;
    }

    enum Target{
        LOCAL, REMOTE
    }


}
