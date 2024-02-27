package initTestDriver;

import common.utilities.testdata.CSVUtils;
import org.testng.annotations.*;
import common.TestBase;



public class TestInit extends TestBase {

    @BeforeMethod
    public void setupDriver(){

        this.setupBrowser();
    }

    @AfterMethod
    public void tearDownDriver(){
        this.tearDown();
    }

    @DataProvider
    public Object[][] userlist() throws Exception{

        Object[][] testObjArray = CSVUtils.getTableArray("src/test/resources/test.csv");

        return (testObjArray);

    }
}
