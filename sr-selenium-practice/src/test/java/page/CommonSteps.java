package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.google.common.truth.Truth.assertWithMessage;
public class CommonSteps extends PageObject {
    public CommonSteps(WebDriver driver){
        super(driver);
    }

    public CommonSteps clickByText(String text){

        long startTime = System.currentTimeMillis();

        Boolean found = false;
      do{
          long elapsedTime = System.currentTimeMillis() - startTime;

          try{
              WebElement e = driver.findElement(By.xpath("//*[text()[contains(.,'"+text+"')]]"));
              wait.until(ExpectedConditions.visibilityOf(e)).click();
              break;
          }catch (Exception ex){
              System.out.println("/rclickByText("+elapsedTime+"ms) : Text \""+text+"\" not exists yet!");
          }

          //TODO - elapsed time need to config file
          if (elapsedTime >= 15000) {
              System.out.println("clickByText("+elapsedTime+"ms) : Searching Text \""+text+"\" reach timeout!");
              assertWithMessage("Text \""+text+"\" not found!").that(found).isTrue();
              break;
          }

      }while(true);

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
                    System.out.println("/rverifyPageText("+elapsedTime+"ms) : Text \""+text+"\" not exists yet!");
                }

                if(found){
                    break;
                }
                //TODO - elapsed time need to config file
                if (elapsedTime >= 15000) {
                    System.out.println("verifyPageText("+elapsedTime+"ms) : Searching Text \""+text+"\" reach timeout!");
                    assertWithMessage("Text \""+text+"\" not found!").that(found).isTrue();
                    break;
                }

            }
            while(true);

            return this;
        }

}
