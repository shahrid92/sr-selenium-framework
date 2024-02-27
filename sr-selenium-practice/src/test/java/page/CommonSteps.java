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
        Integer maxLoop = 0;
        Boolean found = false;

            do{
                try{
                    WebElement e = driver.findElement(By.xpath("//*[text()[contains(.,'"+text+"')]]"));
                    wait.until(ExpectedConditions.visibilityOf(e));
                    assertWithMessage("Text "+text+"not found!").that(e.isDisplayed()).isTrue();
                    found = true;
                    System.out.println(text+" Found!");
                }catch (Exception ex){
                    System.out.println("Elements not exists yet!");
                }
                maxLoop++;

                if(found){
                    break;
                }
            }
            while(maxLoop <= 100);

            return this;
        }

}
