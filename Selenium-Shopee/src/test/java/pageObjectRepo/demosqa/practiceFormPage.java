package pageObjectRepo.demosqa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjectRepo.PageObject;

public class practiceFormPage extends PageObject {


    public practiceFormPage(WebDriver driver){
        super(driver);
    }

    public practiceFormPage enterFirstName(String firstname){
        studentFirstName.sendKeys(firstname);
        return this;

    }

    public practiceFormPage enterLastName(String lastName){
        studentLastName.sendKeys(lastName);
        return this;
    }

    public practiceFormPage enterGender(String gender){

        switch(gender){
            case "Male" : genderRadioButtonMale.get(0).click();
                break;
            case "Female" : genderRadioButtonFemale.get(0).click();
                break;
            case "Other" : genderRadioButtonOther.get(0).click();
                break;
        }
        return this;
    }

    public practiceFormPage enterMobileNumber(String mobileNumber){
        studentNumber.sendKeys(mobileNumber);
        return this;
    }

    public practiceFormPage enterDateOfBirth(String dob){
        
        inputDOB.get(0).sendKeys(dob);
        inputDOB.get(0).sendKeys(Keys.RETURN);
        return this;
    }

    public practiceFormPage enterEmail(String studentEmail){
        userEmail.sendKeys(studentEmail);
        return this;
    }

    public practiceFormPage enterSubject(String subjects){
        inputSubject.sendKeys(subjects);
        inputSubject.sendKeys(Keys.RETURN);
        return this;
    }

    public practiceFormPage enterHobbies(String hobbies){
        switch(hobbies){
            case "Sports" : cbHobbiesSports.get(0).click();
                break;
            case "Music" : cbHobbiesMusic.get(0).click();
                break;
            case "Reading" : cbHobbiesReading.get(0).click();
                break;
        }
        return this;
    }

    public practiceFormPage enterAddress(String address){
        areaAddress.sendKeys(address);
        return this;
    }

    public practiceFormPage enterState(String state){

        wait.until(ExpectedConditions.elementToBeClickable(selectState));

        selectState.sendKeys(state);
        selectState.sendKeys(Keys.RETURN);
        return this;
    }

    public practiceFormPage enterCity(String city){
        wait.until(ExpectedConditions.elementToBeClickable(selectCity));
        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.RETURN);
        return this;
    }

    public practiceFormPage clickSubmit(){

        return this;
    }

}
