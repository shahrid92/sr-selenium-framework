package cucumber.stepdefinition;

import BaseClass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class demoBackgroundStepDefinition extends TestBase {


    @Given("^User enter full name$")
    public void user_enter_full_name() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user enter fullname");
    }

    @Given("^User enter email$")
    public void user_enter_email() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user enter email");
    }

    @Then("^User click submit button$")
    public void user_click_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user click button");

    }

}
