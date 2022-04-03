package cucumber.stepdefinition;

import BaseClass.TestBase;
import io.cucumber.java.en.*;
import pageObjectRepo.demosqa.practiceFormPage;

public class demo_StudentRegisterForm extends TestBase {


    @Given("^user at student registration form page$")
    public void user_at_student_registration_form_page() {
        this.mainDriver("chrome",null,"demosqa.properties");
    }
    @When("^user enter \"(.*?)\" in firstname field$")
    public void user_firstname(String firstname) {

        new practiceFormPage(driver)
                .enterFirstName(firstname);

    }
    @And("^user enter \"(.*?)\" in last name field$")
    public void user_lastname(String lastname) {
        new practiceFormPage(driver)
                .enterLastName(lastname);

    }
    @And("^user enter \"(.*?)\" in email field$")
    public void user_email(String email) {
        new practiceFormPage(driver)
                .enterEmail(email);

    }
    @Then("^user select \"(.*?)\" in gender radio button$")
    public void user_gender(String gender) {
        new practiceFormPage(driver)
                .enterGender(gender);
    }
    @And("enter \"(.*?)\" in mobile number field$")
    public void user_mobilenumber(String mobilenumber) {
        new practiceFormPage(driver)
                .enterMobileNumber(mobilenumber);

    }
    @And("^enter \"(.*?)\" in date of birth field$")
    public void user_dob(String dob) {
        new practiceFormPage(driver)
                .enterDateOfBirth(dob);

    }
    @And("^enter \"(.*?)\" in subject field$")
    public void user_subject(String subject) {
        new practiceFormPage(driver)
                .enterSubject(subject);

    }
    @And("^select \"(.*?)\" in hobbies radio button$")
    public void user_hobbies(String hobbies) {
        new practiceFormPage(driver)
                .enterHobbies(hobbies);

    }
    @And("^enter \"(.*?)\" in address field$")
    public void user_address(String address) {
        new practiceFormPage(driver)
                .enterAddress(address);

    }
    @And("^select \"(.*?)\" in state field$")
    public void user_state(String state) {
        new practiceFormPage(driver)
                .enterState(state);

    }
    @And("^select \"(.*?)\" in city field$")
    public void user_city(String city) {
        new practiceFormPage(driver)
                .enterCity(city);
    }
    @Then("^user click submit button$")
    public void user_click_submit_button() {
        System.out.println("User click button");
        driver.close();
        driver.quit();
    }

}
