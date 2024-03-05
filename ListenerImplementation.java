package CommonUtils;



import org.testng.ITestContext;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+" Testscript execution is passed", true);
//		Test.
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is failed "+message, true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is skiped", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
//		Reporter.log("execution is start", true);
		
		//create the object of ExtentSparkReporter
		//use ExtentSparkReporter class just to configure extent report 
		
		JavaUtil j = new JavaUtil();
		
		
		ExtentSparkReporter repoter = new ExtentSparkReporter("./extentreport/report"+j.getRandomNumber()+".html");
		repoter.config().setDocumentTitle("vtigerCrm");
		repoter.config().setTheme(Theme.DARK);
		repoter.config().setReportName("Organization");
		
		//create object of ExtentReports class
		//use ExtentReports class to generate extent report
		report = new ExtentReports();
		report.attachReporter(repoter);
		report.setSystemInfo("os", "window 11");
		report.setSystemInfo("browser", "Chrome");
		report.setSystemInfo("chromeversion", "122");
		report.setSystemInfo("Author", "AJAY");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		Reporter.log("execution is finish", true);
	
		report.flush();
	}

}
