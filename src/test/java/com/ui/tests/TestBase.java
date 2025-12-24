package com.ui.tests;

import static com.constants.Browser.CHROME;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@BeforeMethod(description = "Load the Homepage of the website")
	@Parameters({"browser","isLambdaTest", "isHeadless"})
	public void setup(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("true") boolean isHeadless, Method method) {
		
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, method.getName());
			homePage = new HomePage(lambdaDriver);
		}

		else {
			logger.info("Load the Homepage of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

//	@AfterMethod(description = "Tear Down the browser")
//	public void tearDown() {
//		if (isLambdaTest) {
//			LambdaTestUtility.quitSession();
//		}
//	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    try {
	        if (isLambdaTest) {
	            LambdaTestUtility.quitSession();
	        } else if (homePage != null) {
	            homePage.quitDriver();
	        }
	    } catch (Exception e) {
	        logger.error("Error during teardown", e);
	    }
	}


}
