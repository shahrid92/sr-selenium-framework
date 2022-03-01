package cucumber.stepdefinition;

import BaseClass.TestBase;
import io.cucumber.java.en.*;

public class demo_test {

    @Given("^this is given step$")
    public void this_is_given_step() {
        System.out.println("Test1");
    }
    @When("this is when step")
    public void this_is_when_step() {
        System.out.println("Test2");
    }
    @And("this is and step")
    public void this_is_and_step() {
        System.out.println("Test3");
    }
    @Then("this is then step")
    public void this_is_then_step() {
        System.out.println("Test4");
    }

}
