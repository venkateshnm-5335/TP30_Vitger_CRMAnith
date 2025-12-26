
package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentationClass implements ITestListener,ISuiteListener{
	ExtentReports report;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ISuite suite) {
		//configuration
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+new JavaUtils().sysDateAndTime()+".html");
		htmlreport.config().setDocumentTitle("Vitiger-30");
		htmlreport.config().setTheme(Theme.DARK); 
		htmlreport.config().setReportName("Vtiger");

		//contents in html we are customizing here
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Venkatesh NM");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName(); 
		test = report.createTest(methodName);
		extentTest.set(test);
		extentTest.get().log(Status.INFO, "<i>"+methodName+" ------>Execution Starts<i/>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS,"<b>"+ methodName+" ------>passed</>");
	}  

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String methodname=result.getMethod().getMethodName();

			TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(".\\screenshotli\\"+methodname+new JavaUtils().sysDateAndTime()+".png");
			FileUtils.copyFile(src, dst);
			String path=dst.getAbsolutePath();
			test.addScreenCaptureFromPath(path);

			extentTest.get().log(Status.FAIL, result.getThrowable());
			extentTest.get().log(Status.FAIL,"<b>"+methodname+" ------>Failed</b>");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getTestClass().getName();
		if (result.wasRetried()) {
			extentTest.get().log(Status.WARNING, "<b>"+testName+" failed, but Retrying... (Attempt " +
					((RetryImpUtils)result.getMethod().getRetryAnalyzer(result)).count + ")</b>");
		} else {
			extentTest.get().log(Status.SKIP, "<b>"+testName+" ------>has been Skipped</b>");
		}    
	}
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}


}
//
//package genericLibraries;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ISuite;
//import org.testng.ISuiteListener;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//
//public class ListenersImplimentationClass extends BaseClass implements ITestListener, ISuiteListener {
//    public static ThreadLocal<ExtentTest> testthread = new ThreadLocal<>();
//    public ExtentReports report;
//    public ExtentSparkReporter spark;
//
//    @Override
//    public void onStart(ISuite suite) {
//        String time = new JavaUtils().sysDateAndTime().replace(" ", "").replace(":", "");
//        spark = new ExtentSparkReporter("./ExtentReporter/report_" + time + ".html");
//        spark.config().setDocumentTitle("Report");
//        spark.config().setReportName("VTiger CRM Reports");
//        spark.config().setTheme(Theme.DARK);
//        report = new ExtentReports();
//        report.attachReporter(spark);
//        report.setSystemInfo("os", "windows10");
//        report.setSystemInfo("browser", "edge");
//        report.setSystemInfo("base_url", "http://localhost:8888/");
//        report.setSystemInfo("reporter", "arjun");
//    }
//
//    @Override
//    public void onFinish(ISuite suite) {
//        report.flush();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest test = report.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName());
//        testthread.set(test);
//        testthread.get().log(Status.INFO, "===Execution has started");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        testthread.get().log(Status.PASS, "===Execution was Successful");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        String testname = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();
//        String time = new JavaUtils().sysDateAndTime().replace(" ", "").replace(":", "");
//        TakesScreenshot ts = (TakesScreenshot) sdriver;
//        String file = ts.getScreenshotAs(OutputType.BASE64);
//        testthread.get().addScreenCaptureFromBase64String(file, testname + time);
//        testthread.get().log(Status.FAIL, "===Execution Failed");
//        testthread.get().log(Status.FAIL, result.getThrowable());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        testthread.get().log(Status.SKIP, "===Execution has been Skipped");
//    }
//}


