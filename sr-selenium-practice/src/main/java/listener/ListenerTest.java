package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Start test....");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("End test....");
    }
}
