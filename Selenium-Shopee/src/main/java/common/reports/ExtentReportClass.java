package common.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {

    private ExtentTest test;
    private ExtentReports extent;

    public ExtentReportClass(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    public ExtentTest getTest() {
        return test;
    }

    public void setTest(ExtentTest test) {
        this.test = test;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public void pass(String pass){
        this.test.pass(pass);
    }

    public void info(String info){
        this.test.info(info);
    }

    public void setExtent(ExtentReports extent) {
        this.extent = extent;
    }
}
