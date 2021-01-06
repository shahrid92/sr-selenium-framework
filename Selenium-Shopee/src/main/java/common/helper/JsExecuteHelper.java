package common.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsExecuteHelper {

    protected JavascriptExecutor js;

    public JsExecuteHelper(WebDriver driver){
        js = (JavascriptExecutor) driver;
    }

    public void scrollPageDown(int executeScroll,int scrollLeftRight,int scrollUpDown){
        for(int i=0;i < executeScroll;i++ ){
            js.executeScript("window.scrollBy("+scrollLeftRight+","+scrollUpDown+")");
        }
    }
}
