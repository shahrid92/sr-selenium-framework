import common.utilities.Context;
import common.utilities.RetryAnalyzer;
import common.utilities.ScenarioContext;
import common.utilities.annotation.CustomAnnotation;
import initTestDriver.TestInit;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AdminPage;
import page.CommonSteps;
import page.LoginPage;
import page.PIMPage;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Epic("Web Application Regression Testing")
@Feature("orange hrm")
public class TestRun extends TestInit {

    @Before
    public void runTestNG() {
        this.setupDriver();
    }

    @After
    public void teardown() {
        this.tearDown();
    }

    @Test
    public void TestRun2(){
        try{
            Thread.sleep(10000);
            System.out.println("Test Run 2 Executed");
        }catch(Exception ex){
            System.out.println("Test Run 2 NOt Executed");
        }

    }

    @Test(enabled = true, dataProvider = "userlist",retryAnalyzer = RetryAnalyzer.class)
    @CustomAnnotation(key = "T1", value = "V1")
    @CustomAnnotation(key = "T2", value = "V2")
    @Given("Users launch browser and login as {string} and {string}")
    @Step("User Login")
    public void UserLoginAndNavigateAdminPages(String user, String pass) {

        new LoginPage(driver.get())
                .LoginAction(user, pass)
                .verifyDashboardTitle();

        new CommonSteps(driver.get())
                .clickByText("Admin")
                .verifyPageText("System Users");
    }

    @Test(enabled = false)
    @Parameters({"userid", "password"})
    public void CreateUsers(String userid, String password) {
        System.out.println("TEST 2");
        new LoginPage(driver.get())
                .LoginAction(userid, password);

        new CommonSteps(driver.get())
                .clickByText("Admin")
                .verifyPageText("System Users")
                .clickByText("Add")
                .verifyPageText("Add User");

        new AdminPage(driver.get())
                .UserRoleSelection();

        new CommonSteps(driver.get())
                .clickByText("ESS");

        new AdminPage(driver.get())
                .StatusSelection();

        new CommonSteps(driver.get())
                .clickByText("Enabled");

        new AdminPage(driver.get())
                .EnterEmployeeName("Test01");

    }

    @Then("Navigate admin page and click Add User")
    public void AdminAddNewUsersPage() {
        System.out.println("AdminAddNewUsersPage");

        new CommonSteps(this.driver.get())
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

        new AdminPage(driver.get())
                .UserRoleSelection();

        new CommonSteps(driver.get())
                .clickByText("ESS");

        new AdminPage(driver.get())
                .StatusSelection();

        new CommonSteps(driver.get())
                .clickByText("Enabled");

        new AdminPage(driver.get())
                .EnterEmployeeName(firstName + " " + middleName + " " + lastName)
                .SelectEmployeeName()
                .EnterUserName(firstName + "_" + empID);

        new AdminPage(driver.get()).
                EnterPassword("test123123");

        new CommonSteps(driver.get())
                .clickByText("Save")
                .verifyPageText("Success")
                .verifyPageText("System Users");


    }

    @Then("Navigate to PIM and click add employee")
    public void AddNewEmployee() {

        CommonSteps cm = new CommonSteps(this.driver.get());


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

        new CommonSteps(this.driver.get())
                .verifyPageText("Add Employee");

        new PIMPage(this.driver.get())
                .EnterFirstName(firstName)
                .EnterMiddleName(middleName)
                .EnterLastName(lastName)
                .EnterEmployeeID(empID);

        new CommonSteps(this.driver.get())
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

        new CommonSteps(this.driver.get())
                .verifyPageText("System Users");

        new PIMPage(this.driver.get())
                .EnterEmployeeName(firstName + middleName +lastName );
    }

    @Then("Navigate to {string} page")
    @Step("Navigate page")
    public void NavigatePage(String page){

        new CommonSteps(this.driver.get())
                .clickByText(page)
                .verifyPageText(page);
    }

    @And("Search this employee name")
    public void PIMSearchEmployeeName(DataTable empName){

        List<String> al = empName.asList();
        PIMPage p = new PIMPage(this.driver.get());
        for(String a : al){
            p.searchEmpName(a);
        }

        new CommonSteps(this.driver.get())
                .clickByText("Search");

    }

    @Then("Click user for edit")
    public void PIMEditButton(){
        new PIMPage(this.driver.get())
                .clickEditButton();

        new CommonSteps(this.driver.get())
                .verifyPageText("Personal Details");
    }



    @And("Select user role {string}")
    public void selectUserRole(String role){
        AdminPage ap = new AdminPage(this.driver.get());
        ap.selectbyUserRole(role);
        new CommonSteps(this.driver.get()).clickByText(role);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @And("Navigate subpage and verify page titles")
    @Step("NAvigate subpage and verify")
    public void NavigateSubPage(DataTable path){

        CommonSteps cs = new CommonSteps(this.driver.get());

        List<Map<String, String>> p = path.asMaps(String.class, String.class);

        for (Map<String, String> pp : p){
            String[] result = pp.get("Path").split("/");
            for (String a : result){
                cs.clickByText(a);
            }
            cs.verifyPageText(pp.get("Title"));
        }





    }

    @And("Search employee username and validate user exists")
    public void SearchEmployeeUsername(DataTable emp_username){
        AdminPage ap = new AdminPage(this.driver.get());
        String username = null;
        List<Map<String, String>> employeeList = emp_username.asMaps(String.class, String.class);
        for (Map<String, String> employee : employeeList) {
            username = employee.get("employee_username");
        }

        ap.EnterSearchUsername(username);

        new CommonSteps(this.driver.get())
                .clickByText("Search");

        ap.validateRecordFoundUsername(username);
    }

    @And("Click edit found users")
    public void clickEdit(){
        AdminPage ap = new AdminPage(this.driver.get());
        ap.clickEdit();
    }

    @When("admin user at {string} page")
    public void userNavigateTo(String page){
        new CommonSteps(this.driver.get())
                .clickByText("PIM")
                .clickByText(page);
    }

    @Then("admin fill report name as {string}")
    public void setReportName(String reportName){
        new PIMPage(this.driver.get())
                .setReportNameAs(reportName);
    }

    @And("add selection criteria as below")
    public void selectCriterion(List<Map<String, String>> criteria){
        for(Map<String,String> e:criteria){
            new PIMPage(this.driver.get())
                    .selectCriterion(e.get("Select1"),e.get("Select2"));
        }
    }

    @And("select display fields as below")
    public void selectDisplayFields(List<Map<String, String>> fields){
        for(Map<String,String> f:fields){
            new PIMPage(this.driver.get())
                    .selectDisplayFieldGroup(f.get("Field Group"),f.get("Display Field"));
        }

        new CommonSteps(this.driver.get())
                .clickByText("Save");

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Then("Verify new report title name is {string}")
    public void verifyReportTitle(String text){
        new CommonSteps(this.driver.get())
                .verifyPageText(text);
    }



    //Cucumber
//    @BeforeMethod
//    public static void afterTestMethod(ITestResult result) {
//        System.out.println(result.getMethod().getMethodName());
//    }


}
