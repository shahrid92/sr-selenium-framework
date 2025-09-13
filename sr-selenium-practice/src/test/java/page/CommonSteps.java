package page;

import common.utilities.ReadConfigFile;
import common.utilities.TestEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.google.common.truth.Truth.assertWithMessage;
import static common.utilities.TestEnum.ELEMENTS_TIMEOUT;

public class CommonSteps extends PageObject {

    ReadConfigFile prop = new ReadConfigFile();

    public CommonSteps(WebDriver driver){
        super(driver);
    }

    public CommonSteps clickByText(String text){

        clickByTextSearchElements(text,null);

        return this;
    }

    public CommonSteps clickByText(String text,String path){

        By e = null;

        switch (text){
            case "XPATH" :
                e = By.xpath(path);
                break;
            case "CSS" :
                e = By.cssSelector(path);
                break;
            default:
                System.out.println("Supplies text or XPATH or CSSPATH");
                break;
        }

        clickByTextSearchElements(null,e);

        return this;
    }

    public CommonSteps verifyPageText(String text){

        long startTime = System.currentTimeMillis();

        Boolean found = false;

            do{
                long elapsedTime = System.currentTimeMillis() - startTime;

                try{
                    WebElement e = driver.findElement(By.xpath("//*[text()[contains(.,'"+text+"')]]"));
                    wait.until(ExpectedConditions.visibilityOf(e));
                    assertWithMessage("Text "+text+" not found!").that(e.isDisplayed()).isTrue();
                    found = true;
                    System.out.println("Text "+text+" Found in "+elapsedTime+"ms!");
                }catch (Exception ex){
                    System.out.println("verifyPageText("+elapsedTime+"ms) : Text \""+text+"\" not exists yet!");
                }

                if(found) break;

                //TODO - elapsed time need to config file
                if (elapsedTime >= Integer.valueOf(prop.getProperties(ELEMENTS_TIMEOUT))) {
                    System.out.println("verifyPageText("+elapsedTime+"ms) : Searching Text \""+text+"\" reach timeout!");
                    assertWithMessage("Text \""+text+"\" not found!").that(found).isTrue();
                    break;
                }

            }
            while(true);

            return this;
        }

        private void clickByTextSearchElements(String text,By we){

            long startTime = System.currentTimeMillis();

            Boolean found = false;
            WebElement e;
            do{
                long elapsedTime = System.currentTimeMillis() - startTime;

                try{
                    if(we == null){
                        e = driver.findElement(By.xpath("//*[text()[contains(.,'"+text+"')]]"));
                    }else{
                         e = driver.findElement(we);
                    }

                    wait.until(ExpectedConditions.visibilityOf(e)).click();
                    break;
                }catch (Exception ex){
                    System.out.println("/rclickByText("+elapsedTime+"ms) : Text \""+text+"\" not exists yet!");
                }

                //TODO - elapsed time need to config file
                if (elapsedTime >= Integer.valueOf(prop.getProperties(ELEMENTS_TIMEOUT))) {
                    System.out.println("clickByText("+elapsedTime+"ms) : Searching Text \""+text+"\" reach timeout!");
                    assertWithMessage("Text \""+text+"\" not found!").that(found).isTrue();
                    break;
                }

            }while(true);
        }

}
