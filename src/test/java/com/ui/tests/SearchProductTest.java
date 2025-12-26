package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed summer Dress";
	
	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("kopit20941@kudimi.com", "password");
	}
	
	@Test(description = "Verify if the Logged In user is able to search for a product and correct Products search results are displayed", groups = { "e2e",
	"sanity" })
	public void verifyProductSearchtest() {
		boolean actualResult = myAccountPage.searchForTheProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}
}
