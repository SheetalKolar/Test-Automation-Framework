package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase{
	
	private static final String INVALID_EMAIL_ADDRESS ="abc@gmail.com";
	private static final String INVALID_PASSWORD = "QWERTY123";

    @Test(description = " Verifies if the proper error message is shown for the user when they enter invalid credentials", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(),"Authentication failed.");
	}

}
