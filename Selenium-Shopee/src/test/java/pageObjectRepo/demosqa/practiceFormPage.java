package pageObjectRepo.demosqa;

import org.openqa.selenium.WebDriver;
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
            case "Male" : genderRadioButtonMale.click();
                break;
            case "Female" : genderRadioButtonFemale.click();
                break;
            case "Other" : genderRadioButtonOther.click();
                break;
        }
        return this;
    }

    public practiceFormPage enterMobileNumber(String mobileNumber){
        studentNumber.sendKeys(mobileNumber);
        return this;
    }

    public practiceFormPage enterDateOfBirth(String dob){
        inputDOB.sendKeys(dob);
        return this;
    }

    public practiceFormPage enterEmail(String studentEmail){
        userEmail.sendKeys(studentEmail);
        return this;
    }

    public practiceFormPage enterSubject(String subjects){
        inputSubject.sendKeys(subjects);
        return this;
    }

    public practiceFormPage enterHobbies(String hobbies){
        switch(hobbies){
            case "Sports" : cbHobbiesSports.click();
                break;
            case "Music" : cbHobbiesMusic.click();
                break;
            case "Reading" : cbHobbiesReading.click();
                break;
        }
        return this;
    }

    public practiceFormPage enterAddress(String address){
        areaAddress.sendKeys(address);
        return this;
    }

}
