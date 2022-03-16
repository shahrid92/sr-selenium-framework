package cucumber.stepdefinition;

import BaseClass.TestBase;
import io.cucumber.java.en.Given;

public class backgroundStep extends TestBase {

    @Given("^User visit homepage$")
    public void user_visit_homepage() {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("user visit homepage");
    }

}
