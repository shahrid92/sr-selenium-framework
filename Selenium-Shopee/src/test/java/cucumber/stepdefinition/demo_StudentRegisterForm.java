package cucumber.stepdefinition;

import io.cucumber.java.en.*;

public class demo_StudentRegisterForm {

    @Given("user at student registration form page")
    public void user_at_student_registration_form_page() {
        System.out.println("Test");

    }
    @When("user enter John")
    public void user_enter_john() {
        System.out.println("Test");

    }
    @And("user enter Toretto")
    public void user_enter_toretto() {
        System.out.println("Test");

    }
    @And("user enter jt@gmail.com")
    public void user_enter_jt_gmail_com() {
        System.out.println("Test");

    }
    @Then("user select Male")
    public void user_select_male() {
        System.out.println("Test");

    }
    @And("enter {int}")
    public void enter(Integer int1) {
        System.out.println("Test");

    }
    @And("enter {int} Feb {int}")
    public void enter_feb(Integer int1, Integer int2) {
        System.out.println("Test");

    }
    @And("enter Cloud Testing")
    public void enter_cloud_testing() {
        System.out.println("Test");

    }
    @And("select <hobbies>")
    public void select_hobbies() {
        System.out.println("Test");

    }
    @And("enter Kuala Lumpur")
    public void enter_kuala_lumpur() {
        System.out.println("Test");

    }
    @And("select Selangor")
    public void select_selangor() {
        System.out.println("Test");

    }
    @And("select Gombak")
    public void select_gombak() {
        System.out.println("Test");

    }
    @Then("user click submit button")
    public void user_click_submit_button() {
        System.out.println("Test");

    }

}
