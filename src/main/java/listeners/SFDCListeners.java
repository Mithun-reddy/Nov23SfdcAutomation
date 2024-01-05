package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		BaseTest.test = BaseTest.extent.createTest(result.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		BaseTest.threadExtentTest.get().pass(MarkupHelper.createLabel("PASSED "+result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED "+result.getName(), ExtentColor.RED));
		
	}


}
