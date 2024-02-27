import common.utilities.StepsScreenShot;
import common.utilities.annotation.CustomAnnotation;
import common.utilities.testdata.CSVUtils;
import initTestDriver.TestInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    //Cucumber
    @BeforeMethod
    public static void afterTestMethod(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }

}
