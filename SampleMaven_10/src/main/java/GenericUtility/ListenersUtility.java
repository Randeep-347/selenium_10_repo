package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenersUtility extends BaseClass implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		String methodName= result.getName();//getName is non Static method of ITestResult Interface. We use getName() 
		test= extReports.createTest(methodName);//and pass the ref to createTest(methodName) instead of Test case name to pass the running method.
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+"is failed");
		TakesScreenshot ts= (TakesScreenshot) driver;
		String screenshot= ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
		
		try {
			wUtil.getScreenshot(driver);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
