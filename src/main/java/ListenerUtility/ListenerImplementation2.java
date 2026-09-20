package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import ListenerBaseTest.BaseClass;
import ListenerBaseTest.BaseClass2;

public class ListenerImplementation2 implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Test Excecution Started", true);
		Reporter.log("Total Tests:"+context.getAllTestMethods().length , true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("=====Test Excution Finished======", true);
		Reporter.log("Pass Tests"+context.getPassedTests().size(), true);
		Reporter.log("Failed Tests"+context.getFailedTests().size(), true);
		Reporter.log("Skipped Tests"+context.getSkippedTests().size(), true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName()+" Started====", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName()+" Success =====", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName()+" Failure=====", true);
		
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
		String newdate = sdf.format(d);
		TakesScreenshot ts= (TakesScreenshot)BaseClass2.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./ScreenShots/"+result.getMethod().getMethodName()+"_"+newdate +".png");
		try {
			FileHandler.copy(src, dest);
			Reporter.log("ScreenShot save at: "+dest.getAbsolutePath(), true);
			
		} catch (IOException io) {
			Reporter.log("Failed to save scrrenshot"+io.getMessage(), true);
			
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName()+" Skipped =====", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName() +"Failed But Within Success Percentage =====", true);
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("====="+result.getMethod().getMethodName()+" Test Failed With Timeout ", true);
		
	}

}
