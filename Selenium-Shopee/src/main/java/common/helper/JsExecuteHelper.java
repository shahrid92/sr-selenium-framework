package common.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void clickElement(List<WebElement> shadowRootElement){
        String jss = "return arguments[0].shadowRoot.querySelector('.shopee-popup__close-btn').click()";
        js.executeScript(jss, shadowRootElement.get(0));
    }


}
