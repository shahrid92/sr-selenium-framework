import initTestDriver.TestInit;
import org.testng.annotations.Test;

public class TestRun extends TestInit {

    @Test
    public void testRun(){
        System.out.println(driver.getTitle());
    }
}
