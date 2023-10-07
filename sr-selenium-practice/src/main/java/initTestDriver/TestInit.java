package initTestDriver;

import org.testng.annotations.*;
import common.TestBase;
public class TestInit extends TestBase{

    @BeforeMethod
    public void setupDriver(){
        this.setupBrowser();
    }

    @AfterMethod
    public void tearDownDriver(){
        this.tearDown();
    }
}
