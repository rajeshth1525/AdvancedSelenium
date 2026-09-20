package ListenerUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ListenerBaseTest.BaseClass2;

public class ExtentReportListener implements ITestListener{
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		// Current date-time string (safe for file name)
		Date d= new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		
		//Creat HTMl Report path → SuiteName + Date
		spark= new ExtentSparkReporter("./ExtentsReports/"+context.getName()+"_"+newdate+".html");
		//Configuration change look and feel the report
		spark.config().setDocumentTitle("Automation Testing"); //set the browser title
		spark.config().setReportName("Souce Demo test");// Report heading
		spark.config().setTheme(Theme.DARK);//Dark them to look
		
		//Intialize main report object
		report= new ExtentReports();
		// Attaches the SparkReporter to ExtentReports → ensures HTML file is generated
		report.attachReporter(spark);
		
		// Extra info in report
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Tester", "Rajesh");
		report.setSystemInfo("Browser", "Edge");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		test=report.createTest(tcName);
		test.log(Status.INFO, "Test started: "+tcName);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
		String newdate = sdf.format(d);
		try {
			TakesScreenshot ts=(TakesScreenshot)BaseClass2.sdriver;
			String src = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(src, tcName+"_"+newdate);
			
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Screenshot not Cpture"+e.getMessage());
			
		}
		test.log(Status.FAIL, "====="+tcName+" Failure====");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "Test skip: "+tcName);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
