package cucumber.stepdefinition;

import BaseClass.TestBase;
import io.cucumber.java.en.*;

public class demo_test extends TestBase {

    @Given("^this is given step$")
    public void this_is_given_step() {
        this.mainDriver("chrome",null,"demosqa.properties");
    }
    @When("this is when step")
    public void this_is_when_step() {
        System.out.println("Test2");
    }
    @And("this is and step")
    public void this_is_and_step() {
        System.out.println("Test3");
    }
    @And("^this is (test step)$")
    public void this_is_test_step(String step) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       System.out.println(step);
    }
    @Then("this is then step")
    public void this_is_then_step() {

        System.out.println("Test4");

        driver.close();
        driver.quit();
    }

}
