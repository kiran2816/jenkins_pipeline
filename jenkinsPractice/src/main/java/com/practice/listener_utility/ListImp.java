package com.practice.listener_utility;

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
import com.practice.configue_utility.BaseClass;

public class ListImp implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
//		String time = new Date().toString().replace(" ", "/").replace(":", "-");
		String time = String.valueOf(System.currentTimeMillis());
		spark = new ExtentSparkReporter("./reports/myReport" + time + ".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("deepak");
		spark.config().setDocumentTitle("jenkinsReoprts");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "skiped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
