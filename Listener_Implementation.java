package CommonUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_Implementation  implements ITestListener {

	ExtentReports report;
	
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//System.out.println("Testscript excution is started");
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excecution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excecution is Passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excecution is Failed"+message);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excecution is Skipped",true);
		
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
		JavaUtil jUtil = new JavaUtil();
		//Use ExtentSparkReporter class just to configure extent report
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Mumbai");
		
		//Use ExtentReports to generate extentreport
	    report = new  ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Linux");
		report.setSystemInfo("Browser", "Firefox");
		report.setSystemInfo("Firefoxversion", "122");
		report.setSystemInfo("Author", "Piyu");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		report.flush();
		
		
	}
	

}
