import common.utilities.StepsScreenShot;
import common.utilities.annotation.CustomAnnotation;
import common.utilities.testdata.CSVUtils;
import initTestDriver.TestInit;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AdminPage;
import page.CommonSteps;
import page.LoginPage;
import page.PIMPage;

import java.util.List;

public class TestRun extends TestInit {

    @Before
    public void runTestNG(){
        this.setupDriver();
    }

    @After
    public void teardown() {
        this.tearDown();
    }

    @Test(enabled = true,dataProvider = "userlist")
    @CustomAnnotation(key="T1",value="V1")
    @CustomAnnotation(key="T2",value="V2")
    @Given("Users launch browser and login as {string} and {string}")
    public void UserLoginAndNavigateAdminPages(String user,String pass) throws Exception{
        new LoginPage(driver)
                .LoginAction(user,pass)
                .verifyDashboardTitle();

        new CommonSteps(driver)
                .clickByText("Admin")
                .verifyPageText("System Users");
    }

    @Test(enabled = false)
    @Parameters({"userid", "password"})
    public void CreateUsers(String userid, String password) throws Exception{

        new LoginPage(driver)
                .LoginAction(userid,password);

        new CommonSteps(driver)
                .clickByText("Admin")
                .verifyPageText("System Users")
                .clickByText("Add")
                .verifyPageText("Add User");

        new AdminPage(driver)
                .UserRoleSelection();

        new CommonSteps(driver)
                .clickByText("ESS");

        new AdminPage(driver)
                .StatusSelection();

        new CommonSteps(driver)
                .clickByText("Enabled");

        new AdminPage(driver)
                .EnterEmployeeName("Test01");

    }

    @Then("Navigate admin page and click Add User")
    public void AdminAddNewUsersPage(){
        System.out.println("AdminAddNewUsersPage");

        new CommonSteps(this.driver)
                .clickByText("Admin")
                .verifyPageText("System Users")
                .clickByText("Add")
                .verifyPageText("Add User");
    }

    @Then("Enter new user details and save")
    public void AddNewUsers(){

        new AdminPage(driver)
                .UserRoleSelection();

        new CommonSteps(driver)
                .clickByText("ESS");

        new AdminPage(driver)
                .StatusSelection();

        new CommonSteps(driver)
                .clickByText("Enabled");

        new AdminPage(driver)
                .EnterEmployeeName("Jeffry Jonas Test")
                .EnterUserName("JJTestID1");

        new AdminPage(driver).
                EnterPassword("test123123");

        new CommonSteps(driver).clickByText("Save");
    }

    @Then("Navigate to PIM and click add employee")
    public void AddNewEmployee(){
        new CommonSteps(this.driver)
                .clickByText("PIM")
                .clickByText("Add");
    }

    @And("Fill all new employee names")
    public void EnterEmployeeNames(List<List<String>> employeeData){

        List<String> firstRow = employeeData.get(1);

        System.out.println(employeeData.get(0));

        new PIMPage(this.driver)
                .EnterFirstName(firstRow.get(0))
                .EnterMiddleName(firstRow.get(1))
                .EnterLastName(firstRow.get(2));

        new CommonSteps(this.driver)
                .clickByText("Save")
                .verifyPageText("Personal Details");
    }

    //Cucumber
    @BeforeMethod
    public static void afterTestMethod(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }

}
