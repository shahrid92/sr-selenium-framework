package common.utilities.listener;

import common.utilities.annotation.CustomAnnotation;
import org.testng.*;

import java.util.Map;
import java.util.TreeMap;

public class actionListener implements IInvokedMethodListener, ITestListener {

    TreeMap<String, String> treeMap = new TreeMap<>();

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("CustomListener1 - After Invocation: " + testResult.getMethod().getMethodName());


    }

    @Override
    public void onFinish(ITestContext context) {
        if(!treeMap.isEmpty()) {
            for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void onStart(ITestContext context) {
        for(ITestNGMethod m1 : context.getAllTestMethods()) {
            CustomAnnotation[] annotations = m1.getConstructorOrMethod().getMethod().getAnnotationsByType(CustomAnnotation.class);
            System.out.println(annotations.length);
            if (annotations.length > 0) {
                for (CustomAnnotation annotation : annotations) {
                    treeMap.put(
                            annotation.key(),
                            annotation.value()
                    );
                }
            } else {
                // Annotation is not present
            }
        }

    }
}
