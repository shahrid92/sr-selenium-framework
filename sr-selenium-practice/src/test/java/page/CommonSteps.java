package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Timer;

import static com.google.common.truth.Truth.assertWithMessage;
public class CommonSteps extends PageObject {

    private Timer timer = new Timer();
    private final int interval = 30000; // 30 seconds in milliseconds
    private final long startTime = System.currentTimeMillis();

    public CommonSteps(WebDriver driver){
        super(driver);
    }

    public CommonSteps clickByText(String text){
        Boolean found = false;
      do{
          try{
              WebElement e = driver.findElement(By.xpath("//*[text()[contains(.,'"+text+"')]]"));
              wait.until(ExpectedConditions.visibilityOf(e)).click();
              break;
          }catch (Exception ex){
              System.out.println("Elements not exists yet!");
          }

          if (System.currentTimeMillis() - startTime >= interval) {
              System.out.println("Time's up! Breaking the loop.");
              timer.cancel(); // Stop the timer
              assertWithMessage("Elements not found!").that(false).isTrue();
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
