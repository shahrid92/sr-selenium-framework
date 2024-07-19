import common.utilities.Context;
import common.utilities.ScenarioContext;
import common.utilities.annotation.CustomAnnotation;
import initTestDriver.TestInit;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AdminPage;
import page.CommonSteps;
import page.LoginPage;
import page.PIMPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static common.utilities.TestEnum.ADMIN_USERNAME_TEXTFIELD;

public class TestRun extends TestInit {

    @Before
    public void runTestNG() {
        this.setupDriver();
    }

    @After
    public void teardown() {
        this.tearDown();
    }

    @Test(enabled = true, dataProvider = "userlist")
    @CustomAnnotation(key = "T1", value = "V1")
    @CustomAnnotation(key = "T2", value = "V2")
    @Given("Users launch browser and login as {string} and {string}")
    public void UserLoginAndNavigateAdminPages(String user, String pass) throws Exception {
        new LoginPage(driver)
                .LoginAction(user, pass)
                .verifyDashboardTitle();

        new CommonSteps(driver)
                .clickByText("Admin")
                .verifyPageText("System Users");
    }

    @Test(enabled = false)
    @Parameters({"userid", "password"})
    public void CreateUsers(String userid, String password) throws Exception {

        new LoginPage(driver)
                .LoginAction(userid, password);

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
    public void AdminAddNewUsersPage() {
        System.out.println("AdminAddNewUsersPage");

        new CommonSteps(this.driver)
                .clickByText("Admin")
                .verifyPageText("System Users")
                .clickByText("Add")
                .verifyPageText("Add User");
    }

    @Then("Enter new user details and save")
    public void AddNewUsers() {

        String firstName = this.scenarioContext.getContext(Context.FIRST_NAME).toString();
        String middleName = this.scenarioContext.getContext(Context.MIDDLE_NAME).toString();
        String lastName = this.scenarioContext.getContext(Context.LAST_NAME).toString();
        String empID = this.scenarioContext.getContext(Context.EMPID).toString();

        new AdminPage(driver)
                .UserRoleSelection();

        new CommonSteps(driver)
                .clickByText("ESS");

        new AdminPage(driver)
                .StatusSelection();

        new CommonSteps(driver)
                .clickByText("Enabled");

        new AdminPage(driver)
                .EnterEmployeeName(firstName + " " + middleName + " " + lastName)
                .SelectEmployeeName()
                .EnterUserName(firstName + "_" + empID);

        new AdminPage(driver).
                EnterPassword("test123123");

        new CommonSteps(driver)
                .clickByText("Save")
                .verifyPageText("Success")
                .verifyPageText("System Users");


    }

    @Then("Navigate to PIM and click add employee")
    public void AddNewEmployee() {

        CommonSteps cm = new CommonSteps(this.driver);


        cm.clickByText("PIM");

        cm.clickByText("Add");
    }


    @And("Fill all new employee names")
    public void EnterEmployeeNames() {

        //to pass paramter table from feature file to step definition method
        //List<String> firstRow = employeeData.get(1);

        String pattern = "HHmmssddMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String empID = simpleDateFormat.format(new Date());

        String firstName = faker.name().firstName();
        String middleName = "Mike";
        String lastName = faker.name().lastName();

        new CommonSteps(this.driver)
                .verifyPageText("Add Employee");

        new PIMPage(this.driver)
                .EnterFirstName(firstName)
                .EnterMiddleName(middleName)
                .EnterLastName(lastName)
                .EnterEmployeeID(empID);

        new CommonSteps(this.driver)
                .clickByText("Save")
                .verifyPageText("Personal Details");

        this.scenarioContext.setContext(Context.FIRST_NAME, firstName);
        this.scenarioContext.setContext(Context.MIDDLE_NAME, middleName);
        this.scenarioContext.setContext(Context.LAST_NAME, lastName);
        this.scenarioContext.setContext(Context.EMPID, empID);
    }

    @And("Enter new created username search text-field")
    public void EnterNewCreatedUserName() {

        String firstName = this.scenarioContext.getContext(Context.FIRST_NAME).toString();
        String middleName = this.scenarioContext.getContext(Context.MIDDLE_NAME).toString();
        String lastName = this.scenarioContext.getContext(Context.LAST_NAME).toString();

        new CommonSteps(this.driver)
                .verifyPageText("System Users");

        new PIMPage(this.driver)
                .EnterEmployeeName(firstName + middleName +lastName );
    }

    @Then("Navigate to {string} page")
    public void NavigatePage(String page){
        new CommonSteps(this.driver)
                .verifyPageText(page);
    }

    @And("Search employee username and validate user exists")
    public void SearchEmployeeUsername(DataTable emp_username){
        AdminPage ap = new AdminPage(this.driver);
        String username = null;
        List<Map<String, String>> employeeList = emp_username.asMaps(String.class, String.class);
        for (Map<String, String> employee : employeeList) {
            username = employee.get("employee_username");
        }

        ap.EnterSearchUsername(username);

        new CommonSteps(this.driver)
                .clickByText("Search");

        ap.validateRecordFoundUsername(username);
    }

    //Cucumber
    @BeforeMethod
    public static void afterTestMethod(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }


}
